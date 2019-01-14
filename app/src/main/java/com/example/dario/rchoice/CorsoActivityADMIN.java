package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import facade.GestoreRightChoice;
import gestori.GestioneCorso;
import entità.Corso;

public class CorsoActivityADMIN extends AppCompatActivity {

    private GestoreRightChoice gestoreRightChoice;
    private TextView TVnomeCorso, TVdocente, TVdescrizione, TVlink;
    private int value;
    Intent intent, intent2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corso_admin);

        gestoreRightChoice = new GestoreRightChoice(getApplicationContext());
        TVnomeCorso = findViewById(R.id.nomeCorsoSpecifico);
        TVdocente = findViewById(R.id.nomeDocenteSpecifico);
        TVdescrizione = findViewById(R.id.descrizioneSpecifica);
        TVlink = findViewById(R.id.linkSpecifico);

        ArrayList<Corso> listaCorsi = gestoreRightChoice.listaCorsi();

        //"prelevo" i dati dall'activity precedente
        Bundle extra = getIntent().getExtras();
        value = extra.getInt("posizione");


        TVnomeCorso.setText(gestoreRightChoice.listaCorsi().get(value).getNome().toUpperCase());
        TVdocente.setText(gestoreRightChoice.listaCorsi().get(value).getDocente());
        TVdescrizione.setText(gestoreRightChoice.listaCorsi().get(value).getDescrizione());
        TVlink.setText(gestoreRightChoice.listaCorsi().get(value).getLink());
    }

    /**
     * Metodo che permette di lanciare l'activity al tocco della view cui è legata inviandole dei dati
     * @param v rappresenta l'activity da lanciare
     */
    public void eliminaCorso(View v) {
        gestoreRightChoice.cancellaCorso(gestoreRightChoice.listaCorsi().get(value));
        startActivity(new Intent(getApplicationContext(), ListaCorsiActivityADMIN.class));
        Toast.makeText(getApplicationContext(), "Corso eliminato correttamente", Toast.LENGTH_SHORT).show();
        finish();
    }


    /**
     * Metodo che permette di lanciare l'activity al tocco della view cui è legata inviandole dei dati
     * @param v rappresenta la view cliccata
     */
    public void lanciaModificaCorso(View v) {
        Intent intent = new Intent(getApplicationContext(), ModificaCorsoActivityADMIN.class);
        intent.putExtra("posizione", value);
        startActivity(intent);
        finish();
    }
}
