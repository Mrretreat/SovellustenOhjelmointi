package com.example.hellotamk2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Luodaan referenssi käyttöliittymäelementtiin TextView
        //TextView nameText = findViewById(R.id.nameText);
        //nameText.setText("Hello from code");
    }
    public void buttonClicked(View view) {
        TextView nameText = findViewById(R.id.nameText);
        nameText.setText(R.string.hello_from_code);
    }
}