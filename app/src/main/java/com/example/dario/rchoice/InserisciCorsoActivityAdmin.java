package com.example.dario.rchoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import entity.Corso;

import facade.GestoreRightChoice;

public class InserisciCorsoActivityAdmin extends AppCompatActivity {
  private EditText nome;
  private EditText docente;
  private EditText descrizione;
  private EditText codice;
  private EditText link;
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

  /**
   * Metodo che permette di verificare che la correttezza di tutti i campi del
   * form per l'inserimento dei corsi e in tal caso, di lanciare l'activity.
   * @param v rappresenta la view cliccata
   */
  public void verificaCampiInserimentoCorso(View v) {
    String nomeCorso = nome.getText().toString();
    String docenteCorso = docente.getText().toString();
    String descrizioneCorso = descrizione.getText().toString();
    String codiceCorso = codice.getText().toString();
    String linkCorso = link.getText().toString();

    Corso corso = new Corso(codiceCorso, nomeCorso, docenteCorso, descrizioneCorso, linkCorso);

    if (!verificaNome(nomeCorso)) {
      Toast.makeText(getApplicationContext(), "Il campo 'Nome Corso' non può essere vuoto",
              Toast.LENGTH_SHORT).show();
    } else if (!verificaNomeDocente(docenteCorso)) {
      Toast.makeText(getApplicationContext(), "Il campo 'Nome Docente' non può essere vuoto",
              Toast.LENGTH_SHORT).show();
    } else if (!verificaDescrizione(descrizioneCorso)) {
      Toast.makeText(getApplicationContext(), "Il campo 'Descrizione' non può essere vuoto",
              Toast.LENGTH_SHORT).show();
    } else if (!verificaCodice(codiceCorso)) {
      Toast.makeText(getApplicationContext(), "Il campo 'Codice Corso' deve essere di 6 caratteri",
              Toast.LENGTH_SHORT).show();
    } else if (!verificaLink(linkCorso)) {
      Toast.makeText(getApplicationContext(),
              "Il campo 'Link' deve contenere massimo100 caratteri", Toast.LENGTH_SHORT).show();
    } else {
      if (gestoreRightChoice.verificaCodiceCorso(corso)) {
        gestoreRightChoice.inserisciCorso(corso);
        Toast.makeText(getApplicationContext(), "Corso inserito correttamente",
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), ListaCorsiActivityAdmin.class));
        finish();
      } else {
        Toast.makeText(getApplicationContext(), "Codice del corso già utilizzato",
                Toast.LENGTH_SHORT).show();
      }
    }
  }

  /**
   * Metodo che permette di verificare se il campo 'nome del corso' è vuoto.
   * @param nome rappresenta la stringa del nome del corso che l'admin ha inserito
   * @return false se il campo 'nome del corso' è vuoto, true altrimenti
   */
  public boolean verificaNome(String nome) {
    if (nome.equals("")) {
      return false;
    }
    return true;
  }

  /**
   * Metodo che permette di verificare se il campo 'docente del corso' è vuoto.
   * @param docente rappresenta la stringa del nome del docente del corso che l'admin ha inserito
   * @return false se il campo 'docente del corso' è vuoto, true altrimenti
   */
  public boolean verificaNomeDocente(String docente) {
    if (docente.equals("")) {
      return false;
    }
    return true;
  }

  /**
   * Metodo che permette di verificare se il campo 'descrizione del corso' è vuoto.
   * @param descrizione rappresenta la stringa della descrizione del corso che l'admin ha inserito
   * @return false se il campo 'descrizione del corso' è vuoto, true altrimenti
   */
  public boolean verificaDescrizione(String descrizione) {
    if (descrizione.equals("")) {
      return false;
    }
    return true;
  }

  /**
   * Metodo che permette di verificare se il campo 'codice del
   * corso' contiene un numero di caratteri diverso da 6.
   * @param codice rappresenta la stringa del codice del corso che l'admin ha inserito
   * @return false se il campo 'codice del corso' ha un numero di caratteri != da 6, true altrimenti
   */
  public boolean verificaCodice(String codice) {
    if (codice.length() != 6) {
      return false;
    }
    return true;
  }

  /**
   * Metodo che permette di verificare se il campo 'link del corso'
   * contiene un numero di caratteri > 100.
   * @param link rappresenta la stringa del link del corso che l'admin ha inserito
   * @return false se il campo 'link del corso' ha un numero di caratteri > 100, true altrimenti
   */
  public boolean verificaLink(String link) {
    if (link.length() > 100) {
      return false;
    }
    return true;
  }

}
