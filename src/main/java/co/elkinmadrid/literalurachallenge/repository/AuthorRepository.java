package co.elkinmadrid.literalurachallenge.repository;

import co.elkinmadrid.literalurachallenge.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    @Query(value = "SELECT a FROM AuthorEntity a WHERE a.name = :name")
    Optional<AuthorEntity> findByName(String name);

    @Query("SELECT a FROM AuthorEntity a WHERE :year BETWEEN a.birthYear AND a.deathYear")
    List<AuthorEntity> findAuthorsByYear(int year);
}
