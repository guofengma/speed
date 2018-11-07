package com.lessismore.speed.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/2/7.
 */

public class AndroidToJs{
    private Context mContext;
    public AndroidToJs(Context context) {
        mContext = context;
    }

    @JavascriptInterface
    public void hello(String msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
    }


}
