package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private TextView weatherDataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // TODO (2) Display the weather forecast that was passed from MainActivity
        weatherDataTextView = (TextView) findViewById(R.id.tv_detail_weather_text);

        Intent startedIntent = getIntent();
        if (startedIntent.hasExtra(Intent.EXTRA_TEXT)) {
            String weatherData = startedIntent.getStringExtra(Intent.EXTRA_TEXT);

            weatherDataTextView.setText(weatherData);
        }
    }
}