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
public class BstNode {
	private BstNode left;
	private BstNode right;
	private int value;

	/**
	 * @param value
	 */
	public BstNode(int value) {
		super();
		this.value = value;
	}

	public BstNode setLeft(BstNode left) {
		this.left = left;
		return this;
	}

	public BstNode setRight(BstNode right) {
		this.right = right;
		return this;
	}

	public BstNode getRight() {
		return right;
	}

	public BstNode getLeft() {
		return left;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
