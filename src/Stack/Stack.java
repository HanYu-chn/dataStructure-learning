package Stack;

/**
 * @InterfaceName Stack
 * @Description  栈的接口,存储类型为String型.
 * @Author YH
 * @Date 2019/5/26 22:20
 * @Version 1.0
 **/
public interface Stack {
    /*
     *@Author YH
     *@Description 栈的清空方法接口
     *@Date 22:26 2019/5/26
     *@Param []
     *@Return void
     *@Throws        
     **/
    public void clear();

    /*
     *@Author YH
     *@Description 判断栈是否为空的方法接口
     *@Date 22:32 2019/5/26
     *@Param []
     *@Return boolean true表示栈空,false表示栈不为空
     *@Throws
     **/
    public boolean isEmpty();

    /*
     *@Author YH
     *@Description 获取栈顶元素的方法接口
     *@Date 22:45 2019/5/26
     *@Param []
     *@Return java.lang.String 返回栈顶元素
     *@Throws
     **/
    public String getTop();

    /*
     *@Author YH
     *@Description 将元素压入栈中的方法接口
     *@Date 22:46 2019/5/26
     *@Param [element] 压入栈中的元素
     *@Return void
     *@Throws
     **/
    public void push(String element);

    /*
     *@Author YH
     *@Description 将栈顶元素弹出的方法接口
     *@Date 22:47 2019/5/26
     *@Param []
     *@Return java.lang.String 弹出的元素
     *@Throws
     **/
    public String pop();

    /*
     *@Author YH
     *@Description 获取栈中存储元素个数的方法接口
     *@Date 22:48 2019/5/26
     *@Param []
     *@Return int 栈中存储元素个数
     *@Throws
     **/
    public int size();
}
