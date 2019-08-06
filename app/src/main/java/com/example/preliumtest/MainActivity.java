package com.example.preliumtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends LocaleActivity {

    PrefData prefData;
    private String tag = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }
}