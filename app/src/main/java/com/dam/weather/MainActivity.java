package com.dam.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText etLat, etLon;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLat = findViewById(R.id.etLatitud);
        etLon = findViewById(R.id.etLongitud);
        btn = findViewById(R.id.btnConsultar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double latitud = Double.parseDouble(etLat.getText().toString());
                Double longitud = Double.parseDouble(etLon.getText().toString());
                if (etLat.getText().toString().isEmpty() || etLon.getText().toString().isEmpty()) {
                    Snackbar.make(etLat, "Introduce los datos", Snackbar.LENGTH_LONG).show();
                } else if (latitud < -90 || latitud > 90){
                    Snackbar.make(etLat, "Latitud no válida", Snackbar.LENGTH_LONG).show();
                } else if(longitud < -180 || longitud > 180){
                    Snackbar.make(etLon, "Longitud no válida", Snackbar.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(MainActivity.this, WeatherActivity.class);
                    i.putExtra("Latitud", latitud);
                    i.putExtra("Longitud", longitud);
                    startActivity(i);
                }
            }
        });
    }

}