package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import gestori.GestioneCorso;
import entità.Corso;

public class CorsoActivityADMIN extends Activity {

    private GestioneCorso gestioneCorso;
    private TextView TVnomeCorso, TVdocente, TVdescrizione, TVlink;
    private int value;
    Intent intent, intent2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corso_admin);

        gestioneCorso = new GestioneCorso(getApplicationContext());
        TVnomeCorso = findViewById(R.id.nomeCorsoSpecifico);
        TVdocente = findViewById(R.id.nomeDocenteSpecifico);
        TVdescrizione = findViewById(R.id.descrizioneSpecifica);
        TVlink = findViewById(R.id.linkSpecifico);

        ArrayList<Corso> listaCorsi = gestioneCorso.getAllCorsi();

        //"prelevo" i dati dall'activity precedente
        Bundle extra = getIntent().getExtras();
        value = extra.getInt("posizione");


        TVnomeCorso.setText(gestioneCorso.getAllCorsi().get(value).getNome().toUpperCase());
        TVdocente.setText(gestioneCorso.getAllCorsi().get(value).getDocente());
        TVdescrizione.setText(gestioneCorso.getAllCorsi().get(value).getDescrizione());
        TVlink.setText(gestioneCorso.getAllCorsi().get(value).getLink());
    }

    public void eliminaCorso(View v) {
        gestioneCorso.deleteCorso(gestioneCorso.getAllCorsi().get(value));
        startActivity(new Intent(getApplicationContext(), ListaCorsiActivityADMIN.class));
        Toast.makeText(getApplicationContext(), "Corso eliminato correttamente", Toast.LENGTH_SHORT).show();
        finish();
    }


    public void lanciaModificaCorso(View v) {
        Intent intent = new Intent(getApplicationContext(), ModificaCorsoActivityADMIN.class);
        intent.putExtra("posizione", value);
        startActivity(intent);
        finish();
    }
}
