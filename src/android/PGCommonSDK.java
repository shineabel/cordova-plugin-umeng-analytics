package com.umeng.plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.content.Context;
import android.util.Log;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by wangfei on 17/9/28.
 */

public class PGCommonSDK {
    public static void init(Context context, String appkey, String channel, int type, String secret){
        initCocos("phonegap","2.0");
        UMConfigure.init(context,appkey,channel,type,secret);
        //NOTE(shineabel)下面这句话很重要：因为PhoneGap应用只有唯一的一个宿主MainActivity，所以要手动统计，github上（包括Umeng官方demo）都没写这一句，会造成Android应用页面访问路径始终没有数据
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.LEGACY_MANUAL);
    }
    public static void initCocos(String v,String t){

        Method method = null;
        try {

            Class<?> config = Class.forName("com.umeng.commonsdk.UMConfigure");
            method = config.getDeclaredMethod("setWraperType", String.class, String.class);
            method.setAccessible(true);
            method.invoke(null, v,t);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
