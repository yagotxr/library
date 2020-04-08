package com.henrik.repository;

import com.henrik.Book;
import com.henrik.database.BookTree;

public interface BookRepository {

    Book insert(Book b);
    Book find(long id);
}
