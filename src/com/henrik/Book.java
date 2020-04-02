package com.henrik;

public class Book {

    private int id;
    private String title;
    private String description;
    private String author;
    private String publisher;

    public Book(int id, String title, String description, String author, String publisher) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }
}
