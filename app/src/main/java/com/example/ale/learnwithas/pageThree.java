package com.example.ale.learnwithas;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class pageThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_three);

        //recupero dati da intent esplicito
        getIntent().getExtras().getString("valore");
        TextView element = (TextView) findViewById(R.id.txtV);
        element.setText(getIntent().getExtras().getString("valore"));

        ImageView btn=(ImageView) findViewById(R.id.fab);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent implicito, i parametri:
                // 1 azione -> Intent.ACTION_VIEW
                // 2 tipologia -> Uri.parse("google")
                Intent openPage = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(openPage);
            }
        });

        ImageView msg=(ImageView) findViewById(R.id.msg);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent implicito, i parametri
                Intent openPage = new Intent(Intent.ACTION_DIAL, Uri.parse("mailto:alessandro.mura193@gmail.com"));
                startActivity(openPage);
            }
        });

        ImageView photo=(ImageView) findViewById(R.id.add);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent implicito, i parametri
                Intent photocamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //creo il nome della foto utilizzando la data e l'ora in cui viene fatta

                //photocamera.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(file));
                startActivityForResult(photocamera,0);


            }
        });

        File imgFile = new  File("sdcard/Android/data/TokyoGhoul/nome.jpg");

        if(imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            final ImageView myImage = (ImageView) findViewById(R.id.imageviewTest);
            myImage.setImageBitmap(myBitmap);

            myImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                }
            });
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent databack){
    Bitmap immagine = (Bitmap) databack.getExtras().get("data"); //intent per recuperare l'immagine
        //img è un componente imageView presente sul layout

        ImageView img =(ImageView) findViewById(R.id.xx);
        //img.getLayoutParams().width = 700;
        //img.getLayoutParams().height= 700;
        img.setImageBitmap(immagine);
        String timeStamp = (new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()))+".jpg";
        File file=new File("sdcard/Android/data/TokyoGhoul",timeStamp);
        FileOutputStream outptOs = null;
        try {
            outptOs = new FileOutputStream( file );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        immagine.compress( Bitmap.CompressFormat.JPEG, 100, outptOs );
      /*  Intent pF= new Intent(pageThree.this,pageFourth.class);//definisco l'intenzione
        startActivity(pF);*/

    }


}