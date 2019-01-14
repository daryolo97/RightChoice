package com.example.dario.rchoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import entity.Corso;
import facade.GestoreRightChoice;

public class ModificaCorsoActivityAdmin extends AppCompatActivity {

  private GestoreRightChoice gestoreRightChoice;
  private EditText nomeCorso;
  private EditText docenteCorso;
  private EditText descrizioneCorso;
  private EditText linkCorso;
  private TextView codiceCorso;
  private Corso corso;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_modifica_corso_admin);

    gestoreRightChoice = new GestoreRightChoice(getApplicationContext());

    nomeCorso = findViewById(R.id.modificaNomeCorsoInserito);
    docenteCorso = findViewById(R.id.modificaDocenteCorsoInserito);
    descrizioneCorso = findViewById(R.id.modificaDescrizioneCorsoInserito);
    linkCorso = findViewById(R.id.modificaLinkCorsoInserito);
    codiceCorso = findViewById(R.id.modificaCodiceCorsoInserito);

    Bundle extra = getIntent().getExtras();
    int value = extra.getInt("posizione");

    corso = gestoreRightChoice.listaCorsi().get(value);

    nomeCorso.setText(corso.getNome(), TextView.BufferType.EDITABLE);
    docenteCorso.setText(corso.getDocente(), TextView.BufferType.EDITABLE);
    descrizioneCorso.setText(corso.getDescrizione(), TextView.BufferType.EDITABLE);
    linkCorso.setText(corso.getLink(), TextView.BufferType.EDITABLE);
    codiceCorso.setText(corso.getCodice());
  }

  /**
   * Metodo che permette di effettuare le modifiche su un corso, di lanciare
   * l'activity al tocco della view cui è legata e di terminare l'activity corrente.
   * @param v rappresenta la view cliccata
   */
  public void modificaCorso(View v) {

    String nome = nomeCorso.getText().toString();
    String docente = docenteCorso.getText().toString();
    String descrizione = descrizioneCorso.getText().toString();
    String link = linkCorso.getText().toString();

    gestoreRightChoice.modificaCorso(corso, nome, docente, descrizione, link);

    Intent intent = new Intent(getApplicationContext(), ListaCorsiActivityAdmin.class);
    startActivity(intent);
    Toast.makeText(getApplicationContext(), "Corso modificato correttamente",
            Toast.LENGTH_SHORT).show();
    finish();
  }

}
