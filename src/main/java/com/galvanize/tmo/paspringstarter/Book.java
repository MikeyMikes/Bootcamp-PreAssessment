package com.galvanize.tmo.paspringstarter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
@SequenceGenerator(name="seq", initialValue=0, allocationSize=100)
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private Long id;

    private String author;
    private String title;
    private int datePublished;

    public Book() {}

    public Book(String author, String title, int datePublished) {
        this.author = author;
        this.title = title;
        this.datePublished = datePublished;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(int datePublished) {
        this.datePublished = datePublished;
    }
}
