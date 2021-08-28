package com.yanus.chucknorrisjokes.activitys;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.yanus.chucknorrisjokes.R;

//4. Activity с WebView.
public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;

    @SuppressLint({"SetJavaScriptEnabled", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new Callback());

        progressBar = findViewById(R.id.progressBarWebView);
        progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.chuck_norris, null));

        //simulate loading
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            webView.loadUrl("https://www.google.com.ua/?hl=ru");
        }, 1500);

    }

    public class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progressBar.setVisibility(View.VISIBLE);
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onPageFinished(WebView view, String url) {
            progressBar.setVisibility(View.GONE);
        }
    }
}