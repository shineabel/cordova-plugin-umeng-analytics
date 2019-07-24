//
//  UMCommonModule.m
//  PhoneGap_Component
//
//  Created by wangfei on 2017/10/11.
//

#import "UMCommonModule.h"

@implementation UMCommonModule
+ (void)initWithAppkey:(NSString *)appkey channel:(NSString *)channel
{
    
    SEL sel = NSSelectorFromString(@"setWraperType:wrapperVersion:");
    if ([UMConfigure respondsToSelector:sel]) {
        [UMConfigure performSelector:sel withObject:@"phonegap" withObject:@"2.0"];
    }
    NSString *deviceID =[UMConfigure deviceIDForIntegration];
    NSLog(@"集成测试的deviceID:%@", deviceID);
    [UMConfigure initWithAppkey:appkey channel:channel];
}
@end
