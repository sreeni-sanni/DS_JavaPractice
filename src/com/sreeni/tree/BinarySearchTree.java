package com.sreeni.tree;

public class BinarySearchTree {
	Node root;

	/*
	 * Insert data in BST
	 */
	public Node insert(Node node, int key) {

		if (node == null) {
			node = new Node(key);
			return node;
		}
		if (key < node.key) {
			node.left = insert(node.left, key);
		} else if (key > node.key) {
			node.right = insert(node.right, key);
		}
		return node;
	}

	/*
	 * Delete node from BST
	 */
	public Node deleteNode(Node root, int key) {

		if (root == null) {
			return null;
		}
		if (key < root.key) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.key) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.right == null && root.left != null) {
				return root.left;
			} else if (root.left == null && root.right != null) {
				return root.right;
			} else {
			}
			Node temp = minVal(root.right);
			root.key = temp.key;
			root.right = deleteNode(root.right, root.key);
		}
		return root;
	}

	private Node minVal(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	/*
	 * BST InOrder traversal
	 */
	public void inOrder(Node node) {

		if (node != null) {
			inOrder(node.left);
			System.out.print(node.key + " ");
			inOrder(node.right);
		}

	}

	/*
	 * BST PreOrder traversal
	 */
	public void preOrder(Node node) {

		if (node != null) {
			System.out.print(node.key + " ");
			inOrder(node.left);
			inOrder(node.right);
		}
	}

	/*
	 * BST PostOrder traversal
	 */
	public void postOrder(Node node) {

		if (node != null) {
			inOrder(node.left);
			inOrder(node.right);
			System.out.print(node.key + " ");
		}
	}

}
