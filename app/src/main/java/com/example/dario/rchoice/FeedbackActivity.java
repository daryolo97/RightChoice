package com.example.dario.rchoice;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import facade.GestoreRightChoice;
import gestori.GestioneCorso;
import gestori.GestioneFeedback;
import entità.Corso;
import entità.Feedback;
import utility.CustomAdapterFeedback;

public class FeedbackActivity extends AppCompatActivity {
    private ListView listView;
    private GestoreRightChoice gestoreRightChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_feedback);

        listView = findViewById(R.id.listaFeedbackListView);

        gestoreRightChoice = new GestoreRightChoice(getApplicationContext());

        //prelevo i dati dall'acritivy precedente
        Bundle extras = getIntent().getExtras();
        int value = extras.getInt("posizione");

        GestioneCorso gestioneCorso = new GestioneCorso(getApplicationContext());
        Corso corsoSelezionato = gestoreRightChoice.listaCorsi().get(value);
        ArrayList<Feedback> listaFeedback = gestoreRightChoice.listaFeedback();
        ArrayList<Feedback> listaFeedbackByCorso = new ArrayList<>();

        for(int i=0; i<listaFeedback.size(); i++) {
            if(listaFeedback.get(i).getCodiceCorso().equals(corsoSelezionato.getCodice()) && listaFeedback.get(i).getStato() == 1) {
                listaFeedbackByCorso.add(listaFeedback.get(i));
            }
        }

    CustomAdapterFeedback customAdapterFeedback = new CustomAdapterFeedback(getApplicationContext(), R.layout.layout_feedback, listaFeedbackByCorso);
    listView.setAdapter(customAdapterFeedback);
    }
}
