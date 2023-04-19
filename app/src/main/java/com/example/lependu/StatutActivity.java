package com.example.lependu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.stream.Stream;

public class StatutActivity extends AppCompatActivity {

    TextView textFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statut);

        textFinal = findViewById(R.id.txt_final);

        Intent i2 = getIntent();
        String msg = i2.getStringExtra("MESSAGE");
        textFinal.setText(msg);
    }

    public void rejouer_onClick (View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
