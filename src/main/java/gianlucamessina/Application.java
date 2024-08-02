package gianlucamessina;

import gianlucamessina.entities.Documento;
import gianlucamessina.entities.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
        archivio.removeIf(documento -> Objects.equals(documento.getIsbn(), isbn));
    }

    public Optional<Documento> ricercaPerIsbn(String isbn) {
        return archivio.stream().filter(documento -> Objects.equals(documento.getIsbn(), isbn)).findFirst();
    }

    public List<Documento> ricercaPerAnnoPubblicazione(int anno) {
        return archivio.stream().filter(documento -> documento.getAnnoPubblicazione() == anno).collect(Collectors.toList());
    }

    public List<Libro> ricercaPerAutore(String autore) {
        return archivio.stream().filter(documento -> documento instanceof Libro && Objects.equals(((Libro) documento).getAutore(), autore)).map(documento -> (Libro) documento).collect(Collectors.toList());
    }
}
