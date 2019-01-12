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

    public void inserisciAdmin(Admin admin) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("username", admin.getUsername());
        values.put("password", admin.getPassword());

        db.insert("admin", null, values);
    }


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

    public boolean loginAdmin(String username, String password) {
        Admin admin = getAdmin();
        if(admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public void convalidaFeedback(Feedback feedback) {
        feedback.setStato(1);
    }

    public boolean verificaUsernameAdmin(String username) {
        Admin admin = getAdmin();
        if (admin.getUsername().equals(username)) {
            return false;
        }
        return true;
    }




}
