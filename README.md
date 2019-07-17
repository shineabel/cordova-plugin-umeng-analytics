# cordova-plugin-umeng-analytics
集成了官方最新版本的SDK

##Requirements

 - iOS 7 or higher

##Installation

    cordova plugin add cordova-plugin-umeng-analytics  --variable UMENGKEYIOS=这里填写友盟key --variable UMENGKEYANDROID=这里填写友盟key

##Antention
For iOS:
AppDelegate.m file:
```

 #import "UMCommonModule.h" 
 #import <UMCommon/UMCommon.h> 
 #import <UMAnalytics/MobClick.h>

@implementation AppDelegate

- (BOOL)application:(UIApplication*)application didFinishLaunchingWithOptions:(NSDictionary*)launchOptions
{
    self.viewController = [[MainViewController alloc] init]; 
 [UMConfigure setLogEnabled:YES];
 [UMCommonModule initWithAppkey:@"具体key"channel:@"Umeng"]; 
 [MobClick setScenarioType:E_UM_NORMAL];
    return [super application:application didFinishLaunchingWithOptions:launchOptions];
}  
@end
```

For Android:
MainActivity.java
```
 import com.umeng.analytics.MobclickAgent; 
 import com.umeng.commonsdk.UMConfigure; 
 import com.umeng.plugin.PGCommonSDK;

    @Override 
     public void onResume() { 
        super.onResume();
        MobclickAgent.onResume(this);
     } 

     @Override 
     protected void onPause() { 
       super.onPause(); 
       MobclickAgent.onPause(this);
    } 

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // enable Cordova apps to be started in the background
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }

        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
        UMConfigure.setLogEnabled(true); 
        PGCommonSDK.init(this,"具体key","Umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        //MobclickAgent.setSessionContinueMillis(1000);
        //MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_DUM_NORMAL);
    }

 ``` 