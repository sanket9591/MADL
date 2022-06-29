package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class asynctask extends AppCompatActivity {

    URL url = null;
    InputStream inputStream = null;
    Bitmap bitmap = null;
    ImageView imageView = null;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);
        getSupportActionBar().setTitle("Async task");

        Button button = findViewById(R.id.button9);
        imageView= findViewById(R.id.image);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTaskExample at = new AsyncTaskExample();
                at.execute("https://thumbs.dreamstime.com/b/conceptual-image-family-love-togetherness-safety-top-view-four-placing-hands-one-other-178302995.jpg");
            }

        });


    }

    private class AsyncTaskExample extends AsyncTask<String, String, Bitmap>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            progressDialog=new ProgressDialog(asynctask.this);
            progressDialog.setMessage("Please wait");
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(true);
            progressDialog.show();
        }
        @Override
        protected Bitmap doInBackground(String...strings){
            try {
                url = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.connect();
                inputStream =conn.getInputStream();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig =Bitmap.Config.RGB_565;
                bitmap = BitmapFactory.decodeStream(inputStream,null,options);



            }
            catch (IOException e){
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (imageView != null) {
                progressDialog.hide();
                imageView.setImageBitmap(bitmap);
            } else {
                progressDialog.show();
            }
        }

        }
    }




