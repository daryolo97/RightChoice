package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Questionario {
  private String codice;
  private ArrayList<String> domande;
  private HashMap<String, ArrayList<String>> risposte;

  public Questionario(ArrayList<String> domande, HashMap<String, ArrayList<String>> risposte) {
    this.domande = domande;
    this.risposte = risposte;
  }

  public ArrayList<String> getDomande() {
    return domande;
  }

  public void setDomande(ArrayList<String> domande) {
    this.domande = domande;
  }

  public HashMap<String, ArrayList<String>> getRisposte() {
    return risposte;
  }
}
