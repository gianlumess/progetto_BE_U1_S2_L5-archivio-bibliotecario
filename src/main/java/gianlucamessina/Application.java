package gianlucamessina;

import gianlucamessina.entities.Documento;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Documento> archivio;

    public Application() {
        this.archivio = new ArrayList<>();
    }

    public static void main(String[] args) {

    }

    //METODI
    public void aggiungiElemento(Documento documento) {
        archivio.add(documento);
    }

    public void rimuoviElementoDatoIsbn(String isbn) {
        archivio.removeIf(documento -> documento.getIsbn() == isbn);
    }
}
