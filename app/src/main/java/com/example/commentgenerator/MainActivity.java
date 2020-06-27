package com.example.commentgenerator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.graphics.Bitmap;
import android.net.*;
import android.app.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.*;

public class MainActivity extends AppCompatActivity {
  Button upload;
  ImageView imageView;
  LinearLayout linearLayout;
    Button button;
  public static final int GET_FROM_GALLERY=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize instances
        imageView= findViewById(R.id.imgview);
        upload= findViewById(R.id.uploadBut);
        linearLayout= findViewById(R.id.dynamicLayout);
        //
        //click on upload button
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI),GET_FROM_GALLERY);
            }
        });



        }
// to open Gallery and pick an image
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Detects request codes
        if(requestCode==GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                imageView.setImageBitmap(bitmap);
                //Adding  generate button dnamically
                button= new Button(this);
                button.setText("Generate Caption");
                button.setBackgroundColor(Color.rgb(76,185,80));
                linearLayout.addView(button);

                LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                button.setLayoutParams(params);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(getApplicationContext(),"Hello i am working",Toast.LENGTH_LONG).show();
                        Intent intent= new Intent(MainActivity.this,SecondActivity.class);
                        startActivity(intent);
                    }
                });


                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }



}

