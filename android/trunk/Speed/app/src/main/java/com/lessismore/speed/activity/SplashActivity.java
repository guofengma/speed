package com.lessismore.speed.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.mediacompat.BuildConfig;
import android.util.Log;

import com.lessismore.speed.R;
import com.lessismore.speed.util.SharedPreferencesUtils;

//启动页
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 判断是否是第一次开启应用
        boolean isFirstOpen;

        if (BuildConfig.DEBUG){
            isFirstOpen = false;
        }else {
            isFirstOpen = (boolean) SharedPreferencesUtils.get(this,"isFirstOpen",true);
        }
        Log.d("BuildConfig",BuildConfig.DEBUG+"");
        //如果首次运行
        if (isFirstOpen){
            this.startActivity(new Intent(this,GuideActivity.class));
            this.finish();
        }else {
            setContentView(R.layout.activity_splash);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    SplashActivity.this.finish();
                }
            }, 2000);
        }
    }
}
