package learn.dhanan.sdjpa_intro.repositories;

import learn.dhanan.sdjpa_intro.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
