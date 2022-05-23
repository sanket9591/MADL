package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class Media extends AppCompatActivity {

    private Button b1,b2;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private Handler myHandler = new Handler();
    private double startTime = 0;
    private double finalTime = 0;
    public static int oneTimeOnly = 0;
    private TextView tx1,tx2,tx3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        getSupportActionBar().setTitle("Media Player");

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button8);

        tx1 = (TextView)findViewById(R.id.textView);
        tx2 = (TextView)findViewById(R.id.textView15);
        tx3 = (TextView)findViewById(R.id.textView16);
        tx3.setText("Song.mp3");


        mediaPlayer = MediaPlayer.create(this,R.raw.song);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setClickable(false);
        b2.setEnabled(false);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Playing sound",Toast.LENGTH_SHORT).show();
                mediaPlayer.start();

                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();

                if (oneTimeOnly == 0) {
                    seekBar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }

                tx2.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime)))
                );

                tx1.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime)))
                );

                seekBar.setProgress((int)startTime);
                myHandler.postDelayed(UpdateSongTime,100);
                b2.setEnabled(true);
                b1.setEnabled(false);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Pausing sound",Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                b2.setEnabled(false);
                b1.setEnabled(true);
            }
        });
    }
    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            tx1.setText(String.format("%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime)))
            );
            seekBar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };
}