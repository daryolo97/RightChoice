package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class RisultatoQuestionarioActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_risultato_questionario);

    ListView listView = findViewById(R.id.risultatoListView);

    ArrayList<String> listaCorsiOttenuti = getIntent().getStringArrayListExtra("array");
    ArrayList<String> listaCorsiConsigliati = new ArrayList<>();

    ArrayList<Integer> number = new ArrayList<Integer>();
    for (int i = 1; i <= listaCorsiOttenuti.size(); ++i) {
      number.add(i);
    }
    Collections.shuffle(number);

    if (listaCorsiOttenuti.size() > 4) {
      listaCorsiConsigliati.add(listaCorsiOttenuti.get(number.get(0)));
      listaCorsiConsigliati.add(listaCorsiOttenuti.get(number.get(1)));
      listaCorsiConsigliati.add(listaCorsiOttenuti.get(number.get(2)));
      listaCorsiConsigliati.add(listaCorsiOttenuti.get(number.get(3)));

      ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
              R.layout.layout_corso, R.id.nomeCorsoListView, listaCorsiConsigliati);

      listView.setAdapter(arrayAdapter);
    } else if (listaCorsiOttenuti.size() > 0 && listaCorsiOttenuti.size() <= 4) {
      for (int count = 0; count < listaCorsiOttenuti.size(); count++) {
        listaCorsiConsigliati.add(listaCorsiOttenuti.get(count));
      }

      ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
              R.layout.layout_corso, R.id.nomeCorsoListView, listaCorsiConsigliati);
      listView.setAdapter(arrayAdapter);
    }
  }

  /**
   * Metodo che permette di lanciare l'activity al tocco della view
   * cui è legata e di terminare l'activity corrente.
   * @param v rappresenta la view cliccata
   */
  public void vaiAListaCorsi(View v) {
    Intent intent = new Intent(getApplicationContext(), ListaCorsiActivity.class);
    startActivity(intent);
    finish();
  }
}