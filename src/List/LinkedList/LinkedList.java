package List.LinkedList;
import List.ListNode.Node;
/**
 * @ClassName LinkedList
 * @Description 链式存储结构线性表,存储类型为String型
 * @Author YH
 * @Date 2019/4/16 14:51
 * @Version 1.0
 **/

public class LinkedList {
    /**------------------------------分割线--------------------------------**/
    /**
     * @Description: 构造函数
     * @Param: []
     **/
    public LinkedList() {
        headNode = new Node();
    }
/**------------------------------分割线--------------------------------**/
    /**
     * 线性表的长度
     **/
    protected int size = 0;

    /**
     * 头结点
     **/
    protected Node headNode;

/**------------------------------分割线--------------------------------**/
    /**
     * @Author yuhan
     * @Description 根据输入序号, 查找链表中对应存放的元素, 若找不到, 则抛出异常
     * @Date 15:45 2019/4/16
     * @Param [positionID] 链表中对应结点的序号
     * @Return java.lang.String
     * @Throws Exception 输入结点ID错误
     **/
    public String getElement(int positionID) throws Exception {
        if(positionID < 0 || positionID >= size){
            throw new Exception("输入结点ID错误");
        }
        Node node = getNode(positionID);
        return node.getContext();
    }
/**------------------------------分割线--------------------------------**/
    /**
     * @Author yuhan
     * @Description 在链表的指定位置插入元素
     * @Date 16:13 2019/4/16
     * @Param [positionID, element] [链表中的位置,插入元素]
     * @Return void
     * @Throws Exception 输入结点ID错误
     **/
    public void insertElement(int positionID, String element) throws Exception {
        if(positionID < 0 || positionID > size){
            throw new Exception("输入结点ID错误");
        }
        Node preNode = getNode(positionID - 1);//获取插入点之前的那个结点
        Node newNode = new Node(element, preNode.getNextNode());
        preNode.setNextNode(newNode);
        size++;
    }
/**------------------------------分割线--------------------------------**/
    /**
     * @Author yuhan
     * @Description 在链表的指定位置删除元素
     * @Date 16:39 2019/4/16
     * @Param [positionID] [链表中的位置]
     * @Return void
     * @Throws Exception 输入结点ID错误
     **/
    public void deleteElement(int positionID) throws Exception {
        if(positionID < 0 || positionID >= size){
            throw new Exception("输入结点ID错误");
        }
        Node preNode = getNode(positionID - 1);//获取删除点之前的那个结点
        Node deleteNode = preNode.getNextNode();
        preNode.setNextNode(deleteNode.getNextNode());
        size--;
    }


/** ---------------------------------分割线-------------------------------------**/

    /**
     *@Author yuhan
     *@Description 从链表的头部插入元素
     *@Date 17:01 2019/4/16
     *@Param [element] [插入元素]
     *@Return void
     *@Throws
     **/
    public void headInsert(String element) {
        Node newNode = new Node(element, headNode.getNextNode());
        headNode.setNextNode(newNode);
        size++;
    }

/**------------------------------分割线--------------------------------**/
    /**
     * @Description 获取链表的长度
     * @Param []
     * @Return int
     **/
    public int getSize() {
        return size;
    }

/**------------------------------分割线--------------------------------**/
    /**
     * @Author yuhan
     * @Description 根据查找结点序号, 返回链表对应位置的结点
     * @Date 15:42 2019/4/16
     * @Param [nodeID]
     * @Return LinkList.Node
     * @Throws
     **/
    protected Node getNode(int nodeID) {
        Node nodeTemp = headNode;
        for (int i = 0; i <= nodeID; i++) {
            nodeTemp = nodeTemp.getNextNode();
        }
        return nodeTemp;
    }
}
/**------------------------------分割线--------------------------------**/

