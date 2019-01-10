package entità;

public class Feedback {
    private String codiceCorso, titolo, descrizione;
    private int stato;

    public Feedback() {

    }

    public Feedback(String codiceCorso, String titolo, String descrizione, int stato) {
        this.codiceCorso = codiceCorso;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.stato = stato;
    }


    public String getCodiceCorso() {
        return codiceCorso;
    }

    public void setCodiceCorso(String codiceCorso) {
        this.codiceCorso = codiceCorso;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getStato() {
        return stato;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }
}
