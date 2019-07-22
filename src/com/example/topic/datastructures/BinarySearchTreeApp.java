package com.example.topic.datastructures;

public class BinarySearchTreeApp {

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(9, "Nine");
        binarySearchTree.add(4, "Four");
        binarySearchTree.add(6, "Six");
        binarySearchTree.add(20, "Twenty");
        binarySearchTree.add(170, "One hundred seventy");
        binarySearchTree.add(15, "Fifteen");
        binarySearchTree.add(1, "One");
        System.out.println("Done");

        System.out.println(binarySearchTree.get(55));
    }


}



class BinarySearchTree<K extends Object, V> {

    Node<K, V> root ;

    public void add(K key, V value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
        } else {
            Node currentNode = root;
            while (true) {
                if (newNode.getKey().hashCode() < currentNode.getKey().hashCode()) {
                    // LEFT
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        break;
                    }
                    currentNode = currentNode.getLeft();
                } else {
                    // RIGHT
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        break;
                    }
                    currentNode = currentNode.getRight();
                }
            }
        }
    }

    public V get(K key) {

        if (root == null) {
            throw new  RuntimeException("Tree is empty.");
        }

        Node currentNode = root;

        while (currentNode != null) {

            if (currentNode.getKey().hashCode() == key.hashCode()) {
                // MATCH
                return (V) currentNode.getValue();
            } else if (key.hashCode() < currentNode.getKey().hashCode()) {
                // LEFT
                currentNode = currentNode.getLeft();
            } else {
                // RIGHT
                currentNode = currentNode.getRight();
            }
        }

        return null;
    }

    private class Node<K extends Object, V> {

        V value;
        K key;
        Node right;
        Node left;

        Node(K key, V value) {
            this.value = value;
            this.key = key;
            this.right = null;
            this.left = null;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }
    }

}