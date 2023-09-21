package com.example.moneyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private float conversionRate = 1.06f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView homeCurrencyTextView = findViewById(R.id.homeCurrencyTextView);
        TextView destinationCurrencyTextView = findViewById(R.id.destinationCurrencyTestView);
        Intent intent = getIntent();
        conversionRate = intent.getFloatExtra("CONVERSION_RATE", 1.06f);
        String homeCurrencyName = intent.getStringExtra("HOME_CURRENCY_NAME");
        String destinationCurrencyName = intent.getStringExtra("DESTINATION_CURRENCY_NAME");
        if (homeCurrencyName != null) {
            homeCurrencyTextView.setText(homeCurrencyName);
        }
        if (destinationCurrencyName != null) {
            destinationCurrencyTextView.setText(destinationCurrencyName);
        }
    }


    public void openSettings(View view) {
        //nappulan tapahtumakäsittelijä
        //Todo: avaa asetuksent näkymä ja välitä sinne viesti tästä aktiviteetista
        Intent intent = new Intent(this, ConverterSettingActivity.class);
        startActivity(intent); //käynnistää aktiviteetin
    }

    public void convertCurrency(View view) {
        // Luetaan source- kentästä luku, tehdään muunnos ja kirjoitetaan
        //destination-kenttään valuuttamuunnos
        EditText homeCurrencyEditText = findViewById(R.id.homeCurrencyEditText);
        EditText destinationCurrencyEditText = findViewById(R.id.destinationCurrencyEditText);

        String homeCurrencyInput = homeCurrencyEditText.getText().toString();
        float homeCurrencyAmount = Float.parseFloat(homeCurrencyInput);

        float destinationCurrency = homeCurrencyAmount * conversionRate;

        destinationCurrencyEditText.setText(String.valueOf(destinationCurrency));
    }
}