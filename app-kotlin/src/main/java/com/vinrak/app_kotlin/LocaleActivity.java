package com.vinrak.app_kotlin;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

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

        //Toast.makeText(getApplicationContext(), "api = " + Build.VERSION.SDK_INT, Toast.LENGTH_SHORT).show();

        try {

            prefData = new PrefData(getApplicationContext());

            String language = prefData.getCurrentLanguage();

            Locale locale = null;

            switch (language) {
                case "en":
                    locale = new Locale(language, "US");
                    break;
                case "ar":
                    locale = new Locale(language, "AE");
                    break;
                case "ur":
                case "hi":
                    locale = new Locale(language, "IN");
                    break;
            }
            Locale.setDefault(locale);

            Resources resources = getResources();
            Configuration configuration = resources.getConfiguration();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                configuration.setLocale(locale);
                createConfigurationContext(configuration);
            } else {
                configuration.locale = locale;
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                configuration.setLayoutDirection(locale);
            } else {
                Log.d(tag, "RTL support not work in below api 17");
            }
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        } catch (Exception e) {
            Log.d(tag, "catch error = " + e.getMessage());
        }
    }

}