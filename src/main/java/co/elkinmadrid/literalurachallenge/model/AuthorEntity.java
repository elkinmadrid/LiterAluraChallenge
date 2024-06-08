package co.elkinmadrid.literalurachallenge.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;


@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer birthYear;
    private String name;
    private Integer deathYear;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BooksEntity> books;


    public AuthorEntity() {
    }

    public AuthorEntity(Persons persons) {
        this.birthYear = persons.birthYear();
        this.name = persons.name();
        this.deathYear = persons.deathYear();
    }


    @Override
    public String toString() {
        List<String> authors = books.stream().map(BooksEntity::getTitle).toList();
        return "--- Autor --- " +
                "\nNombre: " + name +
                "\nFecha de nacimiento: " + birthYear +
                "\nFecha de Fallecimiento: " + deathYear +
                "\nLibros: " + authors;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

}
