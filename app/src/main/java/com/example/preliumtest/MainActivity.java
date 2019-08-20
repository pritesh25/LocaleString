package com.example.preliumtest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends LocaleActivity {

    PrefData prefData;
    private String tag = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setAppLocale();
        setContentView(R.layout.activity_main);

        Log.d(tag, "onCreate");

        prefData = new PrefData(getApplicationContext());

        findViewById(R.id.btnEn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prefData.setCurrentLanguage("en");
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });

        findViewById(R.id.btnAr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prefData.setCurrentLanguage("ar");
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });

        findViewById(R.id.btnUr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prefData.setCurrentLanguage("ur");
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        findViewById(R.id.AlertDialogue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage("Are you sure,You wanted to make decision");
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(MainActivity.this, "You clicked yes  button", Toast.LENGTH_LONG).show();
                            }
                        });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });
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
                configuration.locale = locale;
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

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "onPause");
    }
}