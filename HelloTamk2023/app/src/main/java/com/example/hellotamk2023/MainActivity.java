package com.example.hellotamk2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String message = "Counter: ";
    private int clickCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null){
            clickCounter = savedInstanceState.getInt("COUNTER_VALUE", 0);
        }
        TextView nameText = findViewById(R.id.nameText);
        nameText.setText(message + clickCounter);
    }
    public void buttonClicked(View view) {
        clickCounter++;
        TextView nameText = findViewById(R.id.nameText);
        nameText.setText(R.string.hello_from_code);
        nameText.setText(message + clickCounter);
    }
    @Override
    protected void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putInt("COUNTER_VALUE", clickCounter);
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d("Hello", "Hello TAMK activity on pause");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Hello", "Hello TAMK activity on resume");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Hello", "Hello TAMK activity on destroy");
    }
}