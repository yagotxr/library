package com.henrik;

import com.henrik.repository.BookRepository;

import static com.henrik.database.BookTree.init;

public class Main {

    public static void main(String[] args) {
        BookRepository database = init();

        database.insert(new Book(5,null, null, null, null));
        database.insert(new Book(6,null, null, null, null));
        database.insert(new Book(1,null, null, null, null));
        database.insert(new Book(3,null, null, null, null));
        database.insert(new Book(4,null, null, null, null));
        database.insert(new Book(8,null, null, null, null));
        database.insert(new Book(2,null, null, null, null));
        database.insert(new Book(9,null, null, null, null));
        database.insert(new Book(7,null, null, null, null));

        Book found = database.find(1);
        System.out.println(found.toString());
        found = database.find(9);
        System.out.println(found.toString());

    }
}