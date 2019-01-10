package gestori;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import database.DatabaseHelper;
import entità.Corso;
import interfacce.InterfacciaCorso;

public class GestioneCorso implements InterfacciaCorso {
    private SQLiteDatabase database;
    private Context context;
    private DatabaseHelper dbHelper;

    public GestioneCorso(Context ctx) {
        context = ctx;
        dbHelper = new DatabaseHelper(context);
    }

    @Override
    public long inserisciCorsi(Corso corso) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("codice", corso.getCodice());
        values.put("nome", corso.getNome());
        values.put("docente", corso.getDocente());
        values.put("descrizione", corso.getDescrizione());
        values.put("link", corso.getLink());

        long corso_id = db.insert("corsi", null, values);

        return corso_id;
    }

    @Override
    public ArrayList<Corso> getAllCorsi() {
        ArrayList<Corso> listaCorsi = new ArrayList<>();
        String query = "SELECT * FROM corsi";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do{
                Corso corso = new Corso();
                corso.setCodice(c.getString(c.getColumnIndex("codice")));
                corso.setNome(c.getString(c.getColumnIndex("nome")));
                corso.setDocente(c.getString(c.getColumnIndex("docente")));
                corso.setDescrizione((c.getString(c.getColumnIndex("descrizione"))));
                corso.setLink(c.getString(c.getColumnIndex("link")));

                listaCorsi.add(corso);
            }while(c.moveToNext());
        }

        return listaCorsi;
    }

    @Override
    public ArrayList<String> getNomeCorsi() {
        ArrayList<String> listaNomiCorsi = new ArrayList<>();
        String query = "SELECT nome FROM corsi";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);


        if(c.moveToFirst()) {
            do{
                String nomeCorso = c.getString(c.getColumnIndex("nome"));
                listaNomiCorsi.add(nomeCorso);
            }while(c.moveToNext());
        }

        return listaNomiCorsi;
    }

    @Override
    public boolean verificaCodiceCorso(Corso corso) {
        database = dbHelper.getReadableDatabase();
        ArrayList<Corso> listaCorsi = this.getAllCorsi();

        for(int i=0; i<listaCorsi.size(); i++) {
            if(listaCorsi.get(i).getCodice().equals(corso.getCodice()))
                return false;
        }

        return true;
    }

    @Override
    public void updateCorso(Corso corso, String nome, String docente, String descrizione, String link) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nome", nome);
        contentValues.put("docente", docente);
        contentValues.put("descrizione", descrizione);
        contentValues.put("link", link);

        db.update("corsi", contentValues, "codice=?", new String[]{corso.getCodice()});
    }

    @Override
    public void deleteCorso(Corso corso) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete("corsi",  "codice = ?", new String[]{corso.getCodice()});
    }


}
