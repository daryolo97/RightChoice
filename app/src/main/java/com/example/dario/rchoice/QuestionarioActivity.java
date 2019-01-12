package com.example.dario.rchoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import entità.Questionario;

public class QuestionarioActivity extends AppCompatActivity {

    private TextView TVdomanda1, TVdomanda2, TVdomanda3, TVdomanda4, TVdomanda5, TVdomanda6, TVdomanda7;
    private RadioButton risp1Domanda1Button;
    private RadioButton risp2Domanda1Button;
    private RadioButton risp1Domanda2Button;
    private RadioButton risp2Domanda2Button;
    private RadioButton risp1Domanda3Button;
    private RadioButton risp2Domanda3Button;
    private RadioButton risp1Domanda4Button;
    private RadioButton risp2Domanda4Button;
    private RadioButton risp1Domanda5Button;
    private RadioButton risp2Domanda5Button;
    private RadioButton risp1Domanda6Button;
    private RadioButton risp2Domanda6Button;
    private RadioButton risp1Domanda7Button;
    private RadioButton risp2Domanda7Button;

    private Questionario questionario;

    private RadioGroup radioGroup1,radioGroup2,radioGroup3,radioGroup4,radioGroup5,radioGroup6,radioGroup7 ;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7;
    private ArrayList<String> listaCorsiScelti;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionario);



        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);
        radioGroup3 = findViewById(R.id.radioGroup3);
        radioGroup4 = findViewById(R.id.radioGroup4);
        radioGroup5 = findViewById(R.id.radioGroup5);
        radioGroup6 = findViewById(R.id.radioGroup6);
        radioGroup7 = findViewById(R.id.radioGroup7);


        listaCorsiScelti = new ArrayList<>();

        ArrayList<String> domande = new ArrayList<>();
        domande.add("Quanto sei affine con la matematica?");
        domande.add("Sei pratico nel disegnare? Hai molta fantasia?");
        domande.add("Quanto sei appassionato/interessato alle app sul tuo smartphone?");
        domande.add("Quanto sei attratto dai robot che dialogano come un essere umano?");
        domande.add("Quanto sei attento alla sicurezza dei tuoi dati sul web?");
        domande.add("Quanto ti piacerebbe avere un'esperienza in un'azienda di informatica");
        domande.add("Ti piacerebbe di più lavorare sull'aspetto visivo(esterno) o su quello non visivo(interno) di un applicativo software)");




        HashMap<String, ArrayList<String>> listaRisposte = new HashMap<>();

        ArrayList<String> risposte1 = new ArrayList<String>();
        risposte1.add("Poco");
        risposte1.add("Molto");

        listaRisposte.put(domande.get(0), risposte1);

        //Risposte domanda 2
        ArrayList<String> risposte2 = new ArrayList<String>();
        risposte2.add("Si, certamente");
        risposte2.add("No, per niente");

        listaRisposte.put(domande.get(1), risposte2);


        //risposte domanda 3
        ArrayList<String> risposte3 = new ArrayList<String>();
        risposte3.add("Molto, mi interessano");
        risposte3.add("Poco, non mi interessano");

        listaRisposte.put(domande.get(2), risposte3);

        //risposte domanda 4
        ArrayList<String> risposte4 = new ArrayList<String>();
        risposte4.add("Poco");
        risposte4.add("Molto, sono interessato");

        listaRisposte.put(domande.get(3), risposte4);

        //risposte domanda 5
        ArrayList<String> risposte5 = new ArrayList<String>();
        risposte5.add("Poco");
        risposte5.add("Molto");

        listaRisposte.put(domande.get(4), risposte5);

        //risposte domanda 6
        ArrayList<String> risposte6 = new ArrayList<String>();
        risposte6.add("Molto, mi piacerebbe");
        risposte6.add("Poco, non sono pronto");

        listaRisposte.put(domande.get(5), risposte6);

        //risposte domanda 7
        ArrayList<String> risposte7 = new ArrayList<String>();
        risposte7.add("Aspetto visivo (front-end)");
        risposte7.add("Aspetto non visivo, (back-end)");

        listaRisposte.put(domande.get(6), risposte7);

        TVdomanda1 = findViewById(R.id.domanda1);
        TVdomanda2 = findViewById(R.id.domanda2);
        TVdomanda3 = findViewById(R.id.domanda3);
        TVdomanda4 = findViewById(R.id.domanda4);
        TVdomanda5 = findViewById(R.id.domanda5);
        TVdomanda6 = findViewById(R.id.domanda6);
        TVdomanda7 = findViewById(R.id.domanda7);

        risp1Domanda1Button = findViewById(R.id.risp1Domanda1);
        risp2Domanda1Button = findViewById(R.id.risp2Domanda1);

        risp1Domanda2Button = findViewById(R.id.risp1Domanda2);
        risp2Domanda2Button = findViewById(R.id.risp2Domanda2);

        risp1Domanda3Button = findViewById(R.id.risp1Domanda3);
        risp2Domanda3Button = findViewById(R.id.risp2Domanda3);

        risp1Domanda4Button = findViewById(R.id.risp1Domanda4);
        risp2Domanda4Button = findViewById(R.id.risp2Domanda4);

        risp1Domanda5Button = findViewById(R.id.risp1Domanda5);
        risp2Domanda5Button = findViewById(R.id.risp2Domanda5);

        risp1Domanda6Button = findViewById(R.id.risp1Domanda6);
        risp2Domanda6Button = findViewById(R.id.risp2Domanda6);


        risp1Domanda7Button = findViewById(R.id.risp1Domanda7);
        risp2Domanda7Button = findViewById(R.id.risp2Domanda7);

        questionario = new Questionario(domande, listaRisposte);


        //inserimento domanda1 e risposte
        TVdomanda1.setText(questionario.getDomande().get(0));
        risp1Domanda1Button.setText(questionario.getRisposte().get(questionario.getDomande().get(0)).get(0));
        risp2Domanda1Button.setText(questionario.getRisposte().get(questionario.getDomande().get(0)).get(1));

        //inserimento domanda2 e risposte
        TVdomanda2.setText(questionario.getDomande().get(1));
        risp1Domanda2Button.setText(questionario.getRisposte().get(questionario.getDomande().get(1)).get(0));
        risp2Domanda2Button.setText(questionario.getRisposte().get(questionario.getDomande().get(1)).get(1));


        //inserimento domanda3 e risposte
        TVdomanda3.setText(questionario.getDomande().get(2));
        risp1Domanda3Button.setText(questionario.getRisposte().get(questionario.getDomande().get(2)).get(0));
        risp2Domanda3Button.setText(questionario.getRisposte().get(questionario.getDomande().get(2)).get(1));

        //inserimento domanda4 e risposte
        TVdomanda4.setText(questionario.getDomande().get(3));
        risp1Domanda4Button.setText(questionario.getRisposte().get(questionario.getDomande().get(3)).get(0));
        risp2Domanda4Button.setText(questionario.getRisposte().get(questionario.getDomande().get(3)).get(1));

        //inserimento domanda5 e risposte
        TVdomanda5.setText(questionario.getDomande().get(4));
        risp1Domanda5Button.setText(questionario.getRisposte().get(questionario.getDomande().get(4)).get(0));
        risp2Domanda5Button.setText(questionario.getRisposte().get(questionario.getDomande().get(4)).get(1));


        //inserimento domanda6 e risposte
        TVdomanda6.setText(questionario.getDomande().get(5));
        risp1Domanda6Button.setText(questionario.getRisposte().get(questionario.getDomande().get(5)).get(0));
        risp2Domanda6Button.setText(questionario.getRisposte().get(questionario.getDomande().get(5)).get(1));


        //inserimento domanda7 e risposte
        TVdomanda7.setText(questionario.getDomande().get(6));
        risp1Domanda7Button.setText(questionario.getRisposte().get(questionario.getDomande().get(6)).get(0));
        risp2Domanda7Button.setText(questionario.getRisposte().get(questionario.getDomande().get(6)).get(1));




    }

    public RadioButton checkButton(RadioGroup radioGroup) {
        int radioID = radioGroup.getCheckedRadioButtonId();

        RadioButton radioButton=findViewById(radioID);

        return radioButton;
    }

    public void ottieniRisultatoPremuto(View v) {


        radioButton1 = checkButton(radioGroup1);
        radioButton2 = checkButton(radioGroup2);
        radioButton3 = checkButton(radioGroup3);
        radioButton4 = checkButton(radioGroup4);
        radioButton5 = checkButton(radioGroup5);
        radioButton6 = checkButton(radioGroup6);
        radioButton7 = checkButton(radioGroup7);

        if(radioButton1.getText().toString().equals("Poco")) {
            listaCorsiScelti.add("Calcolo Scientifico");
            listaCorsiScelti.add("Fisica");
        } else {
            listaCorsiScelti.add("Calcolo Scientifico");
        }

        if(radioButton2.getText().toString().equals("Si, certamente")) {
            listaCorsiScelti.add("Grafica ed Interattività");
        }

        if(radioButton3.getText().toString().equals("Molto, mi interessano")) {
            listaCorsiScelti.add("Mobile Computing");
        }

        if(radioButton4.getText().toString().equals("Molto, sono interessato")) {
            listaCorsiScelti.add("Fondamenti di Intelligenza Artificiale");
        }

        if(radioButton5.getText().toString().equals("Molto")) {
            listaCorsiScelti.add("Sicurezza");
        }

        if(radioButton6.getText().toString().equals("Molto, mi piacerebbe")){
            listaCorsiScelti.add("Tirocinio Esterno 1");
        }

        if(radioButton7.getText().toString().equals("Aspetto non visivo, (back-end)")){
            listaCorsiScelti.add("Simulazione");
            listaCorsiScelti.add("Programmazione Avanzata");
        }

        if(verificaCampi(radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7)) {
            Intent intent = new Intent(getApplicationContext(), RisultatoQuestionarioActivity.class);
            intent.putExtra("array", listaCorsiScelti);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Selezionare una risposta per tutte le domande", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean verificaCampi(RadioButton r1, RadioButton r2, RadioButton r3, RadioButton r4, RadioButton r5, RadioButton r6, RadioButton r7) {

        if(r1==null){
            return false;
        }

        else if(r2==null){
            return false;
        }
        else if(r3==null){
            return false;
        }
        else if(r4==null){
            return false;
        }
        else if(r5==null){
            return false;
        }
        else if(r6==null){
            return false;
        }
        else if(r7==null){
            return false;
        }

        return true;

    }






}
