package facade;

import android.content.Context;

import java.util.ArrayList;

import entità.Admin;
import entità.Corso;
import entità.Feedback;
import entità.Studente;
import gestori.GestioneAdmin;
import gestori.GestioneCorso;
import gestori.GestioneFeedback;
import gestori.GestioneStudente;
import interfacce.InterfacciaRightChoice;

public class GestoreRightChoice implements InterfacciaRightChoice {
    private GestioneCorso gestioneCorso;
    private GestioneFeedback gestioneFeedback;
    private GestioneStudente gestioneStudente;
    private GestioneAdmin gestioneAdmin;

    public GestoreRightChoice(Context context) {
        gestioneFeedback = new GestioneFeedback(context);
        gestioneCorso = new GestioneCorso(context);
        gestioneStudente = new GestioneStudente(context);
        gestioneAdmin = new GestioneAdmin(context);
    }

    @Override
    public void inserisciCorso(Corso corso) {
        gestioneCorso.inserisciCorso(corso);
    }

    @Override
    public ArrayList<Corso> listaCorsi() {
        return gestioneCorso.listaCorsi();
    }

    @Override
    public ArrayList<String> getNomeCorsi() {
        return gestioneCorso.getNomeCorsi();
    }

    @Override
    public boolean verificaCodiceCorso(Corso corso) {
        return gestioneCorso.verificaCodiceCorso(corso);
    }

    @Override
    public void modificaCorso(Corso corso, String nome, String docente, String descrizione, String link) {
        gestioneCorso.modificaCorso(corso, nome, docente, descrizione, link);
    }

    @Override
    public void cancellaCorso(Corso corso) {
        gestioneCorso.cancellaCorso(corso);
    }





    @Override
    public void inserisciFeedback(Feedback feedback) {
        gestioneFeedback.inserisciFeedback(feedback);
    }

    @Override
    public ArrayList<Feedback> listaFeedback() {
        return gestioneFeedback.listaFeedback();
    }

    @Override
    public void cancellaFeedback(Feedback feedback) {
        gestioneFeedback.cancellaFeedback(feedback);
    }

    @Override
    public void setStatoFeedback(Feedback feedback) {
        gestioneFeedback.setStatoFeedback(feedback);
    }

    @Override
    public void inserisciStudente(Studente studente) {
        gestioneStudente.inserisciStudente(studente);
    }

    @Override
    public ArrayList<Studente> listaStudenti(Studente studente) {
        return gestioneStudente.listaStudenti();
    }

    @Override
    public boolean verificaEsistenzaStudenti(String username, String password) {
        return  gestioneStudente.verificaEsistenzaStudenti(username, password);
    }

    @Override
    public boolean verificaUsernameStudente(Studente s) {
        return gestioneStudente.verificaUsernameStudente(s);
    }

    @Override
    public boolean verificaMatricolaStudente(Studente s) {
        return gestioneStudente.verificaMatricolaStudente(s);
    }

    @Override
    public void inserisciAdmin(Admin admin) {
        gestioneAdmin.inserisciAdmin(admin);
    }

    @Override
    public Admin getAdmin() {
        return gestioneAdmin.getAdmin();
    }

    @Override
    public boolean loginAdmin(String username, String password) {
        return  gestioneAdmin.loginAdmin(username, password);
    }

    @Override
    public void convalidaFeedback(Feedback feedback) {
        gestioneAdmin.convalidaFeedback(feedback);
    }

    @Override
    public boolean verificaUsernameAdmin(String username) {
        return  gestioneAdmin.verificaUsernameAdmin(username);
    }
}
