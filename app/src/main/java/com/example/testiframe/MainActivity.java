package com.example.testiframe;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView mywebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mywebView = (WebView) findViewById(R.id.webview);
        mywebView.setWebViewClient(new WebViewClient());
        //String myurl = "https://msecure.epayco.io/v1/transaction/payment.html?transaction=ft2gufgjymx4v2K6q";
        String myurl = "https://movistar.recaudo.epayco.io/";
        //String myurl = "https://msecure.epayco.co/v1/transaction/payment.html?transaction=unM4tHRpvMTBWWk5a";
        //String myurl = "https://recarga-civica.epayco.co/?recharge=1";
        WebSettings webSettings= mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        mywebView.loadUrl(myurl);
    }
    public class mywebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed() {
        if (mywebView.canGoBack()) {
            mywebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}