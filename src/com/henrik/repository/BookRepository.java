package com.henrik.repository;

import com.henrik.Book;

public interface BookRepository {

    Book insert(Book b);
    Book find(long id);
    boolean delete(long id);
}
