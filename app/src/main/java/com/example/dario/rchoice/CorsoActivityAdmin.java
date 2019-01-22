package com.example.dario.rchoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import facade.GestoreRightChoice;
import interfacce.InterfacciaRightChoice;

public class CorsoActivityAdmin extends AppCompatActivity {
  private InterfacciaRightChoice gestoreRightChoice;
  private TextView tvNomeCorso;
  private TextView tvDocente;
  private TextView tvDescrizione;
  private TextView tvLink;
  private int value;
  Intent intent;
  Intent intent2;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_corso_admin);

    gestoreRightChoice = new GestoreRightChoice(getApplicationContext());
    tvNomeCorso = findViewById(R.id.nomeCorsoSpecifico);
    tvDocente = findViewById(R.id.nomeDocenteSpecifico);
    tvDescrizione = findViewById(R.id.descrizioneSpecifica);
    tvLink = findViewById(R.id.linkSpecifico);

    //"prelevo" i dati dall'activity precedente
    Bundle extra = getIntent().getExtras();
    value = extra.getInt("posizione");

    tvNomeCorso.setText(gestoreRightChoice.listaCorsi().get(value).getNome().toUpperCase());
    tvDocente.setText(gestoreRightChoice.listaCorsi().get(value).getDocente());
    tvDescrizione.setText(gestoreRightChoice.listaCorsi().get(value).getDescrizione());
    tvLink.setText(gestoreRightChoice.listaCorsi().get(value).getLink());
  }

  /**
   * Metodo che permette di lanciare l'activity al tocco
   * della view cui è legata inviandole dei dati.
   * @param v rappresenta l'activity da lanciare
   */
  public void eliminaCorso(View v) {
    gestoreRightChoice.cancellaCorso(gestoreRightChoice.listaCorsi().get(value));
    startActivity(new Intent(getApplicationContext(),
            ListaCorsiActivityAdmin.class));
    Toast.makeText(getApplicationContext(), "Corso eliminato correttamente",
            Toast.LENGTH_SHORT).show();
    finish();
  }


  /**
   * Metodo che permette di lanciare l'activity al tocco
   * della view cui è legata inviandole dei dati.
   * @param v rappresenta la view cliccata
   */
  public void lanciaModificaCorso(View v) {
    Intent intent = new Intent(getApplicationContext(), ModificaCorsoActivityAdmin.class);
    intent.putExtra("posizione", value);
    startActivity(intent);
    finish();
  }
}
