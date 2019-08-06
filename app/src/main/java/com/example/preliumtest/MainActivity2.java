package com.example.preliumtest;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity {

    PrefData prefData;
    private String tag = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppLocale("ur");
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnEn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prefData.setCurrentLanguage("en");
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));

            }
        });

        findViewById(R.id.btnAr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prefData.setCurrentLanguage("ar");
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));

            }
        });

        findViewById(R.id.btnUr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prefData.setCurrentLanguage("ur");
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));

            }
        });

    }

    private void setAppLocale(String sa) {

        Toast.makeText(getApplicationContext(), "api = " + Build.VERSION.SDK_INT, Toast.LENGTH_SHORT).show();

        try {

            prefData = new PrefData(getApplicationContext());

            String s = prefData.getCurrentLanguage();

            Locale locale = new Locale(s);

            Resources resource = getResources();
            DisplayMetrics dm = resource.getDisplayMetrics();
            Configuration configuration = resource.getConfiguration();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
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

    private void demo() {

/*        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Log.d(this.getClass().getSimpleName(), "blah blah blah");
                Toast.makeText(getApplicationContext(),"aaa",Toast.LENGTH_SHORT).show();
                handler.postDelayed(this, 5000);
            }
        }, 5000);*/

/*        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(this.getClass().getSimpleName(), "blah blah blah");
                        Toast.makeText(getApplicationContext(), "aaa", Toast.LENGTH_SHORT).show();
                    }
                });
                try {
                    Thread.sleep(5000);
                    thread.start();
                } catch (InterruptedException e) {
                    Log.d(this.getClass().getSimpleName(), "" + e.getMessage());
                }
            }
        });
        thread.start();*/


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(this.getClass().getSimpleName(), "blah blah blah");
                        Toast.makeText(getApplicationContext(), "aaa", Toast.LENGTH_SHORT).show();
                    }
                });
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Log.d(this.getClass().getSimpleName(), "" + e.getMessage());
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }

    private void runThread() {

        final int[] i = {0};
        final TextView textView = findViewById(R.id.tv);

        Timer timer = new Timer();

        new Thread() {
            public void run() {
                while (i[0]++ < 100) {
                    try {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                textView.setText("#" + i[0]);
                            }
                        });
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    private void timeExample() {
        Timer timer = new Timer();
        TimerTask hourlyTask = new TimerTask() {
            @Override
            public void run() {
                Log.d(this.getClass().getSimpleName(), "aaa");
            }
        };
        // schedule the task to run starting now and then every hour...
        timer.schedule(hourlyTask, 0l, 1000 * 60 * 60);   // 1000*10*60 every 10 minut
    }
}