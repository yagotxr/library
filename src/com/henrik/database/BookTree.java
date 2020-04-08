package com.henrik.database;

import com.henrik.Book;
import com.henrik.repository.BookRepository;

public class BookTree implements BookRepository {

    private Node root;
    private long size;
    private long nodes;

    private BookTree() {
        this.root = null;
        this.size = 0;
        this.nodes = 0;
    }

    /**
     * Initiate an empty tree.
     */
    public static BookTree init(){
        return new BookTree();
    }

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

        if (isEmpty()) {
            root = new Node(b);
        } else {
            insertOnNode(root, b);
        }
        size++;
        System.out.println("[DATABASE] Inserted: " + b.toString());
        return b;
    }

    private boolean bookExists(long id){
        return false;
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
                }

            } else if (b.getId() > n.book.getId()) {
                if (n.right != null) {
                    insertOnNode(n.right, b);
                } else {
                    n.right = new Node(b);
                }
            }
        }
    }

    /**
     * Return a book by @param {id}
     */
    public Book find(long id){
        if(isEmpty()){
            System.out.println("Database is empty.");
            return null;
        }

        return findOnNode(root, id).book;
    }

    private Node findOnNode(Node n, long id){
        if(n != null){
            if(id == n.book.getId()){
                return n;
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
     * Removes a book by @param {id}
     */
    public void delete(long id){

    }


    public boolean isEmpty(){
        return size == 0;
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
