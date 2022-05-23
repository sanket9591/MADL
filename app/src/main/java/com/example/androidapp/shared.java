package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class shared extends AppCompatActivity {
    EditText email,pwd;
    Button lin,regi;
    SharedPreferences sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);
        email = findViewById(R.id.em);
        pwd = findViewById(R.id.pa);
        regi = findViewById(R.id.re);
        lin = findViewById(R.id.li);

        sh = getSharedPreferences("RIT",MODE_PRIVATE);

        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailtext = email.getText().toString();
                String pwdtext = pwd.getText().toString();
                SharedPreferences.Editor editor = sh.edit();
                editor.putString("RIT_Email",emailtext);
                editor.putString("RIT_Password",pwdtext);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
            }
        });

        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailtext = email.getText().toString();
                String pwdtext = pwd.getText().toString();

                if(emailtext.equals(sh.getString("RIT_Email",null)) && pwdtext.equals(sh.getString("RIT_Password",null)))
                {
                    //Toast.makeText(getApplicationContext(), "Login successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),shared2.class);
                    startActivity(i);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}