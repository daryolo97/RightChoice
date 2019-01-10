package entità;

public class Corso {

    private String codice, nome, docente, descrizione, link;

    public Corso() {

    }

    public Corso(String codice, String nome, String docente, String descrizione, String link) {
        this.codice = codice;
        this.nome = nome;
        this.docente = docente;
        this.descrizione = descrizione;
        this.link = link;
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
