package struct.list;

public class TreeResult {
    BstNode node;
    int position;
    BstNode parent;

    public TreeResult(BstNode node, int position, BstNode parent) {
        super();
        this.node = node;
        this.position = position;
        this.parent = parent;
    }

    public BstNode getNode() {
        return node;
    }

    public void setNode(BstNode node) {
        this.node = node;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public BstNode getParent() {
        return parent;
    }

    public void setParent(BstNode parent) {
        this.parent = parent;
    }

}
