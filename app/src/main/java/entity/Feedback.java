package entity;

public class Feedback {
  private String codiceCorso;
  private String titolo;
  private String descrizione;
  private int stato;

  /**
   * Costruttore 1 della classe.
   */
  public Feedback() {

  }

  /**
   * Costruttore 2 della classe.
   * @param codiceCorso rappresenta il codice del corso
   * @param titolo rappresenta il titolo del corso
   * @param descrizione rappresenta la descrizione del corso
   * @param stato rappresenta lo stato del corso
   */
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
