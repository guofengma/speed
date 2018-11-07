//
//  APIRequest.h
//  SanYouDemo
//
//  Created by hwg on 15/9/22.
//  Copyright © 2015年 sanyou. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface APIRequest : AFHTTPSessionManager
+(instancetype)sharedClient;
+(void)get:(NSString *)url params:(NSDictionary *)params success:(void (^)(id responseObj))success failure:(void (^)(id NSDictionary))failure;

+(void)post:(NSString *)url params:(NSDictionary *)params success:(void (^)(id responseObj))success failure:(void (^)(id NSDictionary))failure;

+(void)postHtml:(NSString *)url params:(NSDictionary *)params success:(void (^)(id responseObj))success failure:(void (^)(id NSDictionary))failure;

+(void)postHtmlOperationManager:(NSString *)url params:(NSDictionary *)params success:(void (^)(id responseObj))success failure:(void (^)(id NSDictionary))failure;

+ (void)postWithURL:(NSString *)url params:(NSDictionary *)params formDataArray:(NSArray *)formDataArray success:(void (^)(id))success failure:(void (^)(NSError *))failure;
+(void)showNetworkError:(NSDictionary *)dict;
+(void)AFNetworkingErrorDomain:(NSDictionary *) dict;

@end

@interface IWFormData : NSObject
@property (nonatomic, strong) NSData *data;
@property (nonatomic, copy) NSString *name;
@property (nonatomic, copy) NSString *filename;
@property (nonatomic, copy) NSString *mimeType;
@end
