//
//  SpeedTests.m
//  SpeedTests
//
//  Created by carmne on 2018/2/1.
//  Copyright © 2018年 lessismore. All rights reserved.
//

#import <XCTest/XCTest.h>

@interface SpeedTests : XCTestCase

@end

@implementation SpeedTests

- (void)setUp {
    [super setUp];
    // Put setup code here. This method is called before the invocation of each test method in the class.
}

- (void)tearDown {
    // Put teardown code here. This method is called after the invocation of each test method in the class.
    [super tearDown];
}

- (void)testExample {
    // This is an example of a functional test case.
    // Use XCTAssert and related functions to verify your tests produce the correct results.
}

- (void)testPerformanceExample {
    // This is an example of a performance test case.
    [self measureBlock:^{
        // Put the code you want to measure the time of here.
    }];
}

@end
