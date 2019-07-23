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
        binarySearchTree.delete(20);

        System.out.println(binarySearchTree.get(55));
        System.out.println(binarySearchTree.get(20));
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
                } else if (newNode.getKey().hashCode() > currentNode.getKey().hashCode()){
                    // RIGHT
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        break;
                    }
                    currentNode = currentNode.getRight();
                } else if (newNode.getKey().hashCode() == currentNode.getKey().hashCode()){
                    // MATCH
                    currentNode.setValue(newNode.getValue());
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

    // This method is copied from tutorial.
    public void remove(K key) {
        if (root == null) {
            throw new RuntimeException("Cannot delete. Tree is empty");
        }

        Node currentNode = root;
        Node parentNode = null;

        while (true) {
            if (key.hashCode() < currentNode.getKey().hashCode()) {
                // LEFT
                currentNode = currentNode.getLeft();
                parentNode = currentNode;
            } else if (key.hashCode() > currentNode.getKey().hashCode()){
                // RIGHT
                currentNode = currentNode.getRight();
                parentNode = currentNode;
            } else if (key.hashCode() == currentNode.getKey().hashCode()){
                // Condition 1: When no right child
                if (currentNode.getRight() == null) {
                    if (parentNode == null) {
                        root = currentNode.getLeft();
                    } else {
                        // If parent > current value, make current left child a child of parent
                        if (currentNode.getKey().hashCode() < parentNode.getKey().hashCode()) {
                            parentNode.setLeft(currentNode.getLeft());

                            // If parent < current, make left child a right child of parent
                        } else if (currentNode.getKey().hashCode() > parentNode.getKey().hashCode()) {
                            parentNode.setRight(currentNode.getLeft());
                        }
                    }
                // Condition 2: Right child which doesn't have a left child
                } else if (currentNode.getRight().getLeft() == null) {
                    if (parentNode == null) {
                        root = currentNode.getLeft();
                    } else {
                        currentNode.getRight().setLeft(currentNode.getLeft());

                        // If parent > current, make right child of the left the parent
                        if (currentNode.getKey().hashCode() < parentNode.getKey().hashCode()) {
                            parentNode.setLeft(currentNode.getRight());
                        // If parent < current, make right child a right child of the parent
                        } else if (currentNode.getKey().hashCode() > parentNode.getKey().hashCode()) {
                            parentNode.setRight(currentNode.getRight());
                        } else {

                            // Find the right child's left most child
                            Node leftMostNode = currentNode.getRight().getLeft();
                            Node leftMostParentNode = currentNode.getRight();

                            while (leftMostNode.getLeft() != null) {
                                leftMostParentNode = leftMostNode;
                                leftMostNode = leftMostNode.getLeft();
                            }

                            // Parent's left subtree is now leftmost's right subtree
                            leftMostParentNode.setLeft(leftMostNode.getRight());
                            leftMostNode.setLeft(currentNode.getLeft());
                            leftMostNode.setRight(currentNode.getRight());

                            if (parentNode == null) {
                                root = leftMostNode;
                            } else {
                                if (currentNode.getKey().hashCode() < parentNode.getKey().hashCode()) {
                                    parentNode.setLeft(leftMostNode);
                                } else if (currentNode.getKey().hashCode() > parentNode.getKey().hashCode()) {
                                    parentNode.setRight(leftMostNode);
                                }
                            }
                        }
                    }
                    return;
                }
            }
        }
    }

    // This method is self implemented.
    public void delete(K key) {
        Node currentNode = root;
        Node parentNode = null;

        while (currentNode != null) {
            if (key.hashCode() > currentNode.getKey().hashCode()) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else if (key.hashCode() < currentNode.getKey().hashCode()) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (key.hashCode() == currentNode.getKey().hashCode()) {

                // Condition 1 : When Node has no children;
                if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                    // If current node is left of parent, then we set left of parent null
                    if (parentNode.getLeft().getKey().hashCode() == currentNode.getKey().hashCode()) {
                        parentNode.setLeft(null);

                    // If current node is right of parent, then we set right of parent null
                    } else if (parentNode.getRight().getKey().hashCode() == currentNode.getKey().hashCode()) {
                        parentNode.setRight(null);
                    }
                // Condition 2 : When Node has one child;
                } else if ((currentNode.getLeft() != null && currentNode.getRight() == null) ||
                        (currentNode.getLeft() == null && currentNode.getRight() != null)) {
                    // If current node is left of parent, then we set left of parent null
                    parentNode.setRight(currentNode.getRight());
                    parentNode.setLeft(currentNode.getLeft());

                // Condition 3 : When Node has two children
                } else if (currentNode.getLeft() != null && currentNode.getRight() != null) {
                    Node leftLeafNode = currentNode;
                    Node parentLeftLeafNode = null;

                    while (leftLeafNode.getLeft() != null) {
                        parentLeftLeafNode = leftLeafNode;
                        leftLeafNode = leftLeafNode.getLeft();
                    }

                    // If current node is left of parent, then we set left of parent
                    if (parentNode.getLeft().getKey().hashCode() == currentNode.getKey().hashCode()) {
                        parentNode.setLeft(leftLeafNode);

                    // If current node is right of parent, then we set right of parent
                    } else if (parentNode.getRight().getKey().hashCode() == currentNode.getKey().hashCode()) {
                        parentNode.setRight(leftLeafNode);
                    }

                    parentLeftLeafNode.setLeft(null);
                }
                return;
            }
        }
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