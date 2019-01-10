package interfacce;

import java.util.ArrayList;

import entità.Studente;

public interface InterfacciaStudente {
    long inserisciStudente(Studente studente);
    ArrayList<Studente> getAllStudenti();
}
