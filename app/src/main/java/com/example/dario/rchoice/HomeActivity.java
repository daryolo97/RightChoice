package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import gestori.GestioneCorso;
import gestori.GestioneFeedback;
import entità.Corso;
import entità.Questionario;

public class HomeActivity extends Activity {
    private GestioneCorso gestioneCorso;
    private GestioneFeedback gestioneFeedback;
    private TextView TVdomanda1, TVdomanda2, TVdomanda3, TVdomanda4, TVdomanda5;
    private RadioButton risp1Domanda1Button;
    private RadioButton risp2Domanda1Button;
    private RadioButton risp3Domanda1Button;
    private RadioButton risp1Domanda2Button;
    private RadioButton risp2Domanda2Button;
    private RadioButton risp3Domanda2Button;
    private RadioButton risp1Domanda3Button;
    private RadioButton risp2Domanda3Button;
    private RadioButton risp3Domanda3Button;
    private RadioButton risp1Domanda4Button;
    private RadioButton risp2Domanda4Button;
    private RadioButton risp3Domanda4Button;
    private RadioButton risp1Domanda5Button;
    private RadioButton risp2Domanda5Button;
    private RadioButton risp3Domanda5Button;

    private Questionario questionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gestioneCorso = new GestioneCorso(getApplicationContext());
        Corso corso1 = new Corso("CO_01", "Programmazione Avanzata", "Annalisa De Bonis", "Questo corso mira ad impartire allo studente, conoscenza e capacità di applicazione dei principali modelli e strumenti per progettare e implementare programmi complessi", "www.di-srv.unisa.it/professori/debonis/");
        Corso corso2 = new Corso("CO_02", "Mobile Computing", "Roberto De Prisco", "Il corso si prefigge l’obiettivo di fornire allo studente le conoscenze necessarie per poter sviluppare programmi per dispositivi mobili e la capacita' di applicare tale conoscenza: progettazione e sviluppo di programmi per dispositivi mobili, in particolare per smartphone Android.", "http://www.di-srv.unisa.it/~robdep/MP/");
        Corso corso3 = new Corso("CO_03", "Sicurezza", "Alfredo De Santis", "L'obiettivo di questo insegnamento è di introdurre agli studenti i fondamenti della sicurezza informatica, ovvero proteggere i dati da agenti esterni e dalle azioni di utenti non autorizzati", "https://corsi.unisa.it/informatica/didattica/insegnamenti?anno=2018&id=509869");
        Corso corso4 = new Corso("CO_04", "Interazione Uomo Macchina", "Giuliana Vitiello", "Il corso si propone di fornire nozioni fondamentali per la progettazione e valutazione di sistemi interattivi, con particolare attenzione anche per nuovi paradigmi e tecnologie avanzate quali quelle legate alla realtà virtuale ed aumentata.", "https://corsi.unisa.it/informatica/didattica/insegnamenti?anno=2018&id=507547");
        Corso corso5 = new Corso("CO_05", "Fisica", "Roberto De Luca", "L’insegnamento intende fornire, la conoscenza delle nozioni di base e delle applicazioni della meccanica classica e dell’elettromagnetismo. lo studente dovra’ saper risolvere semplici esercizi riguardanti problemi elementari di meccanica ed elettromagnetismo.", "https://corsi.unisa.it/informatica/didattica/insegnamenti?anno=2018&id=505290");
        Corso corso6 = new Corso("CO_06", "Grafica ed Interattività", "Andrea Francesco Abate", "Lo studente dovrà avere conoscenza di base e avanzata su: tecniche di computer grafica tridimensionale e di realtà virtuale, principali tecniche di modellazione, illuminazione e rendering, principali funzionalità dei motori 3d e unity, gli algoritmi ed i metodi computazionali su cui si basano molte delle applicazioni grafiche 3d interattive", "https://corsi.unisa.it/informatica/didattica/insegnamenti?anno=2018&id=509870");
        Corso corso7 = new Corso("CO_07", "Simulazione", "Amelia Giuseppina Nobile", "Questo corso mira a fornire: conoscenze di base necessarie alla descrizione probabilistica dei più semplici sistemi di servizio con uno o più servitori, ed analisi dei loro principali indici di prestazione e di affidabilità; modelli di simulazione, problematica della scelta del simulatore e della pianificazione di un esperimento di simulazione\n", "https://corsi.unisa.it/informatica/didattica/insegnamenti?anno=2018&id=507552");
        Corso corso8 = new Corso("CO_08", "Fondamenti di Intelligenza Artificiale", "Giuseppe Polese", "Lo studente acquisirà conoscenza di base su:\n" +
                "•agenti intelligenti, \n" +
                "•strategie di ricerca per la risoluzione di problemi, \n" +
                "•la rappresentazione della conoscenza ed inferenza, \n" +
                "•principali metodi di rappresentazione della conoscenza, con particolare riferimento a quelli basati sulla logica del primo ordine e relativi metodi di inferenza. \n" +
                "•rappresentazione di conoscenza incerta e metodi probabilistici di inferenza, con particolare riferimento alle reti bayesiane.\n" +
                "•tecniche di machine learning.", "https://corsi.unisa.it/informatica-magistrale/didattica/insegnamenti?anno=2016&id=511676");
        long corso1_id = gestioneCorso.inserisciCorsi(corso1);
        long corso2_id = gestioneCorso.inserisciCorsi(corso2);
        long corso3_id = gestioneCorso.inserisciCorsi(corso3);
        long corso4_id = gestioneCorso.inserisciCorsi(corso4);
        long corso5_id = gestioneCorso.inserisciCorsi(corso5);
        long corso6_id = gestioneCorso.inserisciCorsi(corso6);
        long corso7_id = gestioneCorso.inserisciCorsi(corso7);

/*

        gestioneFeedback = new GestioneFeedback(getApplicationContext());
        //istanza di feedback di esempio
        Feedback feedback1 = new Feedback("CO_01", "UUUUUU", "IFOISDJFOISJFIOJSDOIJFISODJFOISDJFIOS DJFPFIFVNDUIFNV DFVNIDFNVI DF", 1);
        Feedback feedback2 = new Feedback("CO_02", "UUUUUUCZX", "HHHHIFOISDJFOISJFIOJSDOIJFISODJFOISDJFIOS DJFPFIFVNDUIFNV DFVNIDFNVI DF", 1);
        Feedback feedback3 = new Feedback("CO_03", "UUUUUUSDCS", "IFFFFVVVVVFOISDJFOISJFIOJSDOIJFISODJFOISDJFIOS DJFPFIFVNDUIFNV DFVNIDFNVI DF", 1);
        Feedback feedback4 = new Feedback("CO_04", "UUUEFUUU", "SSSSIFOISDJSDFOISJFIOJSDOIJFISODJFOISDJFIOS DJFPFIFVNDUIFNV DFVNIDFNVI DF", 1);


        long feedback1_id = gestioneFeedback.inserisciFeedback(feedback1);
        long feedback2_id = gestioneFeedback.inserisciFeedback(feedback2);
        long feedback3_id = gestioneFeedback.inserisciFeedback(feedback3);
        long feedback4_id = gestioneFeedback.inserisciFeedback(feedback4);*/

    }

    public void listaCorsiPremuta(View v) {
        Intent intent = new Intent(getApplicationContext(), ListaCorsiActivity.class);
        startActivity(intent);
    }

    public void questionarioPremuto(View v) {
        Intent intent = new Intent(getApplicationContext(), QuestionarioActivity.class);
        startActivity(intent);
    }


}
