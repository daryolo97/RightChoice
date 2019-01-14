package gestori;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import database.DatabaseHelper;
import entità.Admin;
import entità.Feedback;

public class GestioneAdmin {
    private SQLiteDatabase database;
    private Context context;
    private DatabaseHelper dbHelper;

    public GestioneAdmin(Context ctx) {
        context = ctx;
        dbHelper = new DatabaseHelper(context);
    }

    /**
     * Metodo che permette di inserire un admin all'interno della tabella 'Admin' all'interno del database
     * @param admin rappresenta l'admin da inserire nel database
     */
    public void inserisciAdmin(Admin admin) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("username", admin.getUsername());
        values.put("password", admin.getPassword());

        db.insert("admin", null, values);
    }

    /**
     * Metodo che permette di istanziare l'Admin presente nella tabella 'admin' all'interno del database
     * @return un oggetto Admin che rappresenta l'admin del database
     */
    public Admin getAdmin() {
        String query = "SELECT * FROM admin";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);


        if(c!=null) {
            c.moveToFirst();
        }

        Admin admin = new Admin();
        admin.setUsername(c.getString(c.getColumnIndex("username")));
        admin.setPassword(c.getString(c.getColumnIndex("password")));

        return admin;
    }

    /**
     * Metodo che permette di accedere al sistema come amministratore
     * @param username rappresenta l'username ricavato dal campo 'username' del form di login
     * @param password rappresenta la password ricavato dal campo 'password' del form di login
     * @return booleano che indica se sta accedendo l'amministratore(true) o un normale utente(false)
     */
    public boolean loginAdmin(String username, String password) {
        Admin admin = getAdmin();
        if(admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    /**
     * Metodo che permette di convalidare un feedback per inserirlo nella lista dei feedback del corso desiderato
     * @param feedback rappresenta il feedback da convalidare
     */
    public void convalidaFeedback(Feedback feedback) {
        feedback.setStato(1);
    }

    /**
     * Metodo che permette di verificare se un nuovo utente che si sta registrando, sta utilizzando l'username dell'amministratore
     * @param username Stringa che rappresenta l'username da verificare
     * @return booleano che indica se l'username è uguale a quella dell'amministratore(false) o se è diversa(true)
     */
    public boolean verificaUsernameAdmin(String username) {
        Admin admin = getAdmin();
        if (admin.getUsername().equals(username)) {
            return false;
        }
        return true;
    }




}
