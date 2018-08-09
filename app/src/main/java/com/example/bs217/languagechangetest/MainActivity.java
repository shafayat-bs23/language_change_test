package com.example.bs217.languagechangetest;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    static int lang = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, new FirstFragment());
        fragmentTransaction.commit();
    }

    public void changeLanguage() {

        String language;
        if (lang == 1) {
            language = "bn";
            lang = 2;
        } else {
            language = "en";
            lang = 1;
        }
        Configuration config = getBaseContext().getResources().getConfiguration();
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();

    }
}
