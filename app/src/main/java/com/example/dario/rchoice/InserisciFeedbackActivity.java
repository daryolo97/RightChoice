package com.example.dario.rchoice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import entity.Corso;
import entity.Feedback;
import facade.GestoreRightChoice;

import java.util.ArrayList;

public class InserisciFeedbackActivity extends AppCompatActivity {
  private GestoreRightChoice gestoreRightChoice;
  private ArrayList<Corso> listaCorsi;
  private EditText titoloET;
  private EditText descrizioneET;
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

  /**
   * Metodo che permette di creare un feedback da inserire nella lista dei
   * feedback in sospeso e di terminare l'activity corrente al tocco della view cui è legata.
   * @param v rappresenta la view cliccata
   */
  public void creaFeedback(View v) {
    Corso corso = listaCorsi.get(value);

    String titolo = titoloET.getText().toString();
    String descrizione = descrizioneET.getText().toString();


    if (!verificaTitolo(titolo)) {
      Toast.makeText(getApplicationContext(), "Il campo 'Titolo' non può essere vuoto e "
              +
              "non può contenere più di 40 caratteri", Toast.LENGTH_SHORT).show();
    } else if (!verificaDescrizione(descrizione)) {
      Toast.makeText(getApplicationContext(), "Il campo 'Descrizione' non può essere vuoto",
              Toast.LENGTH_SHORT).show();
    } else {
      Feedback feedback = new Feedback();

      feedback.setTitolo(titolo);
      feedback.setDescrizione(descrizione);
      feedback.setCodiceCorso(corso.getCodice());
      feedback.setStato(0);

      gestoreRightChoice.inserisciFeedback(feedback);

      Toast.makeText(getApplicationContext(), "Feedback inserito nella lista in sospeso,"
              +
      " attendi la convalidazione dell'admin", Toast.LENGTH_LONG).show();
      finish();
    }
  }

  /**
   * Metodo che permette di verificare la correttezza del formato
   * del titolo del feedback che vuole inserire l'utente.
   * @param titolo rappresenta la stringa del titolo del feedback che si vuole creare
   * @return false se il titolo è vuoto o ha un numero di caratteri > 40, true altrimenti
   */
  public boolean verificaTitolo(String titolo) {
    if (titolo.equals("")) {
      return false;
    } else if (titolo.length() > 40) {
      return false;
    }
    return true;
  }

  /**
   * Metodo che permette di verificare la correttezza del formato
   * della descrizione del feedback che vuole inserire l'utente.
   * @param descrizione rappresenta la stringa della descrizione del feedback che si vuole creare
   * @return false se il campo descrizione è vuoto, true altrimenti
   */
  public boolean verificaDescrizione(String descrizione) {
    if (descrizione.equals("")) {
      return false;
    }
    return true;
  }

}
