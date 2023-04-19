package com.example.lependu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AcceuilActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

    }

    public void jouer_onClick(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }
}
