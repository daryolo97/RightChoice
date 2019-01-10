package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import gestori.GestioneCorso;
import gestori.GestioneFeedback;
import entità.Questionario;

public class HomeActivityADMIN extends Activity {
    private GestioneCorso gestioneCorso;
    private GestioneFeedback gestioneFeedback;
    private TextView TVdomanda1, TVdomanda2, TVdomanda3, TVdomanda4, TVdomanda5;
    private RadioButton risp1Domanda1Button;
    private RadioButton risp2Domanda1Button;
    private RadioButton risp3Domanda1Button;
    private RadioButton risp1Domanda2Button;
    private RadioButton risp2Domanda2Button;
    private RadioButton risp3Domanda2Button;
    private RadioButton risp1Domanda3Button;
    private RadioButton risp2Domanda3Button;
    private RadioButton risp3Domanda3Button;
    private RadioButton risp1Domanda4Button;
    private RadioButton risp2Domanda4Button;
    private RadioButton risp3Domanda4Button;
    private RadioButton risp1Domanda5Button;
    private RadioButton risp2Domanda5Button;
    private RadioButton risp3Domanda5Button;

    private Questionario questionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);


    }

    public void listaCorsiPremuta(View v) {
        Intent intent = new Intent(getApplicationContext(), ListaCorsiActivityADMIN.class);
        startActivity(intent);
    }



    public void listaFeedbackInSospesoPremuto(View v) {
        Intent intent = new Intent(getApplicationContext(), ListaFeedbackInSospesoActivity.class);
        startActivity(intent);
        finish();
    }


}
