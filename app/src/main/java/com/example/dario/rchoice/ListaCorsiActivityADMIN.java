package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import facade.GestoreRightChoice;
import gestori.GestioneCorso;
import gestori.GestioneFeedback;


public class ListaCorsiActivityADMIN extends AppCompatActivity {

    private GestoreRightChoice gestoreRightChoice;


    private CorsoActivity corsoActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_corsi_admin);

        gestoreRightChoice = new GestoreRightChoice(getApplicationContext());

        ArrayList<String> listaNomiCorsi = gestoreRightChoice.getNomeCorsi();

        ArrayAdapter<String> arrayAdapterNome = new ArrayAdapter<String>(this, R.layout.layout_corso, R.id.nomeCorsoListView, listaNomiCorsi);

        ListView listView = findViewById(R.id.listaCorsiListView);
        listView.setAdapter(arrayAdapterNome);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), CorsoActivityADMIN.class);
                intent.putExtra("posizione", position);
                startActivity(intent);
            }
        });

    }

    /**
     * Metodo che permette di lanciare l'activity al tocco della view cui è legata e di terminare l'activity corrente
     * @param view rappresenta la view cliccata
     */
    public void inserisciCorso(View view) {
        Intent intent = new Intent(getApplicationContext(), InserisciCorsoActivityADMIN.class);
        startActivity(intent);
        finish();
    }






}
