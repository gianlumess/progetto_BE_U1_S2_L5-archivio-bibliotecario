package gianlucamessina;

import gianlucamessina.entities.Documento;
import gianlucamessina.entities.Libro;
import gianlucamessina.entities.Rivista;
import gianlucamessina.enums.Periodicita;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    private List<Documento> archivio;

    public Application() {
        this.archivio = new ArrayList<>();
    }

    public static void main(String[] args) {
        Application archivio = new Application(); //creo la variabile archivio che è un arrayList di Documenti

        archivio.archivio.add(new Libro("tr46433", "cime tempestose", 1847, 300, "Emily Bronte", "romanzo"));
        archivio.archivio.add(new Libro("sd35356", "Harry Potter e la pietra filosofale", 1997, 350, "Rowling", "fantasy"));
        archivio.archivio.add(new Libro("gh42453", "Harry Potter e il calice di fuoco", 2000, 400, "Rowling", "fantasy"));

        Scanner scanner = new Scanner(System.in); //creo lo scanner per ottenere i dati dall'utente
        System.out.println("Benvenuto nell'archivio bibliotecario!!");
        while (true) {
            try {
                System.out.println("Scegli cosa fare:");
                System.out.println("1: Aggiungi un documento");
                System.out.println("2: Rimuovi un documento");
                System.out.println("3: Ricerca un documento per ISBN");
                System.out.println("4: Ricerca un documento per anno di pubblicazione");
                System.out.println("5: Ricerca un documento per Autore");
                System.out.println("6: Visualizza archivio presente nel disco");
                System.out.println("7: Esci dal programma");
                int sceltaUtente = Integer.parseInt(scanner.nextLine());

                switch (sceltaUtente) {
                    case 1:
                        System.out.println("Scegli che documento inserire: ");
                        System.out.println("1. Libro");
                        System.out.println("2. Rivista");

                        int tipoDocumento = Integer.parseInt(scanner.nextLine());

                        System.out.println("Inserisci codice ISBN: ");
                        String ibsn = scanner.nextLine();

                        System.out.println("Inserisci il titolo:");
                        String titolo = scanner.nextLine();

                        System.out.println("Inserisci l'anno di pubblicazione: ");
                        int annoPubblicazione = Integer.parseInt(scanner.nextLine());

                        System.out.println("Inserisci il numero di pagine: ");
                        int numPag = Integer.parseInt(scanner.nextLine());

                        if (tipoDocumento == 1) {
                            System.out.println("Inserisci l'autore: ");
                            String autore = scanner.nextLine();

                            System.out.println("Inserisci il genere: ");
                            String genere = scanner.nextLine();
                            //dopo aver ottenuto i dati creo un istanza di un Libro
                            Libro libro = new Libro(ibsn, titolo, annoPubblicazione, numPag, autore, genere);
                            //inserisco il libro creato nell'arrayList
                            archivio.aggiungiElemento(libro);
                        } else if (tipoDocumento == 2) {
                            System.out.println("Scegli la periodicità");
                            System.out.println("1. Settimanale");
                            System.out.println("2. Mensile");
                            System.out.println("3. Semestrale");

                            int selezionePeriodicita = Integer.parseInt(scanner.nextLine());

                            Periodicita periodicita = null;

                            switch (selezionePeriodicita) {
                                case 1:
                                    periodicita = Periodicita.SETTIMANALE;
                                    break;
                                case 2:
                                    periodicita = Periodicita.MENSILE;
                                    break;
                                case 3:
                                    periodicita = Periodicita.SEMESTRALE;
                                    break;
                                default:
                                    System.out.println("Inserimento non valido, riprova.");
                            }
                            //dopo aver ottenuto i dati faccio un istanza di una rivista
                            Rivista rivista = new Rivista(ibsn, titolo, annoPubblicazione, numPag, periodicita);
                            //inserisco la rivista nell'arrayList
                            archivio.aggiungiElemento(rivista);
                        }
                        break;
                    case 2:
                        System.out.println("Inserisci il codice ISBN del documento da rimuovere dalla lista dell'archivio: ");
                        String isbnDaRimuovere = scanner.nextLine();
                        archivio.rimuoviElementoDatoIsbn(isbnDaRimuovere);
                        break;
                    case 3:
                        System.out.println("Inserisci codice ISBN per cercare il documento: ");
                        String isbnDaCercare = scanner.nextLine();
                        Optional<Documento> documentoCercatoPerIsbn = archivio.ricercaPerIsbn(isbnDaCercare);
                        System.out.println(documentoCercatoPerIsbn.isPresent() ? documentoCercatoPerIsbn : "Documento non trovato");
                        break;
                    case 4:
                        System.out.println("Inserisci anno di pubblicazione per cercare i documenti: ");
                        int annoDaCercare = Integer.parseInt(scanner.nextLine());
                        List<Documento> risultatiDocumentiPerAnnoCercato = archivio.ricercaPerAnnoPubblicazione(annoDaCercare);
                        if (risultatiDocumentiPerAnnoCercato == null) {
                            System.out.println("Nessun documento trovato per la data selezionata");
                        } else {
                            risultatiDocumentiPerAnnoCercato.forEach(System.out::println);
                        }
                        break;
                    case 5:
                        System.out.println("Inserisci nome autore per cercare i documenti: ");
                        String autoreDaCercare = scanner.nextLine();
                        List<Libro> risultatiLibriPerAutore = archivio.ricercaPerAutore(autoreDaCercare);
                        if (risultatiLibriPerAutore == null) {
                            System.out.println("Nessun libro scritto dall'autore selezionato è stato trovato");
                        } else {
                            risultatiLibriPerAutore.forEach(System.out::println);
                        }
                        break;
                    case 6:

                        archivio.caricaDalDisco();
                    case 7:
                        scanner.close();
                        archivio.salvaSuDisco();
                        System.exit(0);
                    default:
                        System.out.println("Inserimento non valido, riprova!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido. " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Si è verificato un errore " + e.getMessage());
            }
        }


    }

    //METODI
    public void aggiungiElemento(Documento documento) {
        archivio.add(documento);
    }

    public void rimuoviElementoDatoIsbn(String isbn) {
        archivio.removeIf(documento -> Objects.equals(documento.getIsbn(), isbn));
    }

    public Optional<Documento> ricercaPerIsbn(String isbn) {
        return Optional.ofNullable(archivio.stream().filter(documento -> Objects.equals(documento.getIsbn(), isbn)).findFirst().orElse(null));
    }

    public List<Documento> ricercaPerAnnoPubblicazione(int anno) {
        return archivio.stream().filter(documento -> documento.getAnnoPubblicazione() == anno).collect(Collectors.toList());
    }

    public List<Libro> ricercaPerAutore(String autore) {
        return archivio.stream().filter(documento -> documento instanceof Libro && Objects.equals(((Libro) documento).getAutore(), autore)).map(documento -> (Libro) documento).collect(Collectors.toList());
    }

    public void salvaSuDisco() {
        File file = new File("src/archivio.txt");
        try {
            FileUtils.writeStringToFile(file, archivio.toString() + System.lineSeparator(), StandardCharsets.UTF_8, true);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void caricaDalDisco() {
        File archivioFile = FileUtils.getFile("src/archivio.txt");

        String content = null;
        try {
            content = FileUtils.readFileToString(archivioFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] contentAsArray = content.split(System.lineSeparator());
        System.out.println(Arrays.toString(contentAsArray));
    }
}
