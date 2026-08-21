package learn.dhanan.sdjpa_intro;

import learn.dhanan.sdjpa_intro.domain.Book;
import learn.dhanan.sdjpa_intro.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This creates only JPA context loaded on the server startup
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"learn.dhanan.sdjpa_intro.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    @Commit
    @Order(1)
    @Test
    void testSlice(){

        long count = bookRepository.count();
        assertThat(count).isEqualTo(2);

        Book b = new Book();
        b.setTitle("sdfsdfd");
        b.setPublisher("sdfsdf");
        b.setIsbnl("23434");

        bookRepository.save(b);

        long countAfter = bookRepository.count();

        assertThat(count).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testSliceTransaction(){

        long count = bookRepository.count();
        assertThat(count).isEqualTo(3);
    }
}
