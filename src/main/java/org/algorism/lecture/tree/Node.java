package org.algorism.lecture.tree;

public class Node {

    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(NodeBuilder builder) {
        this.data = builder.data;
        this.left = builder.left;
        this.right = builder.right;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public static NodeBuilder builder() {
        return new NodeBuilder();
    }
    public static class NodeBuilder {

        private int data;
        private Node left;
        private Node right;

        public NodeBuilder data(int data) {
            this.data = data;
            return this;
        }

        public NodeBuilder left(Node left) {
            this.left = left;
            return this;
        }

        public NodeBuilder right(Node right) {
            this.right = right;
            return this;
        }

        public Node build() {
            return new Node(this);
        }
    }
}
