package com.sreeni.tree;

public class BinarySearchTree {
	Node root;

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

	public Node deleteNode(Node root, int key) {

		if (root == null) {
			return root;
		}
		if (root != null && key < root.key) {
			root.left = deleteNode(root.left, key);
		} else if (root != null && key > root.key) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.right == null) {
				return root.left;
			} else if (root.left == null) {
				return root.right;
			} else {

				Node temp = minVal(root.right);
				root.key = temp.key;
				root.right = deleteNode(root.right, root.key);

			}
		}
		return root;

	}

	private Node minVal(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public void inOrder(Node node) {

		if (node != null) {
			inOrder(node.left);
			System.out.print(node.key + " ");
			inOrder(node.right);
		}

	}

	public void preOrder(Node node) {

		if (node != null) {
			System.out.print(node.key + " ");
			inOrder(node.left);
			inOrder(node.right);
		}
	}

	public void postOrder(Node node) {

		if (node != null) {
			inOrder(node.left);
			inOrder(node.right);
			System.out.print(node.key + " ");
		}
	}

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

		tree.root = tree.deleteNode(tree.root, 8);

		System.out.println(" after deletion -Inorder BST:");
		tree.inOrder(tree.root);

	}

}
