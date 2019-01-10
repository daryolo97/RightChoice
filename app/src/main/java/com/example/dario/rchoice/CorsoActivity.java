package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import gestori.GestioneCorso;
import entità.Corso;

public class CorsoActivity extends Activity {

    private GestioneCorso gestioneCorso;
    private TextView TVnomeCorso, TVdocente, TVdescrizione, TVlink;
    private int count;
    Intent intent, intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corso);

        gestioneCorso = new GestioneCorso(getApplicationContext());
        TVnomeCorso = findViewById(R.id.nomeCorsoSpecifico);
        TVdocente = findViewById(R.id.nomeDocenteSpecifico);
        TVdescrizione = findViewById(R.id.descrizioneSpecifica);
        TVlink = findViewById(R.id.linkSpecifico);

        ArrayList<Corso> listaCorsi= gestioneCorso.getAllCorsi();

        //"prelevo" i dati dall'activity precedente
        Bundle extra = getIntent().getExtras();
        int value = extra.getInt("posizione");

        //istanzio l'intent
        intent = new Intent(getApplicationContext(), FeedbackActivity.class);
        intent.putExtra("posizione", value);

        //intent2
        intent2 = new Intent(getApplicationContext(), InserisciFeedbackActivity.class);
        intent2.putExtra("posizione", value);

        TVnomeCorso.setText(gestioneCorso.getAllCorsi().get(value).getNome().toUpperCase());
        TVdocente.setText(gestioneCorso.getAllCorsi().get(value).getDocente());
        TVdescrizione.setText(gestioneCorso.getAllCorsi().get(value).getDescrizione());
        TVlink.setText(gestioneCorso.getAllCorsi().get(value).getLink());
    }

    public void visualizzaFeedback(View v) {
        startActivity(intent);
    }

    public void inserisciFeedback(View v) {
        startActivity(intent2);
    }

    public void apriLink(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(TVlink.getText().toString()));
        startActivity(intent);
    }




}
