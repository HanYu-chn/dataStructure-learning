package Tree.BinaryTree;

/**
 * @ClassName Node
 * @Description    二叉树结点
 * @Author YH
 * @Date 2019/6/9 21:39
 * @Version 1.0
 **/
public class Node {
    /*存储内容*/
    private char content;

    /*结点高度,默认高度为1*/
    private int height = 1;

    /*左孩子结点的引用*/
    private Node leftChildNode;

    /*右孩子结点的引用*/
    private Node rightChildNode;

    private Node parentNode;
    /*---------------------------------------分割线-----------------------------------------**/

    public Node(){}

    public Node(char value) {
        content = value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public char getContent() {
        return content;
    }

    public void setContent(char content) {
        this.content = content;
    }

    public Node getLeftChildNode() {
        return leftChildNode;
    }

    public void setLeftChildNode(Node leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public Node getRightChildNode() {
        return rightChildNode;
    }

    public void setRightChildNode(Node rightChildNode) {
        this.rightChildNode = rightChildNode;
    }
}
