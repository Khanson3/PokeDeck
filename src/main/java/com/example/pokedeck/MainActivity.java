package com.example.pokedeck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String prefs = "prefs";

    public static final String currencyKey = "currencyKey";
    public static final String activeDecksKey = "activeDecksKey";
    public static final String deckArrayKey = "deckArrayKey";

    SharedPreferences sharedPrefs;

    Deck[] deckArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefs = getSharedPreferences(prefs, MODE_PRIVATE);

        init();

        Log.d("shared prefs 1", sharedPrefs.getString(currencyKey, ""));
    }

    public void init() {
        if(!sharedPrefs.contains(currencyKey)) {
            SharedPreferences.Editor prefsEditor = sharedPrefs.edit();

            prefsEditor.putString(currencyKey, "USD");

            prefsEditor.apply();

            Log.d("init currencyKey:", "success");
        }

        if(!sharedPrefs.contains(activeDecksKey)) {
            SharedPreferences.Editor prefsEditor = sharedPrefs.edit();

            prefsEditor.putInt(activeDecksKey, 0);

            prefsEditor.apply();

            Log.d("init activeDecksKey:", "success");
        }

        if(!sharedPrefs.contains(deckArrayKey)) {
            deckArray = new Deck[10];
            Gson gson = new Gson();
            String deckArrayJson = gson.toJson(deckArray);

            SharedPreferences.Editor prefsEditor = sharedPrefs.edit();

            prefsEditor.putString(deckArrayKey, deckArrayJson);

            prefsEditor.apply();

            Log.d("init deckArrayKey", "success");
        }
    }

    public void activityDeckCollection(View v) {
        Intent i = new Intent(this, DeckCollectionActivity.class);

        startActivity(i);
    }

    public void activitySettings(View v) {
        Intent i = new Intent(this, SettingsActivity.class);

        startActivity(i);
    }
}