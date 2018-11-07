//
//  CommonUtils.h
//
//  Created by WenGuangHuang on 16/4/6.
//  Copyright © 2016年 WenGuangHuang. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#include <sys/types.h>
#include <sys/sysctl.h>

@interface CommonUtils : NSObject

+(float)IOSVersion;
+(BOOL)isIOS8;
+(BOOL)isIOS7;
+(CGRect)resizeViewBoundsforTable:(CGRect)bounds withNavBarHeight:(float)height;
+ (id)StringtoArrayOrNSDictionary:(NSString *)strJson;
+(BOOL) isEmptyString:(NSString *) string;
+(UIColor *)translateHexStringToColor:(NSString *)hexColor;
+(id)conversionDataFormat:(id)JSON;
+(NSString *)stringFromDateString:(NSString *)str withFormat:(NSString *)format;
+(NSString *)stringFromDate:(NSDate *)date withFormat:(NSString *)format;
+(NSString *)models;

@end
