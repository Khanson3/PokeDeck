package com.example.pokedeck;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    SharedPreferences sharedPrefs;

    public static final String prefs = "prefs";
    public static final String currencyKey = "currencyKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPrefs = getSharedPreferences(prefs, MODE_PRIVATE);

        Spinner spinnerCurrency = (Spinner) findViewById(R.id.spinnerCurrency);

        spinnerCurrency.setOnItemSelectedListener(this);

        List<String> currency = new ArrayList<>();

        currency.add("USD");
        currency.add("EUR");
        currency.add("JPY");
        currency.add("GBP");
        currency.add("AUD");
        currency.add("CAD");

        Log.d("shared prefs 2a", sharedPrefs.getString(currencyKey, ""));


        ArrayAdapter<String> adapterCurrency = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currency);

        adapterCurrency.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCurrency.setAdapter(adapterCurrency);

        for(int i = 0; i < currency.size(); i++) {
            if(currency.get(i).equals(sharedPrefs.getString(currencyKey, ""))){
                spinnerCurrency.setSelection(i);
                Log.d("Spinner updated pref", "success");
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("shared prefs 2c", sharedPrefs.getString(currencyKey, ""));
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);
        ((TextView) adapterView.getChildAt(0)).setTextSize(25);

        SharedPreferences.Editor prefsEditor = sharedPrefs.edit();

        prefsEditor.putString(currencyKey, ((TextView) adapterView.getChildAt(0)).getText().toString());

        prefsEditor.apply();
        Log.d("shared prefs 2d", sharedPrefs.getString(currencyKey, ""));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void backSettings(View v) {
        Log.d("shared prefs 2b", sharedPrefs.getString(currencyKey, ""));
        finish();
    }
}
