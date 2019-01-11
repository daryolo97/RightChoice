package com.example.dario.rchoice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import facade.GestoreRightChoice;
import gestori.GestioneCorso;
import gestori.GestioneFeedback;
import entità.Corso;
import entità.Feedback;

public class InserisciFeedbackActivity extends Activity {
    private GestoreRightChoice gestoreRightChoice;
    private ArrayList<Corso> listaCorsi;
    private EditText titoloET, descrizioneET;
    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserisci_feedback);

        titoloET = findViewById(R.id.titoloFeedbackInserito);
        descrizioneET = findViewById(R.id.descrizioneFeedbackInserito);

        Bundle extra = getIntent().getExtras();
        value = extra.getInt("posizione");

        gestoreRightChoice = new GestoreRightChoice(getApplicationContext());

        listaCorsi = gestoreRightChoice.listaCorsi();
    }

    public void CreaFeedback(View v) {
        Corso corso = listaCorsi.get(value);

        String titolo = titoloET.getText().toString();
        String descrizione = descrizioneET.getText().toString();


        if(verificaTitolo(titolo).equals("vuoto")) {
            Toast.makeText(getApplicationContext(), "Il campo 'Titolo' non può essere vuoto", Toast.LENGTH_SHORT).show();
        } else if(verificaTitolo(titolo).equals("lunga")) {
            Toast.makeText(getApplicationContext(), "Il campo 'Titolo' non può contenere più di 40 caratteri", Toast.LENGTH_SHORT).show();
        } else if(!verificaDescrizione(descrizione)) {
            Toast.makeText(getApplicationContext(), "Il campo 'Descrizione' non può essere vuoto", Toast.LENGTH_SHORT).show();
        } else {
            Feedback feedback = new Feedback();

            feedback.setTitolo(titolo);
            feedback.setDescrizione(descrizione);
            feedback.setCodiceCorso(corso.getCodice());
            feedback.setStato(0);

            gestoreRightChoice.inserisciFeedback(feedback);

            Toast.makeText(getApplicationContext(), "Feedback inserito nella lista in sospeso, attendi che la convalidazione dell'admin", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    public String verificaTitolo(String titolo) {
        if(titolo.equals("")) {
            return "vuoto";
        } else if(titolo.length()>40) {
            return "lunga";
        }
        return "ok";
    }

    public boolean verificaDescrizione(String descrizione) {
        if(descrizione.equals("")) {
            return false;
        }
        return true;
    }

}
