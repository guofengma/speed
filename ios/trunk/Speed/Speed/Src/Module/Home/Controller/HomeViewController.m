//
//  HomeViewController.m
//  imageZoom
//
//  Created by WenGuangHuang on 16/4/6.
//  Copyright © 2016年 WenGuangHuang. All rights reserved.
//
//设备宽高
#define kDeviceWidth [UIScreen mainScreen].bounds.size.width
#define KDeviceHeight [UIScreen mainScreen].bounds.size.height
#import "HomeViewController.h"
#import "WebViewViewController.h"
@interface HomeViewController ()<UIGestureRecognizerDelegate>

@end

@implementation HomeViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    //https://www.nicholeyep.com:8455/speed/
    WebViewViewController * web = [[WebViewViewController alloc] initWithURLString:@"https://www.baidu.com"];
     web.view.frame= CGRectMake(0, 0, kDeviceWidth, KDeviceHeight-49);

    [self.navigationController pushViewController:web animated:YES];
}

@end
