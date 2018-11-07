//
//  APIRequest.m
//  SanYouDemo
//
//  Created by hwg on 15/9/22.
//  Copyright © 2015年 sanyou. All rights reserved.
//

#import "APIRequest.h"

static APIRequest *_sharedClient;
@implementation APIRequest
- (instancetype)init
{
    self = [super init];
    if (self) {
        
    }
    return self;
}
+(instancetype)sharedClient {
    
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        [_sharedClient.requestSerializer setTimeoutInterval:kWebViewDefaultTimeOut];
        _sharedClient.securityPolicy = [AFSecurityPolicy policyWithPinningMode:AFSSLPinningModeNone];
      _sharedClient.responseSerializer.acceptableContentTypes=[NSSet setWithObject:@"text/html"];
        _sharedClient.responseSerializer=[AFHTTPResponseSerializer serializer];
        _sharedClient.requestSerializer=[AFHTTPRequestSerializer serializer];
        _sharedClient = [[APIRequest alloc] init];
      
    });
    return _sharedClient;
}
- (id)copyWithZone:(NSZone *)zone
{
    return _sharedClient;
}

+(void)post:(NSString *)url params:(NSDictionary *)params success:(void (^)(id responseObj))success failure:(void (^)(id NSDictionary))failure
{

    NSLog(@"url__%@",url);
    
    NSURLSessionTask *task=[[APIRequest sharedClient] POST:url parameters:[self setDicttionary:params] success:^(NSURLSessionDataTask *task, id JSON)
                            {
                                
                                if([self APISuccess:JSON])
                                {
                                    success(JSON);
                                }else
                                {
                                    failure(JSON);

                                }
                            } failure:^(NSURLSessionDataTask *task, NSError *error) {
                                   failure([self addDictionary:error]);
   
                            }];
    [task resume];
 
}

+(void)postHtml:(NSString *)url params:(NSDictionary *)params success:(void (^)(id responseObj))success failure:(void (^)(id NSDictionary))failure
{
    NSLog(@"url__%@",url);
    NSURLSessionTask *task=[[APIRequest sharedClient] POST:url parameters:params success:^(NSURLSessionDataTask *task, id JSON)
                            {
                                JSON=[CommonUtils conversionDataFormat:JSON];
                                if([self APISuccess:JSON])
                                {
                                    success(JSON);
                                }else
                                {
                                    failure(JSON);
                                    
                                }
                            } failure:^(NSURLSessionDataTask *task, NSError *error) {
                                failure([self addDictionary:error]);
                            }];
    [task resume];

}
+(void)get:(NSString *)url params:(NSDictionary *)params success:(void (^)(id responseObj))success failure:(void (^)(id NSDictionary))failure
{

    NSURLSessionTask *task=[[APIRequest sharedClient] GET:url parameters:[self setDicttionary:params] success:^(NSURLSessionDataTask *task, id JSON)
                            {
                                if([self APISuccess:JSON])
                                {
                                    success(JSON);
                                }else
                                {
                                    failure(JSON);
 
                                }
                            } failure:^(NSURLSessionDataTask *task, NSError *error) {
                             
                                failure([self addDictionary:error]);
                                
                            }];
    [task resume];


}
+(void)postHtmlOperationManager:(NSString *)url params:(NSDictionary *)params success:(void (^)(id responseObj))success failure:(void (^)(id NSDictionary))failure
{

    
    AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
    manager.requestSerializer = [AFHTTPRequestSerializer serializer];
    manager.responseSerializer = [AFHTTPResponseSerializer serializer];
    
    [manager POST:url parameters:params success:^(NSURLSessionDataTask *operation, id responseObject)
     {
         if([self APISuccess:responseObject])
         {
             success(responseObject);
         }else
         {
             failure(responseObject);
         }
     }failure:^(NSURLSessionDataTask *operation, NSError *error)
     {
            failure([self addDictionary:error]);
     }];
}
+ (void)postWithURL:(NSString *)url params:(NSDictionary *)params formDataArray:(NSArray *)formDataArray success:(void (^)(id responseObj))success failure:(void (^)(NSError * error))failure
{
    AFHTTPSessionManager *mgr = [AFHTTPSessionManager manager];
    [mgr POST:url parameters:params constructingBodyWithBlock:^(id<AFMultipartFormData> totalFormData) {
        for (IWFormData *formData in formDataArray) {
            [totalFormData appendPartWithFileData:formData.data name:formData.name fileName:formData.filename mimeType:formData.mimeType];
        }
    } success:^(NSURLSessionDataTask *operation, id responseObject) {
        if (success) {
            success(responseObject);
        }
    } failure:^(NSURLSessionDataTask *operation, NSError *error) {
        if (failure) {
            failure(error);
        }
    }];
}
+(NSDictionary *)setDicttionary:(NSDictionary *)params
{

   NSMutableDictionary *tempDic=[NSMutableDictionary dictionaryWithDictionary:params];
    [tempDic setObject:kPlatform forKey:@"platform"];
    
    [tempDic setObject:[CommonUtils models] forKey:@"models"];
    [tempDic setObject: [[UIDevice currentDevice] systemVersion] forKey:@"systemVersion"];
     [tempDic setObject: kAppVersion forKey:@"appVersion"];

     return [NSDictionary dictionaryWithDictionary:tempDic];
 
}


+(NSDictionary *)addDictionary:(NSError *)error
{
    NSDictionary *dic=error.userInfo;
    NSMutableDictionary *tempDic=[NSMutableDictionary dictionaryWithDictionary:dic];
    [tempDic setObject:[NSString stringWithFormat:@"%i",(int)error.code] forKey:@"Code"];
    return [NSDictionary dictionaryWithDictionary:tempDic];
}

+(BOOL) APISuccess:(NSDictionary *) dic{
    if (dic == nil) return NO;
    if ([dic objectForKey:@"status"] == nil){
        
        return NO;
    }
    if ([[dic valueForKey:@"status"] intValue] ==1){
        return YES;
    }
    return NO;
}


+(NSInteger ) APIErrorCode:(NSDictionary *) dic{
    if (dic == nil) return -1;
    if ([dic objectForKey:@"status"] == nil){
        return -1;
    }
    return [[dic valueForKey:@"status"] intValue];
}

+(void)showNetworkError:(NSDictionary *)dict
{
    
    if ([[dict allKeys] containsObject:@"status"])
    {
          [[BaseViewController sharedBase] showErrorWithText:[dict valueForKey:@"message"]];
        //[[dict valueForKey:@"message"] intValue];

    }else
    {
        [self AFNetworkingErrorDomain:dict];
    }
    return;
    
}

+(void)AFNetworkingErrorDomain:(NSDictionary *) dict
{

    int code=[[dict objectForKey:@"Code"] intValue];
    switch (code) {
        case -1001:
        {
            [[BaseViewController sharedBase] showErrorWithText:@"网络连接不稳定，请稍后重试"];
        }
            break;
            
        default:
        {
            NSString *error=[NSString stringWithFormat:@"网络错误:%i",code];
                [[BaseViewController sharedBase] showErrorWithText:error];
        }
            break;
    }
}



@end
@implementation IWFormData

@end
