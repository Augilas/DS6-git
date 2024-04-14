package com.example.applabs2irvingcamarena_rafaelchung_anaportugal;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Esto se imprime desde el metodo on create", Toast.LENGTH_SHORT).show();
    }
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Esto se imprime desde el metodo on start", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"Esto se imprime desde el metodo on restart", Toast.LENGTH_SHORT).show();
    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"Esto se imprime desde el metodo on resume", Toast.LENGTH_SHORT).show();
    }

    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"Esto se imprime desde el metodo on stop", Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Esto se imprime desde el metodo on destroy", Toast.LENGTH_SHORT).show();
    }

}