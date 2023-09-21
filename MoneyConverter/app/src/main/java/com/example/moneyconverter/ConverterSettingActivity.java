package com.example.moneyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConverterSettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_setting);
        Intent intent = getIntent();
        String message = intent.getStringExtra("HELLO_MESSAGE");
        //Laitetaan viesti näytölle
        //TextView messageTextView = findViewById(R.id.messageTextView);
        //messageTextView.setText(message);
    }

    public void backToConverter(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent); //käynnistää aktiviteetin
    }

    public void SetExhangeRate(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editTextConversionRate = findViewById(R.id.editTextConversioRate);
        String editTextConversionRateInput = editTextConversionRate.getText().toString();
        float conversionRate = Float.parseFloat(editTextConversionRateInput);
        intent.putExtra("CONVERSION_RATE", conversionRate);

        // Haetaan annettu home valuutan nimi
        EditText setHomeCurrencyText = findViewById(R.id.setHomeCurrencyText);
        String homeCurrencyName = setHomeCurrencyText.getText().toString();
        intent.putExtra("HOME_CURRENCY_NAME", homeCurrencyName);

        // Haetaan annettu destination valuutan nimi
        EditText setDestinationCurrencyText = findViewById(R.id.setDestinationCurrencyText);
        String destinationCurrencyName = setDestinationCurrencyText.getText().toString();
        intent.putExtra("DESTINATION_CURRENCY_NAME", destinationCurrencyName);

        startActivity(intent); //käynnistää aktiviteetin
    }
}