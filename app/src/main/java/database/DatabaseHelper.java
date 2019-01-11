package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.logging.XMLFormatter;

import entità.Corso;
import entità.Studente;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "RIGHTCHOICE_DB";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_STUDENTI = "CREATE TABLE studenti(matricola INTEGER PRIMARY KEY, username TEXT NOT NULL, password TEXT NOT NULL, nome TEXT, cognome TEXT)";
    private static final String CREATE_TABLE_CORSI = "CREATE TABLE corsi(codice TEXT PRIMARY KEY, nome TEXT NOT NULL, docente TEXT NOT NULL, descrizione TEXT, link TEXT)";
    private static final String CREATE_TABLE_FEEDBACK = "CREATE TABLE feedback(id INTEGER PRIMARY KEY AUTOINCREMENT, codiceCorso TEXT NOT NULL, titolo TEXT NOT NULL, descrizione TEXT NOT NULL, stato INTEGER NOT NULL)";
    private static final String CREATE_TABLE_ADMIN = "CREATE TABLE admin(username TEXT, password TEXT, PRIMARY KEY (username, password))";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTI);
        db.execSQL(CREATE_TABLE_CORSI);
        db.execSQL(CREATE_TABLE_FEEDBACK);
        db.execSQL(CREATE_TABLE_ADMIN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS studenti");
        db.execSQL("DROP TABLE IF EXISTS corsi");
        db.execSQL("DROP TABLE IF EXISTS feedback");
        db.execSQL("DROP TABLE IF EXISTS admin");

        onCreate(db);
    }


        //Closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }







}
