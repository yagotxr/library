package com.henrik.repository;

import com.henrik.Book;
import com.henrik.database.Tree;

public interface BookRepository {

    Tree<Book> init();
}
