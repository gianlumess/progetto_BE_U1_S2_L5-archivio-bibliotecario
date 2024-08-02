package gianlucamessina.entities;

public class Documento {
    //ATTRIBUTI
    protected String isbn;
    protected String titolo;
    protected int annoPubblicazione;
    protected int numPagine;

    //COSTRUTTORE
    public Documento(String isbn, String titolo, int annoPubblicazione, int numPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numPagine = numPagine;
    }

    //METODI
    public String getIsbn() {
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

    @Override
    public String toString() {
        return "Documento{" +
                "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numPagine=" + numPagine +
                '}';
    }
}

