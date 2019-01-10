package entità;

import java.util.ArrayList;
import java.util.HashMap;

public class Questionario {
    private String codice;
    private ArrayList<String> domande;
    private HashMap<String, ArrayList<String>> risposte;

    public Questionario(ArrayList<String> domande, HashMap<String, ArrayList<String>>risposte) {
        this.domande = domande;
        this.risposte = risposte;
    }
    public Questionario() {

    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public ArrayList<String> getDomande() {
        return domande;
    }

    public void setDomande(ArrayList<String> domande) {
        this.domande = domande;
    }

    public void setDomande(String domanda) {
        this.domande.add(domanda);
    }

    public HashMap<String, ArrayList<String>> getRisposte() {
        return risposte;
    }

    public void setRisposte(HashMap<String, ArrayList<String>> risposte) {
        this.risposte = risposte;
    }

    public void setRisposte(String domanda, String risposta1, String risposta2, String risposta3) {
        ArrayList<String> listaRisposte = new ArrayList<>();
        listaRisposte.add(risposta1);
        listaRisposte.add(risposta2);
        listaRisposte.add(risposta3);
        risposte.put(domanda, listaRisposte);
    }

    public void deleteQuestionario() {
        this.codice = null;
        this.domande = null;
        this.risposte = null;
    }


}
