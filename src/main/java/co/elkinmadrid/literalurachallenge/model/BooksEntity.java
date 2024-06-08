package co.elkinmadrid.literalurachallenge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class BooksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String language;

    private Integer downloadCount;

    @ManyToOne
    private AuthorEntity author;

    public BooksEntity() {
    }

    public BooksEntity(Books bookModel) {
        System.out.println("Entro ");
        System.out.println("Author: " + bookModel.authors());
        this.language = bookModel.languages().get(0);
        this.title = bookModel.title();
        this.downloadCount = bookModel.downloadCount();
        this.author = new AuthorEntity(bookModel.authors().get(0));
    }

    @Override
    public String toString() {
        return "- - - - Libro - - - - " +
                "\nTitulo: " + this.title +
                "\nNumero de Descargas: " + this.downloadCount +
                "\nAuthor: " + this.author.getName() +
                "\nIdioma: " + this.language +
                "\n------------";

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }
}
