package Queue;

/**
 * @InterfaceName Queue
 * @Description 队列的接口, 存储类型为String
 * @Author YH
 * @Date 2019/6/4 21:57
 * @Version 1.0
 **/
public interface Queue {
    /*
     *@Author YH
     *@Description 队列清空
     *@Date 21:58 2019/6/4
     *@Param []
     *@Return void
     *@Throws
     **/
    public void clear();

    /*---------------------------------------分割线-----------------------------------------**/
    /*
     *@Author YH
     *@Description  判断队列是否为空
     *@Date 21:59 2019/6/4
     *@Param []
     *@Return boolean 若为空则返回true,不为空返回false
     *@Throws
     **/
    public boolean isEmpty();

    /*---------------------------------------分割线-----------------------------------------**/
    /*
     *@Author YH
     *@Description 获得队列头元素
     *@Date 22:01 2019/6/4
     *@Param []
     *@Return java.lang.String 队列头元素
     *@Throws
     **/
    public String getHead();

    /*---------------------------------------分割线-----------------------------------------**/
    /*
     *@Author YH
     *@Description 插入元素element到队尾
     *@Date 22:03 2019/6/4
     *@Param [element] 插入元素
     *@Return void
     *@Throws
     **/
    public void inQueue(String element);

    /*---------------------------------------分割线-----------------------------------------**/
    /*
     *@Author YH
     *@Description 从队列头部取出第一个元素
     *@Date 22:04 2019/6/4
     *@Param []
     *@Return java.lang.String 队头元素
     *@Throws
     **/
    public String outQueue();

    /*---------------------------------------分割线-----------------------------------------**/
    /*
     *@Author YH
     *@Description 获得队列长度
     *@Date 22:25 2019/6/4
     *@Param []
     *@Return int  返回队列长度
     *@Throws
     **/
    public int size();
}
