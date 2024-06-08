package co.elkinmadrid.literalurachallenge;

import co.elkinmadrid.literalurachallenge.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiterAluraChallengeApplication implements CommandLineRunner {

    private Scanner scanner = new Scanner(System.in);

    @Autowired
    private BooksService service;

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraChallengeApplication.class, args);
    }

    @Override
    public void run(String... args) {

        int op = -1;
        while (op != 0) {
            String menu = """
                    Elija una opción:
                                        
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos de un determinado año
                    5 - Listar libros por idioma
                    6 - Salir
                                        
                    """;

            System.out.println(menu);
            op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Escriba el libro que desea buscar: ");
                    String libro = scanner.nextLine();
                    service.findBooksByTitle(libro);
                    break;
                case 2:
                    service.getAllBooks();
                    break;
                case 3:
                    service.getAllAuthors();

                    break;
                case 4:
                    System.out.println("Ingrese el año vivo del autor que sea buscar: ");
                    int anio = scanner.nextInt();
                    service.getAuthorsByYear(anio);
                    break;
                case 5:
                    System.out.println("""
                            Escoja el idioma que desea buscar:
                            es - español
                            en - ingles
                            fr - frances
                            pt - portugues
                            """);
                    String optionLanguages = scanner.nextLine();
                    service.findBooksByLanguage(optionLanguages);

                    break;
                case 6:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");

            }
        }

    }
}
