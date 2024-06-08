package co.elkinmadrid.literalurachallenge.repository;

import co.elkinmadrid.literalurachallenge.model.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<BooksEntity, Long> {

    Optional<BooksEntity> findByTitle(String title);

    List<BooksEntity> findByLanguage(String language);
}
