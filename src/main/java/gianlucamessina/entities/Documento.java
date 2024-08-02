package gianlucamessina.entities;

public class Documento {
    //ATTRIBUTI
    protected long isbn;
    protected String titolo;
    protected int annoPubblicazione;
    protected int numPagine;

    //COSTRUTTORE
    public Documento(long isbn, String titolo, int annoPubblicazione, int numPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numPagine = numPagine;
    }

    //METODI
    public long getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumPagine() {
        return numPagine;
    }
}

