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
        database.insert(new Book(1,null, null, null, null));
        database.insert(new Book(60,null, null, null, null));

        int id = 30;
        Book book = database.find(id);
        if(book != null){
            System.out.println("Found.");
        } else {
            System.out.println("Not Found.");
        }

        database.delete(id);
        book = database.find(id);
        if(book != null){
            System.out.println("Found.");
        } else {
            System.out.println("Not Found.");
        }
    }
}