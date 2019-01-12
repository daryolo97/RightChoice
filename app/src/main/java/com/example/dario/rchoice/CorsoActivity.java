package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import facade.GestoreRightChoice;
import gestori.GestioneCorso;
import entità.Corso;

public class CorsoActivity extends AppCompatActivity {

    private GestoreRightChoice gestoreRightChoice;
    private TextView TVnomeCorso, TVdocente, TVdescrizione, TVlink;
    private int count;

    Intent intent, intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corso);

        gestoreRightChoice = new GestoreRightChoice(getApplicationContext());
        TVnomeCorso = findViewById(R.id.nomeCorsoSpecifico);
        TVdocente = findViewById(R.id.nomeDocenteSpecifico);
        TVdescrizione = findViewById(R.id.descrizioneSpecifica);
        TVlink = findViewById(R.id.linkSpecifico);

        ArrayList<Corso> listaCorsi= gestoreRightChoice.listaCorsi();

        //"prelevo" i dati dall'activity precedente
        Bundle extra = getIntent().getExtras();
        int value = extra.getInt("posizione");

        //istanzio l'intent
        intent = new Intent(getApplicationContext(), FeedbackActivity.class);
        intent.putExtra("posizione", value);

        //intent2
        intent2 = new Intent(getApplicationContext(), InserisciFeedbackActivity.class);
        intent2.putExtra("posizione", value);

        TVnomeCorso.setText(gestoreRightChoice.listaCorsi().get(value).getNome().toUpperCase());
        TVdocente.setText(gestoreRightChoice.listaCorsi().get(value).getDocente());
        TVdescrizione.setText(gestoreRightChoice.listaCorsi().get(value).getDescrizione());
        TVlink.setText(gestoreRightChoice.listaCorsi().get(value).getLink());
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
