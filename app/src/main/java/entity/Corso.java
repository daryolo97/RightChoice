package entity;

public class Corso {
  private String codice;
  private String nome;
  private String docente;
  private String descrizione;
  private String link;

  /**
   * Costruttore 1 della classe.
   * @param codice rappresenta il codice del corso
   * @param nome rappresenta il nome del corso
   * @param docente rappresenta il docente del corso
   * @param descrizione rappresenta il descrizione del corso
   * @param link rappresenta il link del corso
   */
  public Corso(String codice, String nome, String docente, String descrizione, String link) {
    this.codice = codice;
    this.nome = nome;
    this.docente = docente;
    this.descrizione = descrizione;
    this.link = link;
  }

  /**
   * Costruttore 2 della classe.
   */
  public Corso() {

  }

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDocente() {
    return docente;
  }

  public void setDocente(String docente) {
    this.docente = docente;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }
}
