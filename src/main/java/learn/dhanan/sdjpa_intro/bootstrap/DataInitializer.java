package learn.dhanan.sdjpa_intro.bootstrap;

import learn.dhanan.sdjpa_intro.domain.Book;
import learn.dhanan.sdjpa_intro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book book = new Book();
        book.setTitle("DDD");
        book.setIsbnl("111");
        book.setPublisher("Dhanan");

        Book savedBook = bookRepository.save(book);
        System.out.println(savedBook.getId());

        /**
         * making some change in main - OK
         *dfgdfg
         * sdfsdfsdfsdf
         *
         * Making same change and do the update
         *
         * Some chagen in main         *
         *
         * - I did an hotfix
         *
         */


        Book book1 = new Book();
        book1.setTitle("SIA");
        book1.setIsbnl("111");
        book1.setPublisher("Dhanan");

        Book savedBookSIA = bookRepository.save(book1);
        System.out.println(savedBookSIA.getId());

        bookRepository.findAll().forEach(bookT -> System.out.println(bookT.getId()));
    }
}
