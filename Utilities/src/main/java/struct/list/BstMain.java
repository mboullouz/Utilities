/*******************************************************************************
 * Copyright (c) 2016 Inova Software S.A. All Rights Reserved.
 *   50 cours de la Republique, 69100 Villeurbanne, FRANCE; 
 *   Phone: +33-4-78-27-95-02; Fax: +33-4-78-68-00-94
 * Contributors:
 *   FrontEnd Team
 *******************************************************************************/
package struct.list;

/**
 * @author mboullouz
 *
 */
public class BstMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 		7
		 * 	  /  \
		 *   5     9
		 *       /   \
		 *      2     15
		 *     /\     / \
		 *    1  20  10  21
 		 */
		BstNode node0 = new BstNode(7);
		BstNode node0Left = new BstNode(5);

		BstNode node1Left = new BstNode(2).setLeft(new BstNode(1)).setRight(new BstNode(20));
		BstNode node1Rigt = new BstNode(15).setLeft(new BstNode(10)).setRight(new BstNode(21));

		BstNode node0Rigt = new BstNode(9)
				.setLeft(node1Left)
				.setRight(node1Rigt);

		node0.setLeft(node0Left).setRight(node0Rigt);

		traverse(node0);

	}

	public static void traverse(BstNode head) {
		if (head == null) {
			return;
		}
		System.out.println("\n Current traversed value: " + head.getValue());
		traverse(head.getLeft());
		traverse(head.getRight());
	}

}
