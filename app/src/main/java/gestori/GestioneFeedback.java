package gestori;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import database.DatabaseHelper;
import entità.Corso;
import entità.Feedback;

public class GestioneFeedback  {
    private SQLiteDatabase database;
    private Context context;
    private DatabaseHelper dbHelper;

    public GestioneFeedback(Context ctx) {
        this.context = ctx;
        dbHelper = new DatabaseHelper(context);
    }




    public void inserisciFeedback(Feedback feedback) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("codiceCorso", feedback.getCodiceCorso());
        values.put("titolo", feedback.getTitolo());
        values.put("descrizione", feedback.getDescrizione());
        values.put("stato", feedback.getStato());

        db.insert("feedback", null, values);

    }


    public ArrayList<Feedback> listaFeedback() {
        ArrayList<Feedback> listaFeedback = new ArrayList<>();
        String query = "SELECT * FROM feedback";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do{
                Feedback feedback = new Feedback();
                feedback.setCodiceCorso(c.getString(c.getColumnIndex("codiceCorso")));
                feedback.setTitolo(c.getString(c.getColumnIndex("titolo")));
                feedback.setDescrizione((c.getString(c.getColumnIndex("descrizione"))));
                feedback.setStato(c.getInt(c.getColumnIndex("stato")));

                listaFeedback.add(feedback);
            }while(c.moveToNext());
        }
        return listaFeedback;
    }


    public void cancellaFeedback(Feedback feedback) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete("feedback", "titolo = ? AND descrizione = ?", new String[]{feedback.getTitolo(), feedback.getDescrizione()});

    }


    public void setStatoFeedback(Feedback feedback) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("stato", 1);

        db.update("feedback", contentValues, "titolo=? AND descrizione=?", new String[]{feedback.getTitolo(), feedback.getDescrizione()});
    }



}
