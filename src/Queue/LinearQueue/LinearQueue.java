package Queue.LinearQueue;

import Queue.Queue;

/**
 * @ClassName LinearQueue
 * @Description 顺序存储的队列
 * @Author YH
 * @Date 2019/6/4 22:05
 * @Version 1.0
 **/

public class LinearQueue implements Queue {
    /*队列默认大小**/
    private final int DEFAULTSIZE = 10;

    /*队列容器**/
    private String[] queue = new String[DEFAULTSIZE];

    /*队列长度**/
    private int length = 0;

    /*队列当前最大容量**/
    private int tempMaxSize = DEFAULTSIZE;
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
        queue = new String[DEFAULTSIZE];
        length = 0;
        tempMaxSize = DEFAULTSIZE;
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
        if (length == 0) {
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
        return queue[0];
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
        if (length < DEFAULTSIZE) {
            queue[length] = element;
            length++;
        } else {
            String[] temp = queue;
            tempMaxSize = tempMaxSize + 5;
            queue = new String[tempMaxSize];
            for (int i = 0; i < length; i++) {
                queue[i] = temp[i];
            }
            queue[length] = element;
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
        String temp = queue[0];
        for (int i = 0; i < length; i++) {
            queue[i] = queue[i + 1];
        }
        if (length > 0) {
            length--;
        }
        return temp;
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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < queue.length; i++) {
            stringBuilder.append(queue[i] + "-");
        }
        return stringBuilder.toString();
    }
}
