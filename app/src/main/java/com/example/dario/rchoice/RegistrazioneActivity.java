package com.example.dario.rchoice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import entity.Studente;
import facade.GestoreRightChoice;

public class RegistrazioneActivity extends AppCompatActivity {
  private EditText usernameET;
  private EditText passwordET;
  private EditText confermaPaswordET;
  private EditText matricolaET;
  private EditText nomeET;
  private EditText cognomeET;
  private GestoreRightChoice gestoreRightChoice;
  private String username;
  private String password;
  private String nome;
  private String cognome;
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

    gestoreRightChoice = new GestoreRightChoice(getApplicationContext());
  }

  /**
   * Metodo che permette di effettuare la registrazione di un utente,
   * di lanciare l'activity al tocco della view cui è legata e di terminare l'activity corrente.
   * @param v rappresenta la view cliccata
   */
  public void confermaRegistrazionePremuto(View v) {
    matricola = Integer.parseInt(matricolaET.getText().toString());
    username = usernameET.getText().toString();
    password = passwordET.getText().toString();
    nome = nomeET.getText().toString();
    cognome = cognomeET.getText().toString();



    Studente studente = new Studente(matricola, username, password, nome, cognome);

    if (username.equals("") || password.equals("") || String.valueOf(matricola).equals("")
            || nome.equals("") || cognome.equals("")) {
      Toast.makeText(getApplicationContext(),
              "Non è possibile lasciare campi vuoti", Toast.LENGTH_LONG).show();
    } else if (!gestoreRightChoice.verificaUsernameStudente(studente)
            || !gestoreRightChoice.verificaUsernameAdmin(username)) {
      Toast.makeText(getApplicationContext(), "Username esistente",
              Toast.LENGTH_LONG).show();
    } else if (!gestoreRightChoice.verificaMatricolaStudente(studente)) {
      Toast.makeText(getApplicationContext(), "Matricola esistente",
              Toast.LENGTH_LONG).show();
    } else {
      Toast.makeText(getApplicationContext(), "Studente aggiunto",
              Toast.LENGTH_LONG).show();
      gestoreRightChoice.inserisciStudente(studente);
    }
  }

  /**
   * Metodo che permette di terminare l'activity corrente.
   * @param v rappresenta la view cliccata
   */
  public void tornaSchermataLogin(View v) {
    finish();
  }
}
