package interfacce;

import java.util.ArrayList;

import entità.Admin;
import entità.Corso;
import entità.Feedback;
import entità.Studente;

public interface InterfacciaRightChoice {
    void inserisciCorso(Corso corso);
    ArrayList<Corso> listaCorsi();
    ArrayList<String> getNomeCorsi();
    boolean verificaCodiceCorso(Corso corso);
    void modificaCorso(Corso corso, String nome, String docente, String descrizione, String link);
    void cancellaCorso(Corso corso);
    void inserisciFeedback(Feedback feedback);
    ArrayList<Feedback> listaFeedback();
    void cancellaFeedback(Feedback feedback);
    void setStatoFeedback(Feedback feedback);
    void inserisciStudente(Studente studente);
    ArrayList<Studente> listaStudenti();
    boolean verificaEsistenzaStudenti(String username, String password);
    boolean verificaUsernameStudente(Studente s);
    boolean verificaMatricolaStudente(Studente s);
    void inserisciAdmin(Admin admin);
    Admin getAdmin();
    boolean loginAdmin(String username, String password);
    void convalidaFeedback(Feedback feedback);
    boolean verificaUsernameAdmin(String username);
}
