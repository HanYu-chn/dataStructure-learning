package Queue.LinkedQueue;

/**
 * @ClassName Node
 * @Description 链式存储的队列结点, 存储类型为String
 * @Author YH
 * @Date 2019/6/4 22:37
 * @Version 1.0
 **/

public class Node {
    /*结点存储内容*/
    private String context;

    /*下一个结点的引用*/
    private Node nextNode;

    /*---------------------------------------分割线-----------------------------------------**/
    /*
     * @Description: 构造函数
     * @Param: [element] 结点存储元素
     **/
    public Node(String element) {
        context = element;
    }

    /*---------------------------------------分割线-----------------------------------------**/
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
