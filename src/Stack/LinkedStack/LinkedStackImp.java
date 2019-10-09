package Stack.LinkedStack;
import Stack.Stack;
/**
 * @ClassName LinkedStackImp
 * @Description 顺序存储结构的栈,存储类型为String型.
 * @Author YH
 * @Date 2019/5/26 10:06
 * @Version 1.0
 **/
public class LinkedStackImp implements Stack{
    /*栈的栈顶指针*/
    private Node topPointer = null;

    /*栈的大小*/
    private int size = 0;

    /*
     *@Author YH
     *@Description 栈的清空方法
     *@Date 22:26 2019/5/26
     *@Param []
     *@Return void
     *@Throws
     **/
    @Override
    public void clear() {
        topPointer = null;
        size = 0;
    }

    /*
     *@Author YH
     *@Description 判断栈是否为空的方法
     *@Date 22:32 2019/5/26
     *@Param []
     *@Return boolean true表示栈空,false表示栈不为空
     *@Throws
     **/
    @Override
    public boolean isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
     *@Author YH
     *@Description 获取栈顶元素的方法
     *@Date 22:45 2019/5/26
     *@Param []
     *@Return java.lang.String 返回栈顶元素
     *@Throws
     **/
    @Override
    public String getTop() {
        if(topPointer != null) {
            return topPointer.getContext();
        }
        return null;
    }

    /*
     *@Author YH
     *@Description 将元素压入栈中的方法
     *@Date 22:46 2019/5/26
     *@Param [element] 压入栈中的元素
     *@Return void
     *@Throws
     **/
    @Override
    public void push(String element) {
        if(element == null || element == "") {
            return;
        }
        Node newNode = new Node(element,topPointer);
        topPointer = newNode;
        size++;
    }

    /*
     *@Author YH
     *@Description 将栈顶元素弹出的方法
     *@Date 22:47 2019/5/26
     *@Param []
     *@Return java.lang.String 弹出的元素
     *@Throws
     **/
    @Override
    public String pop() {
        if(size == 0) {
            return null;
        }
        Node popNode = topPointer;
        topPointer = topPointer.getPointerToNext();
        size--;
        return popNode.getContext();
    }

    /*
     *@Author YH
     *@Description 获取栈中存储元素个数的方法
     *@Date 22:48 2019/5/26
     *@Param []
     *@Return int 栈中存储元素个数
     *@Throws
     **/
    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node traversePointer = topPointer;
        while(traversePointer != null) {
            builder.append(traversePointer.getContext());
            builder.append("-");
            traversePointer = traversePointer.getPointerToNext();
        }
        return builder.toString();
    }
}
