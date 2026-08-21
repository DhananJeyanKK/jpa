package learn.dhanan.sdjpa_intro;


import learn.dhanan.sdjpa_intro.repositories.BookRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * Spring Boot
 *
 * We configured MySQL - Hibernate creates MySQL based query to create table on startup
 * but it is not created because DataJPATest create H2 In memory database - It doesn't take our configs.
 *
 * So to take MySQL instead of H2 In memory = We have to use AutoConfigureTestData replce with None.
 * Then it works with MysQL not H2 In memory.
 *
 *
 * Generally it is overriding our config. If we configure H2 also its fine but you have to mention AutoConfigure none to
 * take your H2 config.
 *
 *
 */
@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"learn.dhanan.sdjpa_intro.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {


    @Autowired
    BookRepository bookRepository;

    @Test
    void testSQL(){
        long count = bookRepository.count();
        assertThat(count).isEqualTo(2);
    }



}
