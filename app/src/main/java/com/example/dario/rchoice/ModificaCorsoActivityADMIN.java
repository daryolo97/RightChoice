package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import gestori.GestioneCorso;
import entità.Corso;

public class ModificaCorsoActivityADMIN extends Activity {

    private GestioneCorso gestioneCorso;
    private EditText nomeCorso, docenteCorso, descrizioneCorso, linkCorso;
    private TextView codiceCorso;
    private String nome, docente, descrizione, link;
    private Corso corso;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_corso_admin);

        gestioneCorso = new GestioneCorso(getApplicationContext());

        nomeCorso = findViewById(R.id.modificaNomeCorsoInserito);
        docenteCorso = findViewById(R.id.modificaDocenteCorsoInserito);
        descrizioneCorso = findViewById(R.id.modificaDescrizioneCorsoInserito);
        linkCorso = findViewById(R.id.modificaLinkCorsoInserito);
        codiceCorso = findViewById(R.id.modificaCodiceCorsoInserito);



        Bundle extra = getIntent().getExtras();
        int value = extra.getInt("posizione");

        corso = gestioneCorso.getAllCorsi().get(value);

        nomeCorso.setText(corso.getNome(), TextView.BufferType.EDITABLE);
        docenteCorso.setText(corso.getDocente(), TextView.BufferType.EDITABLE);
        descrizioneCorso.setText(corso.getDescrizione(), TextView.BufferType.EDITABLE);
        linkCorso.setText(corso.getLink(), TextView.BufferType.EDITABLE);
        codiceCorso.setText(corso.getCodice());



    }

    public void modificaCorso(View v) {

        nome = nomeCorso.getText().toString();
        docente = docenteCorso.getText().toString();
        descrizione = descrizioneCorso.getText().toString();
        link = linkCorso.getText().toString();

        gestioneCorso.updateCorso(corso, nome, docente, descrizione, link);

        Intent intent = new Intent(getApplicationContext(), ListaCorsiActivityADMIN.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Corso modificato correttamente", Toast.LENGTH_SHORT).show();
        finish();

    }

}
