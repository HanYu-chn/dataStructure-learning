package List.LinkedList;
import List.ListNode.Node;

/**
 * @ClassName CircularLinkedList
 * @Description 链式存储结构的线性表, 循环单向链表 存放String类型
 * @Author YH
 * @Date 2019/4/16 20:30
 * @Version 1.0
 **/

public class CircularLinkedList extends LinkedList {
/**--------------------------------分割线-----------------------------------**/
    /**
     * @Description: 构造函数
     * @Param: []
     **/
    public CircularLinkedList() {
        headNode = new Node();
        headNode.setContext("头结点");
        headNode.setNextNode(headNode);//循环单链表初始状态头结点自己指向自己
    }
/**------------------------------分割线--------------------------------**/
}


