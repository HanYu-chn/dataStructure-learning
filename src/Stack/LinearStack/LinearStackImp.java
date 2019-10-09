package Stack.LinearStack;

import Stack.Stack;

/**
 * @ClassName LinearStackImp
 * @Description 顺序存储结构的栈,存储类型为String型.
 * @Author YH
 * @Date 2019/5/26 22:50
 * @Version 1.0
 **/
public class LinearStackImp implements Stack {

    /*栈默认大小*/
    private final int DEFAULTSIZE = 10;

    /*当前栈的最大容量*/
    private int currentMaxSize = DEFAULTSIZE;

    /*栈容器*/
    private String[] stack = new String[DEFAULTSIZE];

    /*栈顶指针*/
    private int topPointer = -1;

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
        stack = new String[DEFAULTSIZE];
        currentMaxSize = DEFAULTSIZE;
        topPointer = 0;
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
        if(topPointer == 0) {
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
        if(topPointer > 0) {
            return stack[topPointer];
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
        if(currentMaxSize == topPointer + 1){
            currentMaxSize = currentMaxSize + 5;
            String[] temp = stack;
            stack = new String[currentMaxSize];
            for(int i = 0; i < temp.length; i++) {
                stack[i] = temp[i];
            }
            topPointer++;
            stack[topPointer] = element;
        } else {
            topPointer++;
            stack[topPointer] = element;
        }
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
        if(topPointer > -1) {
            return stack[topPointer--];
        }
        return null;
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
        return topPointer + 1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String s : stack) {
            builder.append(s);
            builder.append("-");
        }
        return builder.toString();
    }
}
