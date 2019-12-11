package com.bw.health_homepage.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.bw.health_homepage.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BannerWebViewMainActivity extends AppCompatActivity {

    private WebView banner_web;
    private String jumpUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banner_webview);
        initView();
        Intent intent = getIntent();
        jumpUrl = intent.getStringExtra("jumpUrl");
        WebSettings settings = banner_web.getSettings();
        settings.setJavaScriptEnabled(true);
        banner_web.loadUrl(jumpUrl);
    }

    private void initView() {
        banner_web = findViewById(R.id.banner_web);
    }
}
