package Stack.LinkedStack;

/**
 * @ClassName Node
 * @Description  链式存储结构结点
 * @Author YH
 * @Date 2019/5/27 10:09
 * @Version 1.0
 **/

public class Node {
    /*结点中存放的内容*/
    private String context;
    
    /*指向下一个结点的指针*/
    private Node pointerToNext;
    
    /*
     * @Description: 构造函数
     * @Param: []
    **/  
    public Node(){}
    
    /*
     * @Description: 构造函数
     * @Param: [context, nextNode] [结点内容,结点指向的下一个结点]
    **/  
    public Node(String context,Node nextNode) {
        this.context = context;
        pointerToNext = nextNode;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Node getPointerToNext() {
        return pointerToNext;
    }

    public void setPointerToNext(Node pointerToNext) {
        this.pointerToNext = pointerToNext;
    }
}
