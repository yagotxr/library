package com.henrik;

import com.henrik.database.BookTree;
import com.henrik.repository.BookRepository;

public class Main {

    public static void main(String[] args) {
        BookRepository database = new BookTree();

        database.insert(new Book(5,null, null, null, null));
        database.insert(new Book(6,null, null, null, null));
        database.insert(new Book(1,null, null, null, null));
        database.insert(new Book(3,null, null, null, null));
        database.insert(new Book(4,null, null, null, null));
        database.insert(new Book(8,null, null, null, null));
        database.insert(new Book(2,null, null, null, null));
        database.insert(new Book(9,null, null, null, null));
        database.insert(new Book(7,null, null, null, null));

        Book found = database.find(10);
        System.out.println(found.toString());

    }
}