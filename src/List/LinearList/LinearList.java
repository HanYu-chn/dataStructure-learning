package List.LinearList;

/**
 * @ClassName LinearListCustom
 * @Description 自定义顺序存储结构的线性表, 用于存放String类型
 * @Author yuhan
 * @Date 2019/4/16 10:57
 * @Version 1.0
 **/
public class LinearList{
/**--------------------------------分割线-----------------------------------**/
    /**
     * 线性表的长度
     **/
    private int length = 0;

    /**
     * 线性表的容量
     **/
    private int tempMaxSize = 10;

    /**
     * 线性表的容器
     **/
    private String[] list = new String[tempMaxSize];
/**--------------------------------分割线-----------------------------------**/
    /**
     * @Author yuhan
     * @Description 判断线性表是否为空
     * @Date 12:29 2019/4/16
     * @Param []
     * @Return boolean
     * true:线性表为空
     * flase:线性表不为空
     * @Throws
     **/
    public boolean isEmpty() {
        if (length == 0) {
            return true;
        } else {
            return false;
        }
    }
/**--------------------------------分割线-----------------------------------**/
    /**
     *@Author yuhan
     *@Description 清空线性表
     *@Date 12:31 2019/4/16
     *@Param []
     *@Return void
     *@Throws
     **/
    public void clear() {
        list = new String[tempMaxSize];
        length = 0;
    }
/**--------------------------------分割线-----------------------------------**/
    /**
     *@Author yuhan
     *@Description 获取线性表中的元素
     *@Date 12:32 2019/4/16
     *@Param [positionID]
     * positionID:获取元素在线性表中的位置
     *@Return java.lang.String
     * String:找到时,返回该元素;
     *        找不到时,返回null;
     *@Throws
     **/
    public String getElemt(int positionID) {
        if (positionID > (length - 1) || positionID < 0) {
            return null;
        } else {
            return list[positionID];
        }
    }
/**--------------------------------分割线-----------------------------------**/
    /**
     *@Author yuhan
     *@Description 获取输入元素在线性表中第一次出现的位置,没有该元素时返回-1
     *@Date 12:37 2019/4/16
     *@Param [element]
     * element:想在线性表中查找的元素
     *@Return int
     * int:返回输入元素在线性表中第一次出现的位置;
     *     没有该元素时返回-1;
     *@Throws
     **/
    public int locateElemt(String element) {
        if (element == null) {
            return -1;
        } else {
            for (int i = 0; i < length; i++) {
                if (element.equals(list[i])) {
                    return i;
                }
            }
            return -1;
        }
    }
/**--------------------------------分割线-----------------------------------**/
    /**
     *@Author yuhan
     *@Description 返回线性表长度
     *@Date 12:39 2019/4/16
     *@Param []
     *@Return int
     * int:返回线性表长度
     *@Throws
     **/
    public int size() {
        return list.length;
    }
/**--------------------------------分割线-----------------------------------**/
    /**
     *@Author yuhan
     *@Description 在线性表中指定位置插入输入元素,若位置错误则抛出异常
     *@Date 12:42 2019/4/16
     *@Param [positionID, element]
     * positionID:插入位置
     * element:插入元素
     *@Return boolean
     * true:插入成功
     * false:插入失败
     *@Throws 当positionID不正确时,抛出Exception异常
     **/
    public boolean insert(int positionID, String element) throws Exception{
        if (positionID < 0 || positionID > length) {
            throw new Exception("插入位置不合理");
        } else {
            if (length == tempMaxSize) {
                extendSize();
                putIn(element, positionID);
            } else {
                putIn(element, positionID);
            }
            return true;
        }
    }
/**--------------------------------分割线-----------------------------------**/
    /**
     *@Author yuhan
     *@Description 在线性表中删除指定位置的元素
     *@Date 14:15 2019/4/16
     *@Param [positionID]
     * positionID:删除元素的位置
     *@Return boolean
     * true:删除成功
     * false:删除失败
     *@Throws  当输入参数positionID不正确时,抛出Exception异常
     **/
    public boolean delete(int positionID) throws Exception{
        if (positionID < 0 || positionID > (length - 1)) {
            throw new Exception("删除位置不合理");
        } else {
            deleteElement(positionID);
            return true;
        }
    }
/**--------------------------------分割线-----------------------------------**/
    /**
     *@Author yuhan
     *@Description 在线性表的末尾添加元素
     *@Date 14:25 2019/4/16
     *@Param [element]
     * element:要在线性表末尾插入的元素
     *@Return void
     *@Throws
     **/
    public void pushBack(String element){
        if(length == tempMaxSize) {
            extendSize();
            list[length] = element;
            length++;
        } else {
            list[length] = element;
            length++;
        }
    }
/**--------------------------------分割线-----------------------------------**/
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s + "-");
        }
        return stringBuilder.toString();
    }
/**--------------------------------分割线-----------------------------------**/
    /**
     * @Author yuhan
     * @Description 在线性表中插入元素时, 后面的元素依次向后排
     * @Date 12:26 2019/4/16
     * @Param [element, positionID]
     * element:插入线性表的元素
     * positionID:插入的位置
     * @Return void
     * @Throws
     **/
    private void putIn(String element, int positionID) {
        for (int i = length - 1; i >= positionID; i--) {
            list[i + 1] = list[i];
        }
        list[positionID] = element;
        length++;
    }
/**--------------------------------分割线-----------------------------------**/
    /**
     * @Author yuhan
     * @Description 在线性表中删除元素时, 后面的元素依次向前排
     * @Date 12:26 2019/4/16
     * @Param [positionID]
     * positionID:删除元素的位置
     * @Return void
     * @Throws
     **/
    private void deleteElement(int positionID) {
        for (int i = positionID; i < length; i++) {
            list[i] = list[i + 1];
        }
        list[length] = null;
        length--;
    }
/**--------------------------------分割线-----------------------------------**/
    /**
     *@Author yuhan
     *@Description 扩大容量,在其原有基础上增加5
     *@Date 14:22 2019/4/16
     *@Param []
     *@Return void
     *@Throws
     **/
    private void extendSize(){
        tempMaxSize = tempMaxSize + 5;
        String[] tempList = list;
        list = new String[tempMaxSize];
        System.arraycopy(tempList, 0, list, 0, tempList.length);
    }
}

/**--------------------------------分割线-----------------------------------**/
