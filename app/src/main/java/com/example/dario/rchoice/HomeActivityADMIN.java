package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import gestori.GestioneCorso;
import gestori.GestioneFeedback;
import entità.Questionario;

public class HomeActivityADMIN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);
    }

    /**
     * Metodo che permette di lanciare l'activity al tocco della view cui è legata
     * @param v rappresenta la view cliccata
     */
    public void listaCorsiPremuta(View v) {
        Intent intent = new Intent(getApplicationContext(), ListaCorsiActivityADMIN.class);
        startActivity(intent);
    }

    /**
     * Metodo che permette di lanciare l'activity al tocco della view cui è legata e di terminare l'activity corrente
     * @param v rappresenta la view cliccata
     */
    public void listaFeedbackInSospesoPremuto(View v) {
        Intent intent = new Intent(getApplicationContext(), ListaFeedbackInSospesoActivity.class);
        startActivity(intent);
        finish();
    }


}
