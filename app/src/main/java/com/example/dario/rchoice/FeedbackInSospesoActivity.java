package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import gestori.GestioneCorso;
import gestori.GestioneFeedback;
import entità.Corso;
import entità.Feedback;

public class FeedbackInSospesoActivity extends Activity {
    private GestioneCorso gestioneCorso;
    private GestioneFeedback gestioneFeedback;
    private TextView nomeCorso, titolo, descrizione;
    private String nome;
    private int value;
    private ArrayList<Feedback> listaFeedbackInSospeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_in_sospeso);

        //Prelevo i dati dall'intent precedente
        Bundle extra = getIntent().getExtras();
        value = extra.getInt("posizione");

        //inizializzazione degli adapter
        gestioneCorso = new GestioneCorso(getApplicationContext());
        gestioneFeedback = new GestioneFeedback(getApplicationContext());

        //tramite gli adapter prelevo le liste dei feedback e dei corsi dal database
        ArrayList<Feedback> listaFeedback = gestioneFeedback.getAllFeedback();
        listaFeedbackInSospeso = new ArrayList<>();
        ArrayList<Corso> listaCorsi = gestioneCorso.getAllCorsi();


        //inserisco all'interno di listaFeedbackInSospeso tutti i feedback in sospeso
        for (int i = 0; i < listaFeedback.size(); i++) {
            if (listaFeedback.get(i).getStato() == 0) {
                listaFeedbackInSospeso.add(listaFeedback.get(i));
            }
        }



        for(int j=0; j<listaCorsi.size();j++) {
            if(listaFeedbackInSospeso.get(value).getCodiceCorso().equals(listaCorsi.get(j).getCodice()))
                nome = listaCorsi.get(j).getNome();
        }

        nomeCorso = findViewById(R.id.nomeCorsoFeedback);
        titolo = findViewById(R.id.titoloFeedbackInSospeso);
        descrizione = findViewById(R.id.descrizioneFeedbackInSospeso);



        nomeCorso.setText(nome);
        titolo.setText(listaFeedbackInSospeso.get(value).getTitolo());
        descrizione.setText(listaFeedbackInSospeso.get(value).getDescrizione());
    }

    public void convalidaButton(View v) {
       gestioneFeedback.setStatoFeedback(listaFeedbackInSospeso.get(value));
       startActivity(new Intent(getApplicationContext(), ListaFeedbackInSospesoActivity.class));
       finish();
       Toast.makeText(getApplicationContext(), "Feedback convalidato", Toast.LENGTH_SHORT).show();
    }

    public void rifiutaButton(View v) {
        gestioneFeedback.deleteFeedback(listaFeedbackInSospeso.get(value));
        finish();
        Toast.makeText(getApplicationContext(), "Feedback scartato", Toast.LENGTH_SHORT).show();

    }

}
