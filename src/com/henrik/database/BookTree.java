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
            System.out.println("A book with id["+ b.getId() + "] has already been inserted.");
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
        Book book = find(id);
        return book != null;
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

        Node node = findNode(root, id);
        if(node != null){
            return node.book;
        }

        return null;
    }

    private Node findNode(Node n, long id){
        if(n != null){
            if(id == n.book.getId()){
                return n;
            }

            if(id < n.book.getId()){
                return findNode(n.left, id);
            } else {
                return findNode(n.right, id);
            }
        }
        return null;
    }

    /**
     * Removes a book by @param {id}
     * @return
     */
    public boolean delete(long id) {
        if (root == null) {
            return false;
        }

        Node node = root;
        Node primaryNode = root;
        boolean secondaryLeft = true;

        while (node.book.getId() != id) {
            primaryNode = node;
            if(id < node.book.getId() ) {
                node = node.left;
                secondaryLeft = true;
            }
            else {
                node = node.right;
                secondaryLeft = false;
            }
            if (node == null) {
                return false;
            }
        }

        if (node.left == null && node.right == null) {
            if (node == root ) root = null;
            else if (secondaryLeft) primaryNode.left = null;
            else primaryNode.right = null;
        }
        else if (node.right == null) {
            if (node == root) root = node.left;
            else if (secondaryLeft) primaryNode.left = node.left;
            else primaryNode.right = node.left;
        }
        else if (node.left == null) {
            if (node == root) root = node.right;
            else if (secondaryLeft) primaryNode.left = node.right;
            else primaryNode.right = node.right;
        }
        else {
            Node nextNode = setNext(node);
            if (node == root) root = nextNode;
            else if(secondaryLeft) primaryNode.left = nextNode;
            else primaryNode.right = nextNode;
            nextNode.left = node.left;
        }

        return true;
    }

    public Node setNext(Node deletingNode) {
        Node previousNode = deletingNode;
        Node nextNode = deletingNode;
        Node actual = deletingNode.right;

        while (actual != null) {
            previousNode = nextNode;
            nextNode = actual;
            actual = actual.left;
        }
        if (nextNode != deletingNode.right) {
            previousNode.left = nextNode.right;
            nextNode.right = deletingNode.right;
        }
        return nextNode;
    }

    /**
     * Returns if Tree is empty
     */
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

        public boolean isLeaf(){
            return left == null && right == null;
        }
    }
}
