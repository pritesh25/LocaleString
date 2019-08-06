package com.example.preliumtest;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class LocaleActivity extends AppCompatActivity {

    PrefData prefData;
    private String tag = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppLocale();
    }

    private void setAppLocale() {

        Toast.makeText(getApplicationContext(), "api = " + Build.VERSION.SDK_INT, Toast.LENGTH_SHORT).show();

        try {

            prefData = new PrefData(getApplicationContext());

            String s = prefData.getCurrentLanguage();

            Locale locale = new Locale(s);
            Locale.setDefault(locale);
            Resources resource = getResources();
            DisplayMetrics dm = resource.getDisplayMetrics();
            Configuration configuration = resource.getConfiguration();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                configuration.setLocale(locale);
            } else {
                configuration.locale = locale;//new Locale(s.toLowerCase());
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                configuration.setLayoutDirection(locale);

            } else {
                configuration.setLayoutDirection(locale);
            }

            resource.updateConfiguration(configuration, dm);
        } catch (Exception e) {
            Log.d(tag, "catch error = " + e.getMessage());
        }
    }
}