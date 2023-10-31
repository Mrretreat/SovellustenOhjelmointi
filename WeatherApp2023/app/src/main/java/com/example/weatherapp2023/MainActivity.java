package com.example.weatherapp2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getWeatherData(View view) {
        // haetaan säätiedot Volley-kirjastolla
        String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=tampere&appid=6c433438776b5be4ac86001dc88de74d&units=metric";
        StringRequest request = new StringRequest(Request.Method.GET, WEATHER_URL, response -> {
            // Säätiedot haettu onnistuneesti. Parsitaan JSON -objekti
            Toast.makeText(this, response,Toast.LENGTH_LONG).show();
            parseWeatherJsonAndUpdateUi(response);

        }, error -> {
            Toast.makeText(this, "VERKKOVIRHE", Toast.LENGTH_LONG).show();
        });
        // lähetetään request Volleyllä
        Volley.newRequestQueue(this).add(request);
        // tämän jälkeen tullaan jompaan callbackin haaraan, kun request on valmis
    }

    private void parseWeatherJsonAndUpdateUi(String response) {
        //parsitaan JSON ja päivitetään näytölle lämpötila, säätila ja tuulennopeus
        try {
            JSONObject weatherJson = new JSONObject(response);
            String weather = weatherJson.getJSONArray("weather").getJSONObject(0).getString("main");
            double tempereture = weatherJson.getJSONObject("main").getDouble("temp");
            double wind = weatherJson.getJSONObject("wind").getDouble("speed");

            TextView temperatureTextView = findViewById(R.id.temperatureTextView);
            temperatureTextView.setText("" + tempereture + "C");
            TextView windTextView = findViewById(R.id.windTextView);
            windTextView.setText("" + wind + " m/s");
            TextView weatherTextView = findViewById(R.id.weatherTextView);
            weatherTextView.setText(weather);
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    public void openForeca (View view) {
        String foreca = "https://www.foreca.fi";
        Uri forecaUri = Uri.parse(foreca);
        Intent intent = new Intent(Intent.ACTION_VIEW, forecaUri);
        try {
            startActivity(intent);
        }
        catch (Exception e) {

        }
    }
}