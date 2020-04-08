package com.henrik;

import com.henrik.repository.BookRepository;

import static com.henrik.database.BookTree.createTreeWithIdValues;
import static com.henrik.database.BookTree.init;

public class Main {

    public static void main(String[] args) {
        //Activity 1
        BookRepository tree = init();

        //Activity 2
        //item a)
        Book book;
        BookRepository a = createTreeWithIdValues( 80,3,90,70,20,15,18,17);

        BookRepository b = createTreeWithIdValues( 1,2,3,4,5,6,7,8,9,10);

        BookRepository c = createTreeWithIdValues( 10,9,8,7,6,5,4,3,2,1);

        //item b
        System.out.println("Activity 2 - B");

        findOn(a, 70);
        findOn(b, 3);
        findOn(c, 18);

        //item c
        System.out.println("Activity 2 - C");

        int id = 3;
        a.delete(id);
        b.delete(id);
        c.delete(id);

        findOn(a, id);
        findOn(b, id);
        findOn(c, id);

        System.out.println("Activity 3");
        //Without number 3, removed on activity 2 :)

        System.out.print("A - "); a.printOrderedTree();
        System.out.print("B - ");b.printOrderedTree();
        System.out.print("C - ");c.printOrderedTree();

    }

    public static void findOn(BookRepository tree, int id){
        Book book = tree.find(id);
        if(book != null) System.out.println("\nFound " + book.toString() +
                "\nIterations: " + tree.getIterations());
        else System.out.println("\nNot found");
    }
}