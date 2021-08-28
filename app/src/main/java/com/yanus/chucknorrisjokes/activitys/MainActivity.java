package com.yanus.chucknorrisjokes.activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.onesignal.OneSignal;
import com.yanus.chucknorrisjokes.R;

//1. Activity загрузки.
public class MainActivity extends AppCompatActivity {
    private static final String ONESIGNAL_APP_ID = "816ca0ae-6d65-4422-8d99-a95cadeb7712";


    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.chuck_norris, null));

        //simulate loading
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (OneSignal.getDeviceState().isSubscribed()) {
                    startActivity(new Intent(MainActivity.this, WebViewActivity.class));
                } else {
                    startActivity(new Intent(MainActivity.this, ListJokeCategoriesActivity.class));

                }
        }, 1500);


    }

}