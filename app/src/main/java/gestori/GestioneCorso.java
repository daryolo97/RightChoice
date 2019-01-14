package gestori;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import database.DatabaseHelper;
import entità.Corso;
import interfacce.InterfacciaRightChoice;

public class GestioneCorso  {
    private SQLiteDatabase database;
    private Context context;
    private DatabaseHelper dbHelper;

    public GestioneCorso(Context ctx) {
        context = ctx;
        dbHelper = new DatabaseHelper(context);
    }

    /**
     * Metodo che inserisce il corso nella tabella 'corsi' all'interno del database
     * @param corso rappresenta il corso da inserire
     */
    public void inserisciCorso(Corso corso) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("codice", corso.getCodice());
        values.put("nome", corso.getNome());
        values.put("docente", corso.getDocente());
        values.put("descrizione", corso.getDescrizione());
        values.put("link", corso.getLink());

        db.insert("corsi", null, values);

    }


    /**
     *Metodo che restituisce la lista dei corsi presenti nella tabella 'corsi' all'interno del database
     * @return La lista contenente tutti i corsi presenti nella tabella 'corsi' all'interno del database
     */
    public ArrayList<Corso> listaCorsi() {
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


    /**
     * Metodo che elabora la lista dei nomi di tutti i corsi presenti nella tabella 'corsi' all'interno del database
     * @return una lista contenente il nome dei corsi presenti presenti nella tabella 'corsi' all'interno del database
     */
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


    /**
     * Metodo che verifica se il codice del corso desiderato è già presente all'interno della colonna 'codice' della tabella 'corsi' all'interno del database
     * @param corso rappresenta il corso di cui si vuole verifica l'esistenza del codice
     * @return
     */
    public boolean verificaCodiceCorso(Corso corso) {
        database = dbHelper.getReadableDatabase();
        ArrayList<Corso> listaCorsi = this.listaCorsi();

        for(int i=0; i<listaCorsi.size(); i++) {
            if(listaCorsi.get(i).getCodice().equals(corso.getCodice()))
                return false;
        }

        return true;
    }

    /**
     * Metodo che permette di modificare le informazioni relative ad un corso, aggiornando la riga della tabella 'corsi' in questione
     * @param corso rappresenta il corso che si vuole modificare
     * @param nome rappresenta il nuovo nome da dare al corso
     * @param docente rappresenta il nuovo nome del docente del corso
     * @param descrizione rappresenta la nuova descrizione del corso
     * @param link rappresenta il nuovo link del corso
     */
    public void modificaCorso(Corso corso, String nome, String docente, String descrizione, String link) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nome", nome);
        contentValues.put("docente", docente);
        contentValues.put("descrizione", descrizione);
        contentValues.put("link", link);

        db.update("corsi", contentValues, "codice=?", new String[]{corso.getCodice()});
    }

    /**
     * Metodo che permette di cancellare un corso dalla tabaella 'corsi' all'interno del database
     * @param corso rappresenta il corso che si vuole eliminare
     */
    public void cancellaCorso(Corso corso) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete("corsi",  "codice = ?", new String[]{corso.getCodice()});
    }



}
