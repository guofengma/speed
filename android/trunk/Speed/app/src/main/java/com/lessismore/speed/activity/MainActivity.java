package com.lessismore.speed.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.webkit.WebView;

import com.lessismore.speed.R;
import com.lessismore.speed.webview.WebViewConfig;

public class MainActivity extends BaseActivity {
    private boolean isContinue = false;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWebView();
    }

    private void initWebView() {
        webView = (WebView) findViewById(R.id.webView);
        WebViewConfig webViewConfig = new WebViewConfig(this,webView);
        webViewConfig.init();

        webView.loadUrl("https://www.nicholeyep.com:8455/speed/");



    }


    /**
     * 获取消失的动画
     *
     * @param context
     * @return
     */
    private AnimationSet getDismissAnim(Context context) {
        AnimationSet dismiss = new AnimationSet(context, null);
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.0f);
        alpha.setDuration(1000);
        dismiss.addAnimation(alpha);
        return dismiss;
    }
}
