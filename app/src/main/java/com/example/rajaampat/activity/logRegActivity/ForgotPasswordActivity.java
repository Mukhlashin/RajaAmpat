package com.example.rajaampat.activity.logRegActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rajaampat.R;
import com.example.rajaampat.activity.handler.ErrorActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        showWebView();

    }

    private void showWebView() {
        webview = (WebView) this.findViewById(R.id.web_forgot_password);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new ForgotPasswordActivity.MyBrowser());
        //ini manggil url web dari webview-nya
        webview.loadUrl("naroh link forgot password di sini :D");

        if (webview.equals("Not Found")) {
            webview.setVisibility(View.GONE);
        } else {
            webview.setVisibility(View.VISIBLE);
        }

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                view.setVisibility(View.GONE);
                Intent intent = new Intent(ForgotPasswordActivity.this, ErrorActivity.class);
                startActivity(intent);
            }
        });
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webview.canGoBack()) {
                        webview.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public void back(View view) {
        super.onBackPressed();
    }
}
