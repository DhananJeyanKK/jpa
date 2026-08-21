package learn.dhanan.sdjpa_intro;

import learn.dhanan.sdjpa_intro.repositories.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Spring Boot Test :
 *
 * 	It loads all the Context and startup the server with H2 In memory. We can test realtime.
 *
 * 	How to avoid loading all context : You can use DataJpaTest which loads only JPA context.
 *
 * 	How to ensure Order of execution - @TestMethodOrder(MethodOrderer.OrderAnnotation.class) Can be used. @Order(2) in Method.
 *
 * 	After executing every test method - It destroys the data creatd - how to keep them for next method? You can use @Commit or
 * @Rollback(value=false)
 *
 * To bootstrap the data  - You can do component scan for specific package -
 *@ComponentScan(basePackages = {"learn.dhanan.sdjpa_intro.bootstrap"})
 *
 *
 */

@SpringBootTest
class SdjpaIntroApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	void testBookRepository(){
		long count = bookRepository.count();
		assertThat(count).isGreaterThan(0);
	}

	@Test
	void contextLoads() {
	}

}
