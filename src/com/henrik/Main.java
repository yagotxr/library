package com.henrik;

import com.henrik.database.BookTree;
import com.henrik.repository.BookRepository;

public class Main {

    public static void main(String[] args) {
        BookRepository database = new BookTree();

        database.insert(
                new Book(5,
                        "Um",
                        "um", "1", "1")
        );

        database.insert(
                new Book(3,
                        "Um",
                        "um", "1", "1")
        );

        database.insert(
                new Book(6,
                        "Um",
                        "um", "1", "1")
        );

        database.insert(
                new Book(7,
                        "Um",
                        "um", "1", "1")
        );

        database.insert(
                new Book(1,
                        "Um",
                        "um", "1", "1")
        );
    }
}
