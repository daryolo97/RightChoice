package com.example.dario.rchoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import entity.Corso;
import entity.Feedback;
import facade.GestoreRightChoice;

import java.util.ArrayList;

public class FeedbackInSospesoActivity extends AppCompatActivity {
  private GestoreRightChoice gestoreRightChoice;
  private TextView nomeCorso;
  private TextView titolo;
  private TextView descrizione;
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
    gestoreRightChoice = new GestoreRightChoice(getApplicationContext());

    //tramite gli adapter prelevo le liste dei feedback e dei corsi dal database
    ArrayList<Feedback> listaFeedback = gestoreRightChoice.listaFeedback();
    listaFeedbackInSospeso = new ArrayList<>();
    ArrayList<Corso> listaCorsi = gestoreRightChoice.listaCorsi();

    //inserisco all'interno di listaFeedbackInSospeso tutti i feedback in sospeso
    for (int i = 0; i < listaFeedback.size(); i++) {
      if (listaFeedback.get(i).getStato() == 0) {
        listaFeedbackInSospeso.add(listaFeedback.get(i));
      }
    }


    for (int j = 0; j < listaCorsi.size();j++) {
      if (listaFeedbackInSospeso.get(value)
              .getCodiceCorso().equals(listaCorsi.get(j).getCodice())) {
        nome = listaCorsi.get(j).getNome();
      }
    }


    nomeCorso = findViewById(R.id.nomeCorsoFeedback);
    titolo = findViewById(R.id.titoloFeedbackInSospeso);
    descrizione = findViewById(R.id.descrizioneFeedbackInSospeso);


    nomeCorso.setText(nome);
    titolo.setText(listaFeedbackInSospeso.get(value).getTitolo());
    descrizione.setText(listaFeedbackInSospeso.get(value).getDescrizione());
  }

  /**
   * Metodo che permette di lanciare l'activity al tocco della view cui è legata.
   * @param v rappresenta la view cliccata
   */
  public void convalidaButton(View v) {
    gestoreRightChoice.setStatoFeedback(listaFeedbackInSospeso.get(value));
    startActivity(new Intent(getApplicationContext(), ListaFeedbackInSospesoActivity.class));
    finish();
    Toast.makeText(getApplicationContext(), "Feedback convalidato", Toast.LENGTH_SHORT).show();
  }

  /**
   * Metodo che permette di lanciare l'activity al tocco della view cui è legata.
   * @param v rappresenta la view cliccata
   */
  public void rifiutaButton(View v) {
    gestoreRightChoice.cancellaFeedback(listaFeedbackInSospeso.get(value));
    finish();
    Toast.makeText(getApplicationContext(), "Feedback scartato", Toast.LENGTH_SHORT).show();
  }

}
