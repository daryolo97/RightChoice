package com.example.dario.rchoice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import entity.Corso;
import facade.GestoreRightChoice;
import interfacce.InterfacciaRightChoice;

import java.util.ArrayList;

public class CorsoActivity extends AppCompatActivity {
  private InterfacciaRightChoice gestoreRightChoice;
  private TextView tvNomeCorso;
  private TextView tvDocente;
  private TextView tvDescrizione;
  private TextView tvLink;
  Intent intent;
  Intent intent2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_corso);

    gestoreRightChoice = new GestoreRightChoice(getApplicationContext());
    tvNomeCorso = findViewById(R.id.nomeCorsoSpecifico);
    tvDocente = findViewById(R.id.nomeDocenteSpecifico);
    tvDescrizione = findViewById(R.id.descrizioneSpecifica);
    tvLink = findViewById(R.id.linkSpecifico);

    //"prelevo" i dati dall'activity precedente
    Bundle extra = getIntent().getExtras();
    int value = extra.getInt("posizione");

    //istanzio l'intent
    intent = new Intent(getApplicationContext(), FeedbackActivity.class);
    intent.putExtra("posizione", value);

    //intent2
    intent2 = new Intent(getApplicationContext(), InserisciFeedbackActivity.class);
    intent2.putExtra("posizione", value);

    tvNomeCorso.setText(gestoreRightChoice.listaCorsi().get(value).getNome().toUpperCase());
    tvDocente.setText(gestoreRightChoice.listaCorsi().get(value).getDocente());
    tvDescrizione.setText(gestoreRightChoice.listaCorsi().get(value).getDescrizione());
    tvLink.setText(gestoreRightChoice.listaCorsi().get(value).getLink());
  }

  /**
   * Metodo che permette di lanciare l'activity al tocco della view cui è legata.
   * @param v rappresenta la view cliccata
   */
  public void visualizzaFeedback(View v) {
    startActivity(intent);
  }

  /**
   * Metodo che permette di lanciare l'activity al tocco della view cui è legata.
   * @param v rappresenta la view cliccata
   */
  public void inserisciFeedback(View v) {
    startActivity(intent2);
  }

  /**
   * Metodo che permette di lanciare l'activity al tocco della view cui è legata.
   * @param v rappresenta la view cliccata
   */
  public void apriLink(View v) {
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tvLink.getText().toString()));
    startActivity(intent);
  }
}
