/*******************************************************************************
 * Copyright (c) 2016 Inova Software S.A. All Rights Reserved.
 *   50 cours de la Republique, 69100 Villeurbanne, FRANCE; 
 *   Phone: +33-4-78-27-95-02; Fax: +33-4-78-68-00-94
 * Contributors:
 *   FrontEnd Team
 *******************************************************************************/
package struct.list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author mboullouz
 *
 */
public class BstMain {
	static boolean found = false;
	static BstNode sNode = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * @formatter:off 
		 *            9 
		 *          /   \ 
		 *        2      15  
		 *       / \     / \ 
		 *      1  20    10 21
		 *     / \
		 *    18 50
		 * @formatter:on
		 */
		BstNode node0 = new BstNode(7);
		BstNode node0Left = new BstNode(5);

		BstNode node1Left = new BstNode(2).setLeft(new BstNode(1)).setRight(new BstNode(20));
		BstNode node1Rigt = new BstNode(15).setLeft(new BstNode(10)).setRight(new BstNode(21));

		BstNode node0Rigt = new BstNode(9).setLeft(node1Left).setRight(node1Rigt);

		node0.setLeft(node0Left).setRight(node0Rigt);

		// traverse(node0);
		int[] arr = new int[] { 9, 2, 15, 1, 20, 10, 21, 18, 50 };
		generateFromArray(arr);
		BstNode head = reConstruct();
		traverseNoRec(head);

		// search(10, head);
		// System.out.println("found? " + found + " Parent ");

	}

	public static void traverseNoRec(BstNode head) {
		BstNode current = head;
		Stack<BstNode> stack = new Stack<>();
		stack.push(head);
		while ((current=stack.pop())!=null) {
			System.out.println("E:"+current.getValue());
			stack.push(current.getLeft());
			current=current.getRight();
		}
	}

	public static void search(int v, BstNode head) {
		if (head == null || found) {
			return;
		}
		System.out.println("Current search v: " + head.getValue());
		if (head.getValue() == v) {
			found = true;
			sNode = head;
			return;
		}
		search(v, head.getLeft());
		search(v, head.getRight());
	}

	/**
	 * @param head
	 */
	public static void traverse(BstNode head) {
		if (head == null) {
			return;
		}
		System.out.println("\n Current traversed value: " + head.getValue());
		traverse(head.getLeft());
		traverse(head.getRight());
	}

	static Queue<TreeResult> nodes = new LinkedList<>();

	public static BstNode reConstruct() {
		for (TreeResult rs : nodes) {
			// System.out.println("current rs: " + rs.getNode().getValue());
			BstNode element = rs.getNode();
			Integer position = rs.getPosition();
			BstNode parent = rs.getParent();

			if (parent != null) {
				if (position == 0) {
					parent.setLeft(element);
				} else {
					parent.setRight(element);
				}
			} else {

			}

		}
		return nodes.poll().getNode();
	}

	public static void generateFromArray(int[] arr) {
		BstNode parent = null;
		for (int k = 0; k < arr.length; k++) {
			BstNode head = new BstNode(arr[k]);
			nodes.add(new TreeResult(head, (k - 1) % 2, parent));
			if (k % 2 == 0)
				parent = head;
		}
		return;
	}

}
