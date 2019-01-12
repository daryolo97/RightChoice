package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import facade.GestoreRightChoice;
import gestori.GestioneCorso;
import entità.Corso;

public class InserisciCorsoActivityADMIN extends AppCompatActivity {

    private EditText nome, docente, descrizione, codice, link;
    private GestoreRightChoice gestoreRightChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserisci_corso);

        gestoreRightChoice = new GestoreRightChoice(getApplicationContext());

        nome = findViewById(R.id.nomeCorsoInserito);
        docente = findViewById(R.id.docenteCorsoInserito);
        descrizione = findViewById(R.id.descrizioneCorsoInserito);
        codice = findViewById(R.id.codiceCorsoInserito);
        link = findViewById(R.id.linkCorsoInserito);


    }

    public void inserisciCorso(View v) {

        String nomeCorso = nome.getText().toString();
        String docenteCorso = docente.getText().toString();
        String descrizioneCorso = descrizione.getText().toString();
        String codiceCorso = codice.getText().toString();
        String linkCorso = link.getText().toString();

        Corso corso = new Corso(codiceCorso, nomeCorso, docenteCorso, descrizioneCorso, linkCorso);

        if(!verificaNome(nomeCorso)) {
            Toast.makeText(getApplicationContext(), "Il campo 'Nome Corso' non può essere vuoto", Toast.LENGTH_SHORT).show();
        } else if(!verificaNomeDocente(docenteCorso)) {
            Toast.makeText(getApplicationContext(), "Il campo 'Nome Docente' non può essere vuoto", Toast.LENGTH_SHORT).show();
        } else if (!verificaDescrizione(descrizioneCorso)) {
            Toast.makeText(getApplicationContext(), "Il campo 'Descrizione' non può essere vuoto", Toast.LENGTH_SHORT).show();
        } else if(!verificaCodice(codiceCorso)) {
            Toast.makeText(getApplicationContext(), "Il campo 'Codice Corso' deve essere di 6 caratteri", Toast.LENGTH_SHORT).show();
        } else if(!verificaLink(linkCorso)) {
            Toast.makeText(getApplicationContext(), "Il campo 'Link' deve contenere massimo100 caratteri", Toast.LENGTH_SHORT).show();
        } else {
            if(gestoreRightChoice.verificaCodiceCorso(corso)) {
                gestoreRightChoice.inserisciCorso(corso);
                Toast.makeText(getApplicationContext(), "Corso inserito correttamente", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), ListaCorsiActivityADMIN.class));
                finish();
            }else {
                Toast.makeText(getApplicationContext(), "Codice del corso già utilizzato", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean verificaNome(String nome) {
        if(nome.equals("")) {
            return false;
        }
        return true;
    }

    public boolean verificaNomeDocente(String docente) {
        if(docente.equals("")) {
            return false;
        }
        return true;
    }

    public boolean verificaDescrizione(String descrizione) {
        if(descrizione.equals("")) {
            return false;
        }
        return true;
    }

    public boolean verificaCodice(String codice) {
        if(codice.length()!=6) {
            return false;
        }
        return true;
    }

    public boolean verificaLink(String link) {
        if(link.length()>100) {
            return false;
        }
        return true;
    }

}
