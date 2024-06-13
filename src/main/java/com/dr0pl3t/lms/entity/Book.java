package com.dr0pl3t.lms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String nameOfAuthor;
    @Column(name = "number_of_pages")
    private int numOfPages;
    @Column(name = "genre")
    private String genre;

    //NoArgsConstructor
    public Book() {

    }

    //AllArgsConstructor
    public Book(Long id, String title, String nameOfAuthor, int numOfPages, String genre) {
        this.id = id;
        this.title = title;
        this.nameOfAuthor = nameOfAuthor;
        this.numOfPages = numOfPages;
        this.genre = genre;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long bookId) {
        this.id = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    public void setNameOfAuthor(String nameOfAuthor) {
        this.nameOfAuthor = nameOfAuthor;
    }

    public Integer getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(Integer numOfPages) {
        this.numOfPages = numOfPages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
