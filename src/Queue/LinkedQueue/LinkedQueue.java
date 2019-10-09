package Queue.LinkedQueue;

import Queue.Queue;

/**
 * @ClassName LinkedQueue
 * @Description  链式存储的队列,存储类型为String
 * @Author YH
 * @Date 2019/6/5 19:03
 * @Version 1.0
 **/

public class LinkedQueue implements Queue {
    /*头结点的引用*/
    private Node headNode;

    /*尾结点的引用*/
    private Node tailNode;

    /*队列长度*/
     private int length;
    /*---------------------------------------分割线-----------------------------------------**/
    /*
     *@Author YH
     *@Description 队列清空
     *@Date 21:58 2019/6/4
     *@Param []
     *@Return void
     *@Throws
     **/
    @Override
    public void clear() {
        length = 0;
        headNode = null;
        tailNode = null;
    }

    /*---------------------------------------分割线-----------------------------------------**/
    /*
     *@Author YH
     *@Description  判断队列是否为空
     *@Date 21:59 2019/6/4
     *@Param []
     *@Return boolean 若为空则返回true,不为空返回false
     *@Throws
     **/
    @Override
    public boolean isEmpty() {
        if(length == 0) {
            return true;
        }
        return false;
    }

    /*---------------------------------------分割线-----------------------------------------**/
    /*
     *@Author YH
     *@Description 获得队列头元素
     *@Date 22:01 2019/6/4
     *@Param []
     *@Return java.lang.String 队列头元素
     *@Throws
     **/
    @Override
    public String getHead() {
        if(length == 0) {
            return null;
        } else {
            return headNode.getContext();
        }
    }

    /*---------------------------------------分割线-----------------------------------------**/
    /*
     *@Author YH
     *@Description 插入元素element到队尾
     *@Date 22:03 2019/6/4
     *@Param [element] 插入元素
     *@Return void
     *@Throws
     **/
    @Override
    public void inQueue(String element) {
        if(length == 0) {
            headNode = new Node(element);
            tailNode = headNode;
            length ++;
        } else {
            Node newNode = new Node(element);
            tailNode.setNextNode(newNode);
            tailNode = newNode;
            length++;
        }
    }

    /*---------------------------------------分割线-----------------------------------------**/
    /*
     *@Author YH
     *@Description 从队列头部取出第一个元素
     *@Date 22:04 2019/6/4
     *@Param []
     *@Return java.lang.String 队头元素
     *@Throws
     **/
    @Override
    public String outQueue() {
        if(length == 0) {
            return null;
        } else {
            Node outNode = headNode;
            headNode = headNode.getNextNode();
            length--;
            if(length == 0) {
                tailNode = null;
            }
            return outNode.getContext();
        }
    }

    /*---------------------------------------分割线-----------------------------------------**/
    /*
     *@Author YH
     *@Description 获得队列长度
     *@Date 22:25 2019/6/4
     *@Param []
     *@Return int  返回队列长度
     *@Throws
     **/
    @Override
    public int size() {
        return length;
    }
    /*---------------------------------------分割线-----------------------------------------**/

    @Override
    public String toString() {
        Node tempNode = headNode;
        StringBuilder stringBuilder = new StringBuilder();
        while(tempNode != null) {
            stringBuilder.append(tempNode.getContext() + "-");
            tempNode = tempNode.getNextNode();
        }
        return stringBuilder.toString();
    }
}
