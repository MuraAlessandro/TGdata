package com.example.ale.learnwithas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class pageTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);


        /* Per recuperare e inserire un insieme di dati in APP a runtime verranno eseguiti i seguenti passi:
        1 ARRAY DI DATI -> recupero di dati da file o database poi inserito come lista
        2 SCELTA DEL LAYOUT -> che può essere personalizzato o di sistema
        3 CREAZIONE ADAPTER
        4 COLLEGAMENTO VIEW ALL'ADAPTER
        */

        //1 in realtà sto creando i dati non recuperandoli, questo passo lo vedrò meglio in seguito
        final ArrayList<String> listp = new ArrayList<String>();
        listp.add("Kurona");
        listp.add("Akira");
        listp.add("Hinami");
        listp.add("Kotaro");
        listp.add("Minami");
        listp.add("Touka");
        listp.add("Caino");
        listp.add("Sanko");
        listp.add("Kiyama");


        ListView myList = (ListView) findViewById(R.id.elenco);
        //Adattatore per i dati e layout, dati da file, java o database
        //fase 2 e 3
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listp);
        //simple_list_item_1 serve per recuperare informazioni dall'array un riga alla volta
        //simple_list_item_1 -->In realtà è il layout in cui verrano visualizzati i dati
        //fase 4
        myList.setAdapter(adapter);

        //per poter rendere cliccabile la lista si usa il metodo setOnClickListener
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //per rendere cliccabile ogni singola riga invece
            public void onItemClick(AdapterView<?> adattatore, final View componente, int pos, long id) {
                /* Parametri:
                   1) adattatore di tipo AdapterView, l'oggetto su cui si è verificato
                      il tocco e che ho stabilito debba fare da tramite tra i dati e il mio controllo ListView.
                   2) componente di tipo View è il controllo creato dall'AdapterView, sul quale il nostro utente ha effettuato il tocco.
                   3) pos di tipo int  la posizione in termini numerici, del controllo all'interno dell'adattatore.
                   4) id di tipo long  l'identificativo numerico della riga dell'elemento ListView che è stato toccato.
                */


                String tit = (String) adattatore.getItemAtPosition(pos);
                Toast toast = Toast.makeText(getApplicationContext(), tit, Toast.LENGTH_SHORT);
                toast.show();
                if (id == 1)
                    toast.setGravity(Gravity.BOTTOM, 0, 50);
                else
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            }

        });

        //checkbox
        final CheckBox c1 = (CheckBox) findViewById(R.id.ck1);
        CheckBox c2 = (CheckBox) findViewById(R.id.ck2);

        c1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), c1.getText(), Toast.LENGTH_SHORT);
                if (c1.isChecked())
                    toast.show();

            }


        });
        //pagina 3
        ImageView button = (ImageView) findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  //invio dati alla nuova pag--> intent esplicito
                Intent openPage = new Intent(pageTwo.this, pageThree.class);//definisco l'intenzione
                openPage.putExtra("valore", listp.get(5));//passo il nome touka alla nuova activity
                openPage.putExtra("valore2", listp.get(2));
                startActivity(openPage);
            }


        });
    }
}
