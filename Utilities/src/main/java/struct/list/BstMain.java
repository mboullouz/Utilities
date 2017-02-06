/*******************************************************************************
 * Copyright (c) 2016 Inova Software S.A. All Rights Reserved.
 *   50 cours de la Republique, 69100 Villeurbanne, FRANCE; 
 *   Phone: +33-4-78-27-95-02; Fax: +33-4-78-68-00-94
 * Contributors:
 *   FrontEnd Team
 *******************************************************************************/
package struct.list;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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
		 *               / \
		 *              18  50
 		 */ 
		BstNode node0 = new BstNode(7);
		BstNode node0Left = new BstNode(5);

		BstNode node1Left = new BstNode(2).setLeft(new BstNode(1)).setRight(new BstNode(20));
		BstNode node1Rigt = new BstNode(15).setLeft(new BstNode(10)).setRight(new BstNode(21));

		BstNode node0Rigt = new BstNode(9)
				.setLeft(node1Left)
				.setRight(node1Rigt);

		node0.setLeft(node0Left).setRight(node0Rigt);

		//traverse(node0);
		int[] arr= new int[] {9,2,15,1,20,10,21,18,50};
		traverse(generateFromArray(arr));

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
	
	public static BstNode generateFromArray(int[] arr){
		BstNode[] heads= new BstNode[arr.length/2+1];
		BstNode  prev=null;
		for(int i =0, k=0; i<arr.length-2; i=i+2,k++){
			BstNode  head = new BstNode(arr[k])
					.setLeft(new BstNode(arr[i+1]))
					.setRight(new BstNode(arr[i+2]));
			if(prev!=null){
				if(k%2==0)
					prev.setLeft(head);
				else
					prev.setRight(head);
			}
			heads[k]=head;
			prev=head;
		}

		return heads[0];
	}

}
