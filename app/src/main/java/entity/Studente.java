package entity;

public class Studente {
  private int matricola;
  private String username;
  private String password;
  private String nome;
  private String cognome;

  /**
   * Costruttore 1 della classe.
   */
  public Studente() {

  }

  /**
   * Costruttore 2 della classe.
   * @param matricola rappresenta la matricola dello studente
   * @param username rappresenta la username dello studente
   * @param password rappresenta la password dello studente
   * @param nome rappresenta la nome dello studente
   * @param cognome rappresenta la cognome dello studente
   */
  public Studente(int matricola, String username, String password, String nome, String cognome) {
    this.matricola = matricola;
    this.username = username;
    this.password = password;
    this.nome = nome;
    this.cognome = cognome;
  }

  public int getMatricola() {
    return matricola;
  }

  public void setMatricola(int matricola) {
    this.matricola = matricola;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }
}
