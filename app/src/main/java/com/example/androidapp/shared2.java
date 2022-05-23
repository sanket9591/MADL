package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class shared2 extends AppCompatActivity {
    SharedPreferences sh;

    Button lout ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared2);
        lout = findViewById(R.id.lo);
        sh = getSharedPreferences("RIT",MODE_PRIVATE);

        lout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sh.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(getApplicationContext(),"Logged out Successfully",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),shared.class);
                startActivity(i);
            }
        });

    }
}