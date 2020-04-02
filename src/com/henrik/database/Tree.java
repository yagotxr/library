package com.henrik.database;

import org.w3c.dom.Node;

public class Tree<E> {

    private Node root;
    private long size;
    private long nodes;

    public Node getRoot() {
        return root;
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

    public class Node {

        private Node left;
        private E value;
        private Node right;

        public Node getLeft() {
            return left;
        }

        public E getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }
    }
}
