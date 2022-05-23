package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class activity3 extends AppCompatActivity {
    String [] cities = {"Islampur", "Pune", "Satara", "Sangli", "Kolhapur", "Mumbai", "Solapur", "Karad", "Jath" };
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        l = findViewById(R.id.list1);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,cities);
        l.setAdapter(arr);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(activity3.this,"City is "+cities[i],Toast.LENGTH_SHORT).show();
            }
        });


    }
}