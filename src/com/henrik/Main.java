package com.henrik;

import com.henrik.repository.BookRepository;

import static com.henrik.database.BookTree.init;

public class Main {

    public static void main(String[] args) {
        BookRepository database = init();

        database.insert(new Book(50,null, null, null, null));
        database.insert(new Book(40,null, null, null, null));
        database.insert(new Book(80,null, null, null, null));
        database.insert(new Book(30,null, null, null, null));
        database.insert(new Book(45,null, null, null, null));
        database.insert(new Book(60,null, null, null, null));
        database.insert(new Book(90,null, null, null, null));
        database.insert(new Book(20,null, null, null, null));
        database.insert(new Book(32,null, null, null, null));

        System.out.println(database.find(40).toString());
        database.delete(40);
       if(database.find(40) == null) System.out.println("not found");

    }
}