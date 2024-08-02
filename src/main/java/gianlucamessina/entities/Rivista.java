package gianlucamessina.entities;

import gianlucamessina.enums.Periodicita;

public class Rivista extends Documento {
    //ATTRIBUTI
    private Periodicita periodicita;

    //COSTRUTTORE
    public Rivista(long isbn, String titolo, int annoPubblicazione, int numPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numPagine);
        this.periodicita = periodicita;
    }

    //METODI
    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
