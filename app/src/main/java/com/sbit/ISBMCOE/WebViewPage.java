package com.sbit.ISBMCOE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WebViewPage extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_page);
        webView = findViewById(R.id.webview);
        progressBar = findViewById(R.id.progressBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Test");
        getSupportActionBar().setElevation(40);
        String res = getIntent().getStringExtra("res");
        System.out.println("////////////////////////////" + res);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.setWebViewClient(new MyBrowser());
        webView.setWebChromeClient(new WebChromeClient());

        switch (res) {
            case "registration":
                webView.loadUrl("https://www.eazy2exam.com/ISBM/registration.aspx?sai=1&mai=1&ai=61&ei=1045&qpi=1051&eqid=1045_1051");
                break;

            case "login":
                webView.loadUrl("http://www.eazy2exam.com/SBITExam/Login.aspx");
                break;
        }
    }

    private class MyBrowser extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            progressBar.setVisibility(View.VISIBLE);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);

            Toast.makeText(WebViewPage.this, "Server Error-" + description, Toast.LENGTH_SHORT).show();
            System.out.println("server Error-" + description);
        }
    }

    public boolean onKeyDown ( int keyCode, KeyEvent event){
        if (event.getAction() == android.view.KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case android.view.KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}