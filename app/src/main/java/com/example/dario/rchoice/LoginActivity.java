package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import gestori.GestioneFeedback;
import gestori.GestioneStudente;
import entità.Admin;

public class LoginActivity extends Activity {
    private EditText usernameET, passwordET;
    private GestioneStudente gestioneStudente;
    private GestioneFeedback gestioneFeedback;
    private Admin admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameET = findViewById(R.id.userName);
        passwordET = findViewById(R.id.password);

        gestioneStudente = new GestioneStudente(getApplicationContext());
        gestioneFeedback = new GestioneFeedback(getApplicationContext());


        admin = new Admin();
    }

    public void loginPremuto (View v) {
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();



        if(gestioneStudente.verificaEsistenzaStudenti(username, password)) {
            setHomeActivity();
            finish();
        }
        else if (admin.verificaAdmin(username, password)) {
            setAdminActivity();
            finish();
        }

        else
            Toast.makeText(getApplicationContext(), "Username e Password non validi", Toast.LENGTH_SHORT).show();


    }

    public void RegistrazionePremuta (View v) {
        setRegisterActivity();

    }

    public void setAdminActivity() {
        Intent intent = new Intent(getApplicationContext(), HomeActivityADMIN.class);
        startActivity(intent);
    }
    public void setHomeActivity() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);

    }

    public void setRegisterActivity() {
        Intent intent = new Intent(getApplicationContext(), RegistrazioneActivity.class);
        startActivity(intent);
    }

}
