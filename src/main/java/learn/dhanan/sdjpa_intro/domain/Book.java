package learn.dhanan.sdjpa_intro.domain;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Book {



    /**
     * Generation Type - Auto - This chooses the strategy based on database and JPA Provider
     * Generation Type - Identity - This is automatically handled by DB. +1 by DB itself.
     * Generation Type - Table - Separate table to manage primary key - Overhead of Performance issue.
     * Generation Type - Sequence - Separate Sequence maintained by DB - Oracle in general.
     * Generation Type - UUID - UUID is created as Primary Key - JPA 3 and above
     *
     */


    public Long getId() {
        return id;
    }

    /**
     *
     * Why its important to override equals & hashcode only based on id?
     *                              ID based                    All Fields
     * Correctness and Proxies - Works with lazy loaded         Fails - Proxy != Real Entity
     * Performance                  Fast                        Slow
     * Hash Stability               Stable - no change of Id    Mutable fields break Hash value
     * Hibernate Best Prac          Recom by Hibernate Docs     Leads to Bugs
     *
     * @NoRepositoryBean - Which means Bean is not created.
     *
     * We have Repository, CRUDRepository, JPARepository
     *
     * Simple operations CrudRepository
     * Complex JpaRepository
     *
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbnl;
    private String publisher;
    @Column(name = "author_id")
    private Long authorId;


    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getIsbnl() {
        return isbnl;
    }

    public void setIsbnl(String isbnl) {
        this.isbnl = isbnl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


}
