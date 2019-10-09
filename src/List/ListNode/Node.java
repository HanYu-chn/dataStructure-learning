package List.ListNode;

/**
 * @ClassName Node
 * @Description
 * @Author YH
 * @Date 2019/4/16 22:10
 * @Version 1.0
 **/

public class Node {
    /**------------------------------分割线--------------------------------**/
    /**
     * @Description: 构造函数
     * @Param: []
     **/
    public Node() {
    }
/**------------------------------分割线--------------------------------**/
    /**
     * @Description: 构造函数
     * @Param: [context, nextNode] context:结点存放内容;
     *                             nextNode:下一个结点
     **/
    public Node(String context, Node nextNode) {
        this.nextNode = nextNode;
        this.context = context;
    }
/**------------------------------分割线--------------------------------**/
    /**
     * @Description: 构造函数
     * @Param: [context, preNode, nextNode] [结点存放内容,前驱结点,后驱结点]
    **/
    public Node(String context, Node preNode, Node nextNode) {
        this.nextNode = nextNode;
        this.context = context;
        this.preNode = preNode;
    }
/**------------------------------分割线--------------------------------**/
    /**后驱引用**/
    private Node nextNode;

    /**前驱引用**/
    private Node preNode;

    /**结点内容**/
    private String context;
/**------------------------------分割线--------------------------------**/
    /**
     *@Author yuhan
     *@Description 获取结点中的内容
     *@Date 15:20 2019/4/16
     *@Param []
     *@Return java.lang.String
     **/
    public String getContext() {
        return context;
    }
/**------------------------------分割线--------------------------------**/
    /**
     *@Author yuhan
     *@Description 设置结点内容
     *@Date 15:20 2019/4/16
     *@Param [context] 结点内容
     *@Return void
     **/
    public void setContext(String context) {
        this.context = context;
    }
/**------------------------------分割线--------------------------------**/
    /**
     *@Description 获取该结点的下一个结点
     *@Param []
     *@Return LinkList.Node   返回该结点的下一个结点
     **/
    public Node getNextNode() {
        return nextNode;
    }
/**------------------------------分割线--------------------------------**/
    /**
     *@Description 设置该结点的下一个结点
     *@Param [nextNode] 该结点的下一个结点
     *@Return void
     **/
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
/**------------------------------分割线--------------------------------**/
    /**
     *@Description 获取该结点的上一个结点
     *@Param []
     *@Return Node 该结点的上一个结点
     **/
    public Node getPreNode() {
        return preNode;
    }
/**------------------------------分割线--------------------------------**/
    /**
     *@Description 设置该结点的上一个结点
     *@Param [nextNode] 该结点的上一个结点
     *@Return void
     **/
    public void setPreNode(Node preNode) {
        this.preNode = preNode;
    }
}

