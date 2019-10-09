package Tree.BinaryTree;

/**
 * @InterfaceName Tree
 * @Description   二叉树
 * @Author YH
 * @Date 2019/6/9 14:13
 * @Version 1.0
 **/
public interface BinaryTree {
    /**
     * @title: createTreeByPreAndInOrder
     * @description: 通过前序和中序构造二叉树
     * @author: HanYu
     * @date: 2019-10-09 18:03
     * @param preContent 前序序列
     * @param inContent  后序序列
     * @return: void
     * @throws:
     */
    public void createTreeByPreAndInOrder(String preContent,String inContent);
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: createTreeByPostOrder
     * @description: 通过后序构造二叉树
     * @author: HanYu
     * @date: 2019-08-22 14:02
     * @param content 字符串中每个字符为结点内容,其中'#'为 null
     * @return:
     * @throws:  Exception 当输入参数为空或null时,抛出异常
     */
    public void createTreeByPostOrder(String content) throws Exception;
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: createTreeByPreOrder
     * @description: 通过前序构造二叉树
     * @author: HanYu
     * @date: 2019-08-22 14:02
     * @param content 字符串中每个字符为结点内容,其中'#'为 null
     * @return:
     * @throws:  Exception 当输入参数为空或null时,抛出异常
     */
    public void createTreeByPreOrder(String content) throws Exception;
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 清空树
     *@Date 14:16 2019/6/9
     *@Param []
     *@Return void
     *@Throws        
     */
    public void clear();
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 判断树是否为空
     *@Date 14:34 2019/6/9
     *@Param []
     *@Return boolean true表示为空,false表示不为空
     *@Throws        
     */
    public boolean isEmpty();
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 获取树的深度
     *@Date 14:35 2019/6/9
     *@Param []
     *@Return int  返回树的深度
     *@Throws        
     */
    public int depth();
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description  获得树的根结点
     *@Date 14:36 2019/6/9
     *@Param []
     *@Return Tree.Node 树的根结点
     *@Throws Exception:树空,不存在根结点异常   
     */
    public Node root() throws Exception;
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 在指定结点的指定度上插入子树
     *@Date 14:41 2019/6/9
     *@Param [childTree, targetNode, childType] 待插入的子树,指定结点,子树类型(left,right)
     *@Return void
     *@Throws  Exception:指定结点不存在异常,指定度不合理异常      
     */
    public void insert(BinaryTreeImpl childBinaryTreeImpl, Node targetNode, String childType) throws Exception;
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 在指定结点的指定度上插入子树
     *@Date 14:41 2019/6/9
     *@Param [childTree, targetNode] 待插入的结点,指定结点,子树类型(left,right)
     *@Return void
     *@Throws  Exception:指定结点不存在异常,指定度不合理异常
     */
    public void insert(Node childNode, Node targetNode, String childType) throws Exception;
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 删除指定结点的指定度上的子树
     *@Date 14:47 2019/6/9
     *@Param [targetNode, i] 指定结点,指定度
     *@Return void
     *@Throws Exception:指定结点不存在异常,指定度不合理异常      
     */
    public void delete(Node targetNode, int i) throws Exception;
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 删除指定子树
     *@Date 14:49 2019/6/9
     *@Param [childTree] 指定子树
     *@Return void
     *@Throws  Exception:指定子树不存在异常
     */
    public void delete(BinaryTreeImpl childBinaryTreeImpl) throws Exception;
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 前序遍历
     *@Date 23:39 2019/6/9
     *@Param [rootNode] 根结点
     *@Return void
     *@Throws
     */
    public void preorderTraverse(Node rootNode);
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 中序遍历
     *@Date 23:39 2019/6/9
     *@Param [rootNode] 根结点
     *@Return void
     *@Throws
     */
    public void inorderTraverse(Node rootNode);
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 后序遍历
     *@Date 23:39 2019/6/9
     *@Param [rootNode] 根结点
     *@Return void
     *@Throws
     */
    public void postorderTraverse(Node rootNode);

    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 结点总数
     *@Date 11:16 2019/8/22
     *@Param
     *@Return int 结点个数
     *@Throws
     */
    public int nodesNum();

    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 叶子结点总数
     *@Date 12:17 2019/8/22
     *@Param
     *@Return int 叶子结点个数
     *@Throws
     */
    public int leafNodesNum();
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 获取树第n层上结点个数
     *@Date 12:17 2019/8/22
     *@Param  floorNum 层数
     *@Return int 树第n层上结点个数
     *@Throws Exception 输入层数超过树的最大深度时抛出异常
     */
    public int numOfLevelNodes(int floorNum) throws Exception;
    /*---------------------------------------分割线-----------------------------------------**/


}
