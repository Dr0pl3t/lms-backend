package com.dr0pl3t.lms.dto;

import jakarta.persistence.Column;

public class BookDto {

    private Long id;
    private String title;
    private String nameOfAuthor;
    private int numOfPages;
    private String genre;

    //NoArgsConstructor
    public BookDto() {

    }

    //AllArgsConstructor
    public BookDto(Long id, String title, String nameOfAuthor, int numOfPages, String genre) {
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

    public void setId(Long id) {
        this.id = id;
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

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
