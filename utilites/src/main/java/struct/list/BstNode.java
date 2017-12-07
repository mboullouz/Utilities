package struct.list;

/**
 * @author mboullouz
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

    public BstNode getRight() {
        return right;
    }

    public BstNode setRight(BstNode right) {
        this.right = right;
        return this;
    }

    public BstNode getLeft() {
        return left;
    }

    public BstNode setLeft(BstNode left) {
        this.left = left;
        return this;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
