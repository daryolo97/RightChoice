package com.example.dario.rchoice;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import database.DatabaseHelper;
import entità.Studente;
import facade.GestoreRightChoice;
import gestori.GestioneFeedback;
import gestori.GestioneStudente;
import entità.Admin;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameET, passwordET;
    private GestoreRightChoice gestoreRightChoice;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameET = findViewById(R.id.userName);
        passwordET = findViewById(R.id.password);

        databaseHelper = new DatabaseHelper(getApplicationContext());

        gestoreRightChoice = new GestoreRightChoice(getApplicationContext());

        Admin admin = new Admin("admin", "admin");
        Studente studente = new Studente(1234, "test", "test", "dario", "dario");

        gestoreRightChoice.inserisciAdmin(admin);
        gestoreRightChoice.inserisciStudente(studente);

        databaseHelper.closeDB();
    }

    /**
     * Metodo che permette di effettuare il login per accedere al sistema
     * @param v rappresenta la view cliccata
     */
    public void loginPremuto (View v) {
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();

        if(gestoreRightChoice.verificaEsistenzaStudenti(username, password)) {
            setHomeActivity();
            finish();
        }
        else if (gestoreRightChoice.loginAdmin(username, password)) {
            setAdminActivity();
            finish();
        }

        else
            Toast.makeText(getApplicationContext(), "Username e Password non validi", Toast.LENGTH_SHORT).show();


    }

    /**
     * Metodo che permette di lanciare l'activity al tocco della view cui è legata
     * @param v rappresenta la view cliccata
     */
    public void RegistrazionePremuta (View v) {
        Intent intent = new Intent(getApplicationContext(), RegistrazioneActivity.class);
        startActivity(intent);
    }

    /**
     * Metodo che permette di istanziare l'intent che serve a lanciare l'activity
     */
    public void setAdminActivity() {
        Intent intent = new Intent(getApplicationContext(), HomeActivityADMIN.class);
        startActivity(intent);
    }


    /**
     * Metodo che permette di istanziare l'intent che serve a lanciare l'activity
     */
    public void setHomeActivity() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);

    }


}
