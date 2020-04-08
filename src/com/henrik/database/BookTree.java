package com.henrik.database;

import com.henrik.Book;
import com.henrik.repository.BookRepository;

public class BookTree implements BookRepository {

    private Node root;
    private long size;
    private long nodes;

    /**
     * Returns tree levels quantity.
     */
    public long size() {
        return size;
    }

    /**
     * Returns total nodes quantity.
     */
    public long getNodes() {
        return nodes;
    }

    /**
     * Inserts a book in tree.
     */
    public Book insert(Book b) {

        if(bookExists(b.getId())){
            return null;
        }

        if (root == null) {
            root = new Node(b);
            return b;
        }

        insertOnNode(root, b);
        return b;
    }

    /**
     * Recursive method to check the next nodes and decide whether to put it
     * on the left or right node depending on the id of the book.
     */
    private void insertOnNode(Node n, Book b){
        if (n != null) {

            if (b.getId() < n.book.getId()) {
                if (n.left != null) {
                    insertOnNode(n.left, b);
                } else {
                    n.left = new Node(b);
                    System.out.println("[DATABASE] Inserted: " + b.toString());
                }

            } else if (b.getId() > n.book.getId()) {
                if (n.right != null) {
                    insertOnNode(n.right, b);
                } else {
                    n.right = new Node(b);
                    System.out.println("[DATABASE] Inserted: " + b.toString());
                }
            }
        }
    }

    /**
     * Return a book by @param id
     */
    public Book find(long id){
        if(root == null){
            System.out.println("Database is empty.");
            return null;
        }

        return findOnNode(root, id);
    }

    private Book findOnNode(Node n, long id){
        if(n != null){
            if(id == n.book.getId()){
                return n.book;
            }

            if(id < n.book.getId()){
                return findOnNode(n.left, id);
            } else {
                return findOnNode(n.right, id);
            }
        }
        return null;
    }

    /**
     * Check if book with @param id is already inserted.
     */
    private boolean bookExists(long id){
        return false;
    }

    public static class Node {

        private Node left;
        private Book book;
        private Node right;

        public Node(Book book) {
            this.book = book;
            this.left = null;
            this.right = null;
        }
    }
}
