package Queue.LinearQueue;

import Queue.Queue;

/**
 * @ClassName LinearCyclicQueue
 * @Description 顺序存储的循环队列
 * @Author YH
 * @Date 2019/6/4 23:12
 * @Version 1.0
 **/

public class LinearCyclicQueue implements Queue {
    /*队列默认大小**/
    private final int DEFAULTSIZE = 10;

    /*队列容器**/
    private String[] queue = new String[DEFAULTSIZE];

    /*队列头序号**/
    private int queueHead = 0;

    /*队列尾下一个位置序号**/
    private int queueTail = 0;

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
     **/@Override
    public void clear() {
        queue = new String[DEFAULTSIZE];
        tempMaxSize = DEFAULTSIZE;
        queueHead = 0;
        queueTail = 0;
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
        if(queueHead == queueTail) {
            return true;
        } else {
            return false;
        }
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
        if(queueHead == queueTail) {
            return null;
        } else {
            return queue[queueHead];
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
        if((queueTail + 1)%tempMaxSize == queueHead) {  //队满
            String[] temp = queue;
            int queueLength = (tempMaxSize + queueTail - queueHead) % tempMaxSize;
            queue = new String[tempMaxSize + 5];
            for (int i = 0; i < queueLength; i++) {
                queue[i] = temp[queueHead];
                queueHead++;
                queueHead = queueHead % tempMaxSize;
            }
            queueTail = queueLength;
            queue[queueTail++] = element;
            tempMaxSize = tempMaxSize + 5;
            queueHead = 0;
        } else {
            queue[queueTail] = element;
            queueTail++;
            queueTail = queueTail % tempMaxSize;
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
        if(queueTail == queueHead) {
            return null;
        } else {
            String temp = queue[queueHead];
            queue[queueHead] = null;
            queueHead = (queueHead + 1) % tempMaxSize;
            return temp;
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
        return (queueTail - queueHead + tempMaxSize) % tempMaxSize;
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
