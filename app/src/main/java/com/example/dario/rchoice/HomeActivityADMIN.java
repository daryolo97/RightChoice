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
