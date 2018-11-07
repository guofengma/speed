//
//  NSString+SY.m
//  SanYouDemo
//
//  Created by hwg on 15/9/22.
//  Copyright (c) 2015年 sanyou. All rights reserved.
//

#import "NSString+Str.h"

@implementation NSString (Str)
- (BOOL) isEmptyString{
    return [self length] == 0  || ([[self trim] isEqualToString:@""]) ? YES : NO;
}

- (NSString *) trim{
    if (nil == self) return nil;
    
    NSCharacterSet *whitespace = [NSCharacterSet whitespaceAndNewlineCharacterSet];
    return [self stringByTrimmingCharactersInSet:whitespace];
}
@end
