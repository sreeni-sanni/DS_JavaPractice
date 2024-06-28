package com.sreeni.tree;

public class Main {
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.root = tree.insert(tree.root, 5);
		tree.insert(tree.root, 8);
		tree.insert(tree.root, 3);
		tree.insert(tree.root, 7);
		tree.insert(tree.root, 4);
		tree.insert(tree.root, 6);
		tree.insert(tree.root, 9);
		tree.insert(tree.root, 2);
		tree.insert(tree.root, 1);
		tree.insert(tree.root, 10);
		
		System.out.println("Inorder BST:");
		tree.inOrder(tree.root);
		System.out.println("\npreOrder BST:");
		tree.preOrder(tree.root);
		System.out.println("\npostOrder BST:");
		tree.postOrder(tree.root);

		tree.root = tree.deleteNode(tree.root, 6);

		System.out.println(" after deletion -Inorder BST:");
		tree.inOrder(tree.root);

	}

}
