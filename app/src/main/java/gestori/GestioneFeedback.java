package gestori;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import database.DatabaseHelper;
import entity.Feedback;

import java.util.ArrayList;

public class GestioneFeedback  {
  private SQLiteDatabase database;
  private Context context;
  private DatabaseHelper dbHelper;

  public GestioneFeedback(Context ctx) {
    this.context = ctx;
    dbHelper = new DatabaseHelper(context);
  }

  /**
   * Metodo che permette di inserire un feedback all'interno
   * della tabella 'feedback' all'interno del database.
   * @param feedback rappresenta il feedback da inserire all'interno del database
   */
  public void inserisciFeedback(Feedback feedback) {
    ContentValues values = new ContentValues();

    values.put("codiceCorso", feedback.getCodiceCorso());
    values.put("titolo", feedback.getTitolo());
    values.put("descrizione", feedback.getDescrizione());
    values.put("stato", feedback.getStato());

    SQLiteDatabase db = dbHelper.getWritableDatabase();

    db.insert("feedback", null, values);
  }

  /**
   * metodo che permette di elaborare la lista dei feedback presenti all'interno della
   * tabella 'feedback' all'interno del database.
   * @return la lista contenente tutti i feedback presenti nel database
   */
  public ArrayList<Feedback> listaFeedback() {
    ArrayList<Feedback> listaFeedback = new ArrayList<>();
    String query = "SELECT * FROM feedback";

    SQLiteDatabase db = dbHelper.getReadableDatabase();
    Cursor c = db.rawQuery(query, null);

    if (c.moveToFirst()) {
      do {
        Feedback feedback = new Feedback();
        feedback.setCodiceCorso(c.getString(c.getColumnIndex("codiceCorso")));
        feedback.setTitolo(c.getString(c.getColumnIndex("titolo")));
        feedback.setDescrizione((c.getString(c.getColumnIndex("descrizione"))));
        feedback.setStato(c.getInt(c.getColumnIndex("stato")));

        listaFeedback.add(feedback);
      } while (c.moveToNext());
    }
    return listaFeedback;
  }

  /**
   * Metodo che permette di cancellare un feedback presente all'interno
   * della tabella 'feedback' all'interno del database.
   * @param feedback rappresenta il feedback da cancellare dal database
   */
  public void cancellaFeedback(Feedback feedback) {
    SQLiteDatabase db = dbHelper.getWritableDatabase();

    db.delete("feedback", "titolo = ? AND descrizione = ?",
            new String[]{feedback.getTitolo(), feedback.getDescrizione()});
  }

  /**
   * Metodo che pone lo 'stato' del feedback da 0 a 1.
   * @param feedback rappresenta il feedback da settare
   */
  public void setStatoFeedback(Feedback feedback) {
    SQLiteDatabase db = dbHelper.getWritableDatabase();

    ContentValues contentValues = new ContentValues();
    contentValues.put("stato", 1);

    db.update("feedback", contentValues, "titolo=? AND descrizione=?",
            new String[]{feedback.getTitolo(), feedback.getDescrizione()});
  }



}
