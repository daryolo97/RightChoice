package gestori;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import database.DatabaseHelper;
import entity.Studente;

import java.util.ArrayList;

public class GestioneStudente {
  private SQLiteDatabase database;
  private Context context;
  private DatabaseHelper dbHelper;

  public GestioneStudente(Context ctx) {
    context = ctx;
    dbHelper = new DatabaseHelper(context);
  }

  /**
   * Metodo che permette di inserire uno studente all'interno della
   * tabella 'studenti' all'interno del database.
   * @param studente rappresenta lo studente che si vuole inserire nel database
   */
  public void inserisciStudente(Studente studente) {
    ContentValues values = new ContentValues();

    values.put("matricola", studente.getMatricola());
    values.put("username", studente.getUsername());
    values.put("password", studente.getPassword());
    values.put("nome", studente.getNome());
    values.put("cognome", studente.getCognome());

    SQLiteDatabase db = dbHelper.getWritableDatabase();

    db.insert("studenti", null, values);

  }

  /**
   * Metodo che permette di elaborare la lista di tutti gli studenti presenti
   * nella tabella 'studenti' all'interno del database.
   * @return una lista contenente tutti gli studenti presenti nel database
   */
  public ArrayList<Studente> listaStudenti() {
    ArrayList<Studente> listaStudenti = new ArrayList<>();
    String query = "SELECT * FROM studenti";

    SQLiteDatabase db = dbHelper.getReadableDatabase();
    Cursor c = db.rawQuery(query, null);

    if (c.moveToFirst()) {
      do {
        Studente studente = new Studente();
        studente.setMatricola(c.getInt(c.getColumnIndex("matricola")));
        studente.setUsername(c.getString(c.getColumnIndex("username")));
        studente.setPassword(c.getString(c.getColumnIndex("password")));
        studente.setNome((c.getString(c.getColumnIndex("nome"))));
        studente.setCognome(c.getString(c.getColumnIndex("cognome")));

        listaStudenti.add(studente);
      } while (c.moveToNext());
    }

    return listaStudenti;
  }



  /**
    * Metodo che permette di vedere di vedere se i parametri 'username' e 'password'
    * sono presenti all'interno della tabella 'studenti' all'interno del database.
    * @param username rappresenta la stringa dell'username da verificare
    * @param password rappresenta la stringa della password da verificare
    * @return true se la coppia username e password esiste nel database, false altrimenti
    */
  public boolean verificaEsistenzaStudenti(String username, String password) {
    ArrayList<Studente> listaStudenti = this.listaStudenti();

    for (int i = 0; i < listaStudenti.size(); i++) {
      if (listaStudenti.get(i).getUsername().equals(username)
              && listaStudenti.get(i).getPassword().equals(password)) {
        return true;
      }
    }

    return false;
  }

  /**
     *Metodo che verifica se un'username di uno studente è già presente all'interno
     * della colonna 'username' della tabella studenti all'interno del database.
     * @param studente rappresenta lo studente di cui si vuole verificare l'username
     * @return true se la coppia username e password esiste nel database, false altrimenti
     */
  public boolean verificaUsernameStudente(Studente studente) {

    if (studente == null) {
      return false;
    }

    ArrayList<Studente> listaStudenti = this.listaStudenti();
    for (int i = 0; i < listaStudenti.size(); i++) {
      if (studente.getUsername().equals(listaStudenti.get(i).getUsername())) {
        return false;
      }
    }

    return true;
  }

  /**
   * Metodo che verifica se la matricola di uno studente è già presente all'interno
   * della colonna 'matricola' della tabella studenti all'interno del database.
   * @param studente rappresenta lo studente di cui si vuole verificare la matricola
   * @return true se la matricola dello studente non esiste nel database, false altrimenti
   */
  public boolean verificaMatricolaStudente(Studente studente) {
    database = dbHelper.getReadableDatabase();

    if (studente == null) {
      return false;
    }

    ArrayList<Studente> listaStudenti = this.listaStudenti();
    for (int i = 0; i < listaStudenti.size(); i++) {
      if (studente.getMatricola() == listaStudenti.get(i).getMatricola()) {
        return false;
      }
    }
    return true;
  }


}
