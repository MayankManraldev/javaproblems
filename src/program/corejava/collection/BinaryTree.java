package program.corejava.collection;

import java.util.Queue;
import java.util.LinkedList;

// Node class representing each node in the binary tree
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// BinaryTree class containing the root node and methods for operations
public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Method to insert a new node with a given key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive function to insert a new key in the binary tree
    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }


    public boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive function to search for a key in the binary tree
    private boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }
    /*In in-order traversal, the left child is visited first,
     followed by the node itself,
      and then the right child. This can be visualized as Left – Root – Right*/
    static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.key + " ");
            inorderTraversal(root.right);
        }
    }
    /*In pre-order traversal, the node is visited first,
     followed by its left child and then its right child.
      This can be visualized as Root – Left – Right.*/
    static void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
    /*In post-order traversal, the left child is visited first,
     followed by the right child, and then the node itself.
      This can be visualized as Left – Right – Root.*/
    static void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.key + " ");
        }
    }
    /*In level-order traversal,
     nodes are visited level by level from left to right.
      This is also known as Breadth-First Search (BFS).*/
    static void levelOrderTraversal(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.key + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    /*For storing value level order traverser in array*/
    public static int[] levelOrderTraversalArray(Node root) {
        if (root == null) return new int[0];

        // Calculate the size of the tree to initialize the array
        int size = getSize(root);
        int[] result = new int[size];
        int index = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            result[index++] = tempNode.key;

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        return result;
    }

    // Helper method to calculate the size of the tree
    private static int getSize(Node node) {
        if (node == null) return 0;
        return 1 + getSize(node.left) + getSize(node.right);
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes into the binary tree1
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Search for a key in the binary tree1
        int searchKey = 40;
        if (tree.search(searchKey))
            System.out.println("\nKey " + searchKey + " found in the tree1.");
        else
            System.out.println("\nKey " + searchKey + " not found in the tree1.");

        System.out.println("In-Order Traversal:");
        inorderTraversal(tree.root); // Output: 4 2 5 1 3

        System.out.println("\nPre-Order Traversal:");
        preorderTraversal(tree.root); // Output: 1 2 4 5 3

        System.out.println("\nPost-Order Traversal:");
        postorderTraversal(tree.root); // Output: 4 5 2 3 1

        System.out.println("\nLevel-Order Traversal:");
        levelOrderTraversal(tree.root); // Output: 1 2 3 4 5
        System.out.println();
        System.out.println("Level Order Traversal stored in array:");
        int[] traversalResult = tree.levelOrderTraversalArray(tree.root);
        for (int value : traversalResult) {
            System.out.print(value + " "); // Output: 1 2 3 4 5
        }
    }
}
