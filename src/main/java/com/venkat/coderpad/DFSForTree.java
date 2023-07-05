package com.venkat.coderpad;

public class DFSForTree {
	 Node root;
	  
	 DFSForTree() { root = null; }
	  
	    /* Given a binary tree, print its nodes according to the
	      "bottom-up" postorder traversal. */
	    void printPostorder(Node node)
	    {
	        if (node == null)
	            return;
	  
	        // first recur on left subtree
	        printPostorder(node.left);
	  
	        // then recur on right subtree
	        printPostorder(node.right);
	  
	        // now deal with the node
	        System.out.print(node.key + " ");
	    }
	  
	    /* Given a binary tree, print its nodes in inorder*/
	    void printInorder(Node node)
	    {
	        if (node == null)
	            return;
	  
	        /* first recur on left child */
	        printInorder(node.left);
	  
	        /* then print the data of node */
	        System.out.print(node.key + " ");
	  
	        /* now recur on right child */
	        printInorder(node.right);
	    }
	  
	    /* Given a binary tree, print its nodes in preorder*/
	    void printPreorder(Node node)
	    {
	        if (node == null)
	            return;
	  
	        /* first print data of node */
	        System.out.print(node.key + " ");
	  
	        /* then recur on left subtree */
	        printPreorder(node.left);
	  
	        /* now recur on right subtree */
	        printPreorder(node.right);
	    }
	  
	    // Wrappers over above recursive functions
	    void printPostorder() { printPostorder(root); }
	    void printInorder() { printInorder(root); }
	    void printPreorder() { printPreorder(root); }
	  
	    // Driver method
	    public static void main(String[] args)
	    {
	    	DFSForTree tree = new DFSForTree();
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	        tree.root.right.left = new Node(6);
	        tree.root.right.right = new Node(7);
	  
	        System.out.println(
	            "Preorder traversal of binary tree is ");
	        tree.printPreorder();
	  
	        System.out.println(
	            "\nInorder traversal of binary tree is ");
	        tree.printInorder();
	  
	        System.out.println(
	            "\nPostorder traversal of binary tree is ");
	        tree.printPostorder();
	    }
}

class Node {
    int key;
    Node left, right;
  
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}