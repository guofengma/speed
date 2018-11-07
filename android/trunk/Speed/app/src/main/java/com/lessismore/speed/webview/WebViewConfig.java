package com.lessismore.speed.webview;

import android.content.Context;
import android.net.http.SslError;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 2018/2/7.
 */

public class WebViewConfig {
    private Context context;
    private WebView webView;
    private InnerWebChromeClient webChromeClient = new InnerWebChromeClient();
    private InnerWebViewClient innerWebViewClient = new InnerWebViewClient();

    public WebViewConfig(Context context,WebView webView) {
        this.webView = webView;
        this.context = context;
    }

    public void init(){
        //WebView允许调试
        if (Build.VERSION.SDK_INT > 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        //配置WebView
        webView.setWebChromeClient(new InnerWebChromeClient());
        webView.setWebViewClient(new InnerWebViewClient());
        webView.addJavascriptInterface(new AndroidToJs(context),"native");
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
                    // 返回键退回
                    webView.goBack();
                    return true;
                } else
                    return false;
            }
        });
        //配置WebSettings
        configWebSettings(webView.getSettings());

    }

    private void configWebSettings(WebSettings setting){
        setting.setJavaScriptEnabled(true);
        setting.setDomStorageEnabled(true);
    }



    class InnerWebChromeClient extends WebChromeClient{
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, "提示", message, result);
        }

    }

    class InnerWebViewClient extends WebViewClient{
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            //super.onReceivedSslError(view, handler, error);
            handler.proceed();//忽略证书异常，继续加载
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("http")){
                view.loadUrl(url);
            }
            return true;
        }
    }
}
