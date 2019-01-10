package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import gestori.GestioneCorso;
import gestori.GestioneFeedback;


public class ListaCorsiActivityADMIN extends Activity {

    private GestioneCorso gestioneCorso;
    private GestioneFeedback gestioneFeedback;
    private TextView inserisci;


    private CorsoActivity corsoActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_corsi_admin);

        gestioneCorso = new GestioneCorso(getApplicationContext());

        ArrayList<String> listaNomiCorsi = gestioneCorso.getNomeCorsi();

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

        inserisci = findViewById(R.id.inserisciCorsoButton);
    }

    public void inserisciCorso(View view) {
        Intent intent = new Intent(getApplicationContext(), InserisciCorsoActivityADMIN.class);
        startActivity(intent);
        finish();
    }






}
