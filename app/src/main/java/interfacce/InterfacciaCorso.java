package interfacce;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import entità.Corso;

public interface InterfacciaCorso {
    long inserisciCorsi(Corso corso);
    ArrayList<Corso> getAllCorsi();
    ArrayList<String> getNomeCorsi();
    boolean verificaCodiceCorso(Corso corso);
    void updateCorso(Corso corso, String nome, String docente, String descrizione, String link);
    void deleteCorso(Corso corso);
}



