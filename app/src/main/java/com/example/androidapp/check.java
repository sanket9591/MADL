package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class check extends AppCompatActivity {

    private CheckBox ch1,ch2,ch3,ch4,ch5;
    private Button bt1,bt2;
    private RadioButton rb;
    StringBuffer stringBuffer = new StringBuffer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        ch1 = findViewById(R.id.checkBox1);
        ch2 = findViewById(R.id.checkBox2);
        ch3 = findViewById(R.id.checkBox3);
        ch4 = findViewById(R.id.checkBox4);
        ch5 = findViewById(R.id.checkBox5);
        bt1 = findViewById(R.id.button2);
        bt2 = findViewById(R.id.button3);
        rb = findViewById(R.id.radioButton2);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb.isChecked())
                {
                    Toast.makeText(check.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(check.this,"Wrong",Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch1.isChecked())
                {
                    stringBuffer.append(ch1.getText().toString()+" ");
                }
                if (ch2.isChecked())
                {
                    stringBuffer.append(ch2.getText().toString()+" ");
                }
                if (ch3.isChecked())
                {
                    stringBuffer.append(ch3.getText().toString()+" ");
                }
                if (ch4.isChecked())
                {
                    stringBuffer.append(ch4.getText().toString()+" ");
                }
                if (ch5.isChecked())
                {
                    stringBuffer.append(ch5.getText().toString()+" ");
                }
                Toast.makeText(check.this,"You selected "+stringBuffer,Toast.LENGTH_SHORT).show();
                stringBuffer.delete(0,stringBuffer.length());
            }
        });
    }

}