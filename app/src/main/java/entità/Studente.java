package entità;

public class Studente {
    private int matricola;
    private String username, password, nome, cognome;

    public Studente() {

    }

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
