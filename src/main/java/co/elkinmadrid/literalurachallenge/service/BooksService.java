package co.elkinmadrid.literalurachallenge.service;

import co.elkinmadrid.literalurachallenge.util.FetchAPI;
import co.elkinmadrid.literalurachallenge.model.AuthorEntity;
import co.elkinmadrid.literalurachallenge.model.Books;
import co.elkinmadrid.literalurachallenge.model.BooksEntity;
import co.elkinmadrid.literalurachallenge.model.ResponseApi;
import co.elkinmadrid.literalurachallenge.repository.AuthorRepository;
import co.elkinmadrid.literalurachallenge.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private static final FetchAPI FETCH_API = new FetchAPI();
    private static final String URL_BASE = "https://gutendex.com/books/";

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public void findBooksByTitle(String title) {
        ResponseApi response = FETCH_API.requestAPI(URL_BASE + "?search=" + title.replace(" ", "+"));
        if (response.books().isEmpty()) {
            System.out.println("Libro no encontrado");
            return;
        }
        Books booksAPI = response.books().get(0);
        booksRepository.findByTitle(booksAPI.title()).ifPresentOrElse((value) -> System.out.println("Libro ya registrado en la base de datos"), () -> {
            BooksEntity entity = new BooksEntity(response.books().get(0));

            Optional<AuthorEntity> author = authorRepository.findByName(entity.getAuthor().getName());
            if (author.isEmpty()) {
                entity.setAuthor(authorRepository.save(entity.getAuthor()));
            } else {
                entity.setAuthor(author.get());
            }
            booksRepository.save(entity);
        });

    }

    public void getAllBooks() {
        booksRepository.findAll().forEach(System.out::println);
    }

    public void getAllAuthors() {

        authorRepository.findAll().forEach(System.out::println);
    }

    public void getAuthorsByYear(int anio) {
        authorRepository.findAuthorsByYear(anio).forEach(System.out::println);
    }

    public void findBooksByLanguage(String optionLanguages) {
        List<BooksEntity> books = booksRepository.findByLanguage(optionLanguages);
        if (books.isEmpty()) {
            System.out.println("Libro no encontrado");
            return;
        }
        books.forEach(System.out::println);
    }
}
