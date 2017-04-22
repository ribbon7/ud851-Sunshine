package com.example.android.sunshine.sync;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Network;
import android.os.AsyncTask;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;
import com.example.android.sunshine.utilities.SunshineWeatherUtils;

import java.net.URL;

public class SunshineSyncTask {

    synchronized public static void syncWeather(Context context){
        try {
            URL url = NetworkUtils.getUrl(context);
            String stringResponse = NetworkUtils.getResponseFromHttpUrl(url);

            ContentValues cv[] = OpenWeatherJsonUtils.getWeatherContentValuesFromJson(context, stringResponse);

            if (cv != null && cv.length >  0){

                ContentResolver resolver = context.getContentResolver();

                resolver.delete(WeatherContract.WeatherEntry.CONTENT_URI,
                        null,
                        null);

                resolver.bulkInsert(WeatherContract.WeatherEntry.CONTENT_URI,
                        cv);

            }
        } catch(Exception e){
            //probs wrong server
            e.printStackTrace();
        }
    }
}