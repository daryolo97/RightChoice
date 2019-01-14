package com.example.dario.rchoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HomeActivityAdmin extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home_admin);
  }

  /**
   * Metodo che permette di lanciare l'activity al tocco della view cui è legata.
   * @param v rappresenta la view cliccata
   */
  public void listaCorsiPremuta(View v) {
    Intent intent = new Intent(getApplicationContext(), ListaCorsiActivityAdmin.class);
    startActivity(intent);
  }

  /**
   * Metodo che permette di lanciare l'activity al tocco della
   * view cui è legata e di terminare l'activity corrente.
   * @param v rappresenta la view cliccata
   */
  public void listaFeedbackInSospesoPremuto(View v) {
    Intent intent = new Intent(getApplicationContext(), ListaFeedbackInSospesoActivity.class);
    startActivity(intent);
    finish();
  }


}
