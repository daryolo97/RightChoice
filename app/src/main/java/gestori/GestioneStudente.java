package gestori;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import database.DatabaseHelper;
import entità.Studente;
import interfacce.InterfacciaStudente;

public class GestioneStudente implements InterfacciaStudente {
    private SQLiteDatabase database;
    private Context context;
    private DatabaseHelper dbHelper;

    public GestioneStudente(Context ctx) {
        context = ctx;
        dbHelper = new DatabaseHelper(context);
    }


    @Override
    public long inserisciStudente(Studente studente) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("matricola", studente.getMatricola());
        values.put("username", studente.getUsername());
        values.put("password", studente.getPassword());
        values.put("nome", studente.getNome());
        values.put("cognome", studente.getCognome());

        long studente_id = db.insert("studenti", null, values);

        return studente_id;
    }

    @Override
    public ArrayList<Studente> getAllStudenti() {
        ArrayList<Studente> listaStudenti = new ArrayList<>();
        String query = "SELECT * FROM studenti";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do{
                Studente studente = new Studente();
                studente.setMatricola(c.getInt(c.getColumnIndex("matricola")));
                studente.setUsername(c.getString(c.getColumnIndex("username")));
                studente.setPassword(c.getString(c.getColumnIndex("password")));
                studente.setNome((c.getString(c.getColumnIndex("nome"))));
                studente.setCognome(c.getString(c.getColumnIndex("cognome")));

                listaStudenti.add(studente);
            }while(c.moveToNext());
        }

        return listaStudenti;
    }

    public boolean verificaEsistenzaStudenti(String username, String password) {
        ArrayList<Studente> listaStudenti = this.getAllStudenti();

        for(int i=0; i<listaStudenti.size(); i++) {
            if (listaStudenti.get(i).getUsername().equals(username) && listaStudenti.get(i).getPassword().equals(password))
                return true;
        }

        return false;
    }

    public boolean verificaUsername(Studente s) {
        ArrayList<Studente> listaStudenti = this.getAllStudenti();
        for(int i=0; i<listaStudenti.size(); i++) {
            if(s.getUsername().equals(listaStudenti.get(i).getUsername()))
                return false;
        }

        return true;
    }

    public boolean verificaMatricola(Studente s) {
        database = dbHelper.getReadableDatabase();
        ArrayList<Studente> listaStudenti = this.getAllStudenti();
        for(int i=0; i<listaStudenti.size(); i++) {
            if (s.getMatricola() == listaStudenti.get(i).getMatricola()) {
                return false;
            }
        }

        closeDB();
        return true;
    }

    public void closeDB() {
        dbHelper.closeDB();
    }
}
