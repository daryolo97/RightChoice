package gestori;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import database.DatabaseHelper;
import entità.Corso;
import entità.Feedback;
import interfacce.InterfacciaFeedback;

public class GestioneFeedback implements InterfacciaFeedback {
    private SQLiteDatabase database;
    private Context context;
    private DatabaseHelper dbHelper;

    public GestioneFeedback(Context ctx) {
        this.context = ctx;
        dbHelper = new DatabaseHelper(context);
    }

    @Override
    public long inserisciFeedback(Feedback feedback, Corso corso) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("codiceCorso", corso.getCodice());
        values.put("titolo", feedback.getTitolo());
        values.put("descrizione", feedback.getDescrizione());
        values.put("stato", feedback.getStato());

        long feedback_id = db.insert("feedback", null, values);

        return feedback_id;
    }

    @Override
    public long inserisciFeedback(Feedback feedback) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("codiceCorso", feedback.getCodiceCorso());
        values.put("titolo", feedback.getTitolo());
        values.put("descrizione", feedback.getDescrizione());
        values.put("stato", feedback.getStato());

        long feedback_id = db.insert("feedback", null, values);

        return feedback_id;
    }

    @Override
    public ArrayList<Feedback> getAllFeedback() {
        ArrayList<Feedback> listaCorsi = new ArrayList<>();
        String query = "SELECT * FROM feedback";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do{
                Feedback corso = new Feedback();
                corso.setCodiceCorso(c.getString(c.getColumnIndex("codiceCorso")));
                corso.setTitolo(c.getString(c.getColumnIndex("titolo")));
                corso.setDescrizione((c.getString(c.getColumnIndex("descrizione"))));
                corso.setStato(c.getInt(c.getColumnIndex("stato")));

                listaCorsi.add(corso);
            }while(c.moveToNext());
        }
        return listaCorsi;
    }

    @Override
    public void deleteFeedback(Feedback feedback) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete("feedback", "titolo = ? AND descrizione = ?", new String[]{feedback.getTitolo(), feedback.getDescrizione()});

    }

    @Override
    public void setStatoFeedback(Feedback feedback) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("stato", 1);

        db.update("feedback", contentValues, "titolo=? AND descrizione=?", new String[]{feedback.getTitolo(), feedback.getDescrizione()});
    }



}
