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

    private void insertOnNode(Node n, Book b){
        if (n != null) {
            if (b.getId() < n.book.getId()) {
                if (n.left != null) {
                    insertOnNode(n.left, b);
                } else {
                    n.left = new Node(b);
                    System.out.println("  [DATABASE] Inserted: " + b.toString());
                }
            } else if (b.getId() > n.book.getId()) {
                if (n.right != null) {
                    insertOnNode(n.right, b);
                } else {
                    System.out.println("  [DATABASE] Inserted: " + b.toString());
                    n.right = new Node(b);
                }
            }
        }
    }

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
