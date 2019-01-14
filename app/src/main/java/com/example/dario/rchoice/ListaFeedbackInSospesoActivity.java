package com.example.dario.rchoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import entity.Feedback;
import facade.GestoreRightChoice;

import java.util.ArrayList;

import utility.CustomAdapterFeedback;

public class ListaFeedbackInSospesoActivity extends AppCompatActivity {
  private ListView listView;
  private GestoreRightChoice gestoreRightChoice;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lista_feedback_in_sospeso);

    listView = findViewById(R.id.listaFeedbackInSospesoListView);

    gestoreRightChoice = new GestoreRightChoice(getApplicationContext());

    ArrayList<Feedback> listaFeedback = gestoreRightChoice.listaFeedback();
    ArrayList<Feedback> listaFeedbackInSospeso = new ArrayList<>();

    for (int i = 0; i < listaFeedback.size(); i++) {
      if (listaFeedback.get(i).getStato() == 0) {
        listaFeedbackInSospeso.add(listaFeedback.get(i));
      }
    }

    CustomAdapterFeedback customAdapterFeedback = new CustomAdapterFeedback(getApplicationContext(),
            R.layout.layout_feedback, listaFeedbackInSospeso);
    listView.setAdapter(customAdapterFeedback);


    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent  = new Intent(getApplicationContext(), FeedbackInSospesoActivity.class);
            intent.putExtra("posizione", position);
            startActivity(intent);
            finish();
        }
    });
  }
}
