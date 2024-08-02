package gianlucamessina.entities;

public class Libro extends Documento {
    //ATTRIBUTI
    private String autore;
    private String genere;

    //COSTRUTTORE
    public Libro(long isbn, String titolo, int annoPubblicazione, int numPagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numPagine);
        this.autore = autore;
        this.genere = genere;
    }

    //METODI
    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }
}