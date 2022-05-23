package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sanDisk extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_disk);
        final TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setOnClickListener(v -> {
            // your handler code here
            Intent i = new Intent(getApplicationContext(),activity3.class);
            startActivity(i);
        });

        final TextView textView2 = (TextView) findViewById(R.id.textView4);
        textView2.setOnClickListener(v -> {
            // your handler code here
            Intent i = new Intent(getApplicationContext(),check.class);
            startActivity(i);
        });
        final TextView textView3 = (TextView) findViewById(R.id.textView5);
        textView3.setOnClickListener(v -> {
            // your handler code here
            Intent i = new Intent(getApplicationContext(),Media.class);
            startActivity(i);
        });

        TextView textView1 = (TextView) findViewById(R.id.textView6);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT,"Hello");
                Intent chooser= Intent.createChooser(i,"Send Via");

                if (i.resolveActivity(getPackageManager())!= null) {
                    startActivity(chooser);
                }
            }
        });

        }
}