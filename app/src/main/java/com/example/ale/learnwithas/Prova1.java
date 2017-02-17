package com.example.ale.learnwithas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.ale.learnwithas.R.id.textHome;

public class Prova1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova1);//richiama la risorsa layout di nome activity_prova1 (o tipo di layout)

      /*  String name='Seidou Takizawa';
        int eta=25;
        String valore= name + ': OWL '+eta+" anni";
        String valore= name + ': OWL '+Integer.toString(eta)+" anni";
        Log.d("CHARACTER", valore);*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*TextView nomeView = (TextView) findViewById(textHome);
        String valuex =nomeView.getText().toString();//per leggere dalla activity
        Log.d("calc", valuex);*/
        FloatingActionButton b1 = (FloatingActionButton) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast toast= Toast.makeText(getApplicationContext(),"Eh, Volevi!!!!!!!",Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
            }
        });


        //Cosa viene fatto alla pressione del bottone nero
        FloatingActionButton bb = (FloatingActionButton) findViewById(R.id.BlackButton);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               msg();//metodo
            }
        });
        //per cambiare pagina/activity
        ImageView button = (ImageView) findViewById(R.id.littleBB);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openPage= new Intent(Prova1.this,pageTwo.class);//definisco l'intenzione
                startActivity(openPage);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prova1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast toast= Toast.makeText(getApplicationContext(),"setting",Toast.LENGTH_LONG);
            toast.show();
            return true;
        }
        else
        if (id==R.id.List1)
        {
            Toast toast= Toast.makeText(getApplicationContext(),"List1",Toast.LENGTH_LONG);
            toast.show();
            return true;
        }
        else if (id==R.id.List2)
        {
            Intent thirdP= new Intent(Prova1.this,pageThree.class);//definisco l'intenzione
            thirdP.putExtra("valore","List2");// questo lo metto per evitare che l'app crashi xk come viene aperta la 3 pagina mostra un dato recuperato
            startActivity(thirdP);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void msg()
    {
        TextView nomeView = (TextView) findViewById(textHome);
        nomeView.setText("Testo scritto dal file java. Premi il pulsante blu con sfondo nero per fare qualcosa");
    }


}
