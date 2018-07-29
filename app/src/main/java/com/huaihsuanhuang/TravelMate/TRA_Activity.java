package com.huaihsuanhuang.TravelMate;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class TRA_Activity extends AppCompatActivity {


    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra);
        //Intent intent = getIntent();

        myWebView =  findViewById(R.id.tra_webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.requestFocus();
        myWebView.setWebViewClient(new MyWebViewClient());
        myWebView.loadUrl("http://twtraffic.tra.gov.tw/twrail/EN_QuickSearch.aspx");


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);

                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
    public boolean onKeyDown(int keyCoder, KeyEvent event) {
        if (myWebView.canGoBack() && keyCoder == KeyEvent.KEYCODE_BACK) {
            myWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            myWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCoder, event);
    }
}
