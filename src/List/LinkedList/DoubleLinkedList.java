package List.LinkedList;
import List.ListNode.Node;
/**
 * @ClassName DoubleLinkedList
 * @Description 循环双向链表, 存储类型为String型
 * @Author YH
 * @Date 2019/4/16 22:27
 * @Version 1.0
 **/

public class DoubleLinkedList extends LinkedList {
    /**--------------------------------分割线-----------------------------------**/
    /**
     * @Description: 构造函数
     * @Param: []
     **/
    public DoubleLinkedList() {
        headNode = new Node();
        headNode.setContext("头结点");
        headNode.setNextNode(headNode);//循环双链表初始状态头结点的后驱结点指向自己
        headNode.setPreNode(headNode);//循环双链表初始状态头结点前驱结点指向自己
    }
/**------------------------------分割线--------------------------------**/
    /**
     * @Author YH
     * @Description 双向链表的尾插法
     * @Date 22:57 2019/4/16
     * @Param [element] [存储内容]
     * @Return void
     * @Throws
     **/
    public void tailInsert(String element) {
        Node newNode = new Node(element, headNode.getPreNode(), headNode);
        headNode.getPreNode().setNextNode(newNode);
        headNode.setPreNode(newNode);
    }
/**---------------------------------分割线-----------------------------------------**/
    /**
     * @Author yuhan
     * @Description 双向链表的尾插法
     * @Date 17:01 2019/4/16
     * @Param [element] [插入元素]
     * @Return void
     * @Throws
     **/
    public void headInsert(String element) {
        Node newNode = new Node(element, headNode, headNode.getNextNode());
        headNode.getNextNode().setPreNode(newNode);
        headNode.setNextNode(newNode);
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
        if (positionID < 0 || positionID >= size) {
            throw new Exception("输入结点ID错误");
        }
        Node preNode = getNode(positionID - 1);//获取删除点之前的那个结点
        Node deleteNode = preNode.getNextNode();
        deleteNode.getNextNode().setPreNode(preNode);
        preNode.setNextNode(deleteNode.getNextNode());
        size--;
    }
/**----------------------------------分割线-----------------------------------**/
    /**
     * @Author yuhan
     * @Description 在链表的指定位置插入元素
     * @Date 16:13 2019/4/16
     * @Param [positionID, element] [链表中的位置,插入元素]
     * @Return void
     * @Throws Exception 输入结点ID错误
     **/
    public void insertElement(int positionID, String element) throws Exception {
        if (positionID < 0 || positionID > size) {
            throw new Exception("输入结点ID错误");
        }
        Node preNode = getNode(positionID - 1);//获取插入点之前的那个结点
        Node newNode = new Node(element, preNode, preNode.getNextNode());
        preNode.getNextNode().setPreNode(newNode);
        preNode.setNextNode(newNode);
        size++;
    }
/**------------------------------分割线--------------------------------**/
/**---------------------------------分割线-----------------------------------------**/
}
