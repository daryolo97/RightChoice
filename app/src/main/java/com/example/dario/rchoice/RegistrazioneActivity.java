package com.example.dario.rchoice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import gestori.GestioneStudente;
import entità.Studente;

public class RegistrazioneActivity extends Activity {
    private EditText usernameET, passwordET, confermaPaswordET, matricolaET, nomeET, cognomeET;
    private GestioneStudente gestioneStudente;
    private String username, password, nome, cognome;
    private int matricola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        usernameET = findViewById(R.id.userNameRegistrazione);
        passwordET = findViewById(R.id.passwordRegistrazione);
        confermaPaswordET = findViewById(R.id.confermaPasswordRegistrazione);
        matricolaET = findViewById(R.id.matricolaRegistrazione);
        nomeET = findViewById(R.id.nomeRegistrazione);
        cognomeET = findViewById(R.id.cognomeRegistrazione);

        gestioneStudente = new GestioneStudente(getApplicationContext());


    }

    public void confermaRegistrazionePremuto(View v) {
        matricola = Integer.parseInt(matricolaET.getText().toString());
        username = usernameET.getText().toString();
        password = passwordET.getText().toString();
        nome = nomeET.getText().toString();
        cognome = cognomeET.getText().toString();



        Studente studente = new Studente(matricola, username, password, nome, cognome);

        if (username.equals("") || password.equals("") || String.valueOf(matricola).equals("") || nome.equals("") || cognome.equals("")) {
            Toast.makeText(getApplicationContext(), "Non è possibile lasciare campi vuoti", Toast.LENGTH_LONG).show();
        }

        else if(gestioneStudente.verificaUsername(studente) == false) {
            Toast.makeText(getApplicationContext(), "Username esistente", Toast.LENGTH_LONG).show();
        }

        else if(gestioneStudente.verificaMatricola(studente) == false) {
            Toast.makeText(getApplicationContext(), "Matricola esistente", Toast.LENGTH_LONG).show();
        }

        else {
            Toast.makeText(getApplicationContext(), "Studente aggiunto", Toast.LENGTH_LONG).show();
            gestioneStudente.inserisciStudente(studente);
        }


    }

    public void tornaSchermataLogin(View v) {
        finish();
    }


}
