package Tree.BinaryTree;

import java.util.Arrays;

/**
 * @ClassName BinaryTreeImpl
 * @Description   二叉树
 * @Author YH
 * @Date 2019/6/9 21:36
 * @Version 1.0
 **/

public class BinaryTreeImpl implements BinaryTree {

    /*二叉树根结点的引用*/
    protected Node rootNode;

    /*构建二叉树时结点计数*/
    private int count;
    /*---------------------------------------分割线-----------------------------------------**/
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
    @Override
    public void createTreeByPreAndInOrder(String preContent, String inContent) {
        rootNode = createTreeByPreAndInOrder(preContent.toCharArray(), inContent.toCharArray());
    }
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
    @Override
    public void createTreeByPreOrder(String content) throws Exception {
        if(content == null) {
            throw new Exception("构建内容为空");
        }
        rootNode = createTreeByPreOrder(content.toCharArray());
    }
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
    @Override
    public void createTreeByPostOrder(String content) throws Exception {
        if(content == null) {
            throw new Exception("构建内容为空");
        }
        count = content.toCharArray().length - 1;
        rootNode = createTreeByPostOrder(content.toCharArray());
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 清空树
     *@Date 14:16 2019/6/9
     *@Param []
     *@Return void
     *@Throws
     */
    @Override
    public void clear() {
        rootNode = null;
        count = 0;
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 判断树是否为空
     *@Date 14:34 2019/6/9
     *@Param []
     *@Return boolean true表示为空,false表示不为空
     *@Throws
     */
    @Override
    public boolean isEmpty() {
        if(rootNode == null) {
            return true;
        }
        return false;
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 获取树的深度
     *@Date 14:35 2019/6/9
     *@Param []
     *@Return int  返回树的深度
     *@Throws
     */
    @Override
    public int depth() {
        return depth(rootNode);
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description  获得树的根结点
     *@Date 14:36 2019/6/9
     *@Param []
     *@Return Tree.Node 树的根结点
     *@Throws Exception:树空,不存在根结点异常
     */
    @Override
    public Node root() throws Exception {
        if(rootNode == null) {
            throw new Exception("树空,不存在根结点异常");
        }
        return rootNode;
    }
    /*---------------------------------------分割线-----------------------------------------**/

    public Node getRootNode() {
        return rootNode;
    }
    /*---------------------------------------分割线-----------------------------------------**/
    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 在指定结点的指定度上插入子树
     *@Date 14:41 2019/6/9
     *@Param [childTree, targetNode, childType] 待插入的子树,指定结点,子树类型(left,right)
     *@Return void
     *@Throws  Exception:指定结点不存在异常,指定度不合理异常
     */
    @Override
    public void insert(BinaryTreeImpl childBinaryTreeImpl, Node targetNode, String childType) throws Exception {
        check(childBinaryTreeImpl,targetNode,childType);
        Node rootNode = childBinaryTreeImpl.getRootNode();
        if("left".equals(childType)) {
            targetNode.setLeftChildNode(rootNode);
        }
        if("right".equals(childType)) {
            targetNode.setRightChildNode(rootNode);
        }
        rootNode.setParentNode(targetNode);
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 在指定结点的指定度上插入子树
     *@Date 14:41 2019/6/9
     *@Param [childTree, targetNode] 待插入的结点,指定结点,子树类型(left,right)
     *@Return void
     *@Throws  Exception:指定结点不存在异常,指定度不合理异常
     */
    @Override
    public void insert(Node childNode, Node targetNode, String childType) throws Exception {
        check(childNode,targetNode,childType);
        if("left".equals(childType)) {
            targetNode.setLeftChildNode(childNode);
        }
        if("right".equals(childType)) {
            targetNode.setRightChildNode(childNode);
        }
        childNode.setParentNode(targetNode);
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 前序遍历
     *@Date 23:39 2019/6/9
     *@Param [rootNode] 根结点
     *@Return void
     *@Throws
     */
    @Override
    public void preorderTraverse(Node rootNode) {
        int i = 0;
        if (rootNode == null) {
            return;
        }
        System.out.print(rootNode.getContent());
        preorderTraverse(rootNode.getLeftChildNode());
        preorderTraverse(rootNode.getRightChildNode());
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 中序遍历
     *@Date 23:39 2019/6/9
     *@Param [rootNode] 根结点
     *@Return void
     *@Throws
     */
    @Override
    public void inorderTraverse(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        inorderTraverse(rootNode.getLeftChildNode());
        System.out.print(rootNode.getContent());
        inorderTraverse(rootNode.getRightChildNode());
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description 后序遍历
     *@Date 23:39 2019/6/9
     *@Param [rootNode] 根结点
     *@Return String
     *@Throws
     */
    @Override
    public void postorderTraverse(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        postorderTraverse(rootNode.getLeftChildNode());
        postorderTraverse(rootNode.getRightChildNode());
        System.out.print(rootNode.getContent());
        String temp = null;
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: nodesNum
     * @description: 获得结点总数
     * @author: HanYu
     * @date: 2019-08-22 11:25
     * @param
     * @return: int 结点总数
     * @throws:
     */
    @Override
    public int nodesNum() {
        if(rootNode == null) {
            return 0;
        }
        return nodesNum(rootNode.getLeftChildNode()) + nodesNum(rootNode.getRightChildNode()) + 1;
    }
    /*---------------------------------------分割线-----------------------------------------**/

    /**
     * @title: leafNodesNum
     * @description: 获取叶子结点总数
     * @author: HanYu
     * @date: 2019-08-22 12:19
     * @param
     * @return: int 叶子结点总数
     * @throws:
     */
    @Override
    public int leafNodesNum() {
        if (rootNode == null) {
            return 0;
        }
        if(rootNode.getRightChildNode() == null && rootNode.getLeftChildNode() == null) {
            return 1;
        }
        return leafNodesNum(rootNode.getLeftChildNode()) + leafNodesNum(rootNode.getRightChildNode());
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: numOfLevelNodes
     * @description: 获取树第n层上结点个数
     * @author: HanYu
     * @date: 2019-08-22 13:16
     * @param floorNum  树的第几层
     * @return: int  树第n层上结点个数
     * @throws: Exception 输入层数超过树的最大深度时抛出异常
     */
    @Override
    public int numOfLevelNodes(int floorNum) throws Exception {
        if(rootNode == null) {
            return 0;
        }
        if(floorNum > depth()) {
            throw new Exception("层数超过树的最大深度");
        }
        if(floorNum == 1) {
            return 1;
        }
        return numOfLevelNodes(rootNode.getRightChildNode(),floorNum - 1)
                + numOfLevelNodes(rootNode.getLeftChildNode(),floorNum - 1);
    }

    /*---------------------------------------分割线-----------------------------------------**/
    @Override
    public void delete(Node targetNode, int i) throws Exception {

    }
    /*---------------------------------------分割线-----------------------------------------**/
    @Override
    public void delete(BinaryTreeImpl childBinaryTreeImpl) throws Exception {

    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description  检测插入子树,目标结点,插入位置是否合法
     *@Date 22:50 2019/6/9
     *@Param [childNode, targetNode, childType]
     *       [待插入的子树,目标结点,子结点类型]
     *@Return void
     *@Throws  Exception
     */
    private void check(BinaryTreeImpl childBinaryTreeImpl, Node targetNode, String childType) throws Exception{
        if(targetNode == null) {
            throw new Exception("目标结点不存在");
        }
        if("left".equals(childType) != true && "right".equals(childType) != true) {
            throw new Exception("子树类型不正确,应填写left或者right");
        }
        if(childBinaryTreeImpl == null || childBinaryTreeImpl.getRootNode() == null) {
            throw new Exception("二叉子树不存在");
        }
        if("left".equals(childType) == true && targetNode.getLeftChildNode() != null) {
            throw new Exception("目标结点已有左子树");
        }
        if("right".equals(childType) == true && targetNode.getRightChildNode() != null) {
            throw new Exception("目标结点已有右子树");
        }
    }
/*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description  检测插入结点,目标结点,插入位置是否合法
     *@Date 22:50 2019/6/9
     *@Param [childNode, targetNode, childType]
     *       [待插入的子结点,目标结点,子结点类型]
     *@Return void
     *@Throws  Exception
     */
    private void check(Node childNode, Node targetNode, String childType) throws Exception{
        if(targetNode == null) {
            throw new Exception("目标结点不存在");
        }
        if("left".equals(childType) != true && "right".equals(childType) != true) {
            throw new Exception("子结点类型不正确,应填写left或者right");
        }
        if(childNode == null) {
            throw new Exception("子节点不存在");
        }
        if("left".equals(childType) == true && targetNode.getLeftChildNode() != null) {
            throw new Exception("目标结点已有左孩子结点");
        }
        if("right".equals(childType) == true && targetNode.getRightChildNode() != null) {
            throw new Exception("目标结点已有右孩子结点");
        }
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     *@Author YH
     *@Description  获取以给定结点为根的子树的深度
     *@Date 22:49 2019/6/9
     *@Param [tempNode] 子树的根
     *@Return int 子树的深度
     *@Throws
     */
    private int depth(Node tempNode) {
        if(tempNode == null) {
            return 0;
        } else {
            return Math.max(depth(tempNode.getLeftChildNode()),depth(tempNode.getRightChildNode())) + 1;
        }
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: nodesNum
     * @description: 获得结点总数
     * @author: HanYu
     * @date: 2019-08-22 11:33
     * @param treeRoot  树的根结点
     * @return: int 结点总数
     * @throws:
     */
    private int nodesNum(Node treeRoot) {
        if(treeRoot == null) {
            return 0;
        }
        return nodesNum(treeRoot.getLeftChildNode()) + nodesNum(treeRoot.getRightChildNode()) + 1;
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: leafNodesNum
     * @description: 获取叶子结点总数
     * @author: HanYu
     * @date: 2019-08-22 12:22
     * @param treeRoot 树的根结点
     * @return: int 叶子结点总数
     * @throws:
     */
    private int leafNodesNum(Node treeRoot) {
        if(treeRoot == null) {
            return 0;
        }
        if(treeRoot.getRightChildNode() == null && treeRoot.getLeftChildNode() == null) {
            return 1;
        }
        return leafNodesNum(treeRoot.getLeftChildNode()) + leafNodesNum(treeRoot.getRightChildNode());
    }
    /*---------------------------------------分割线-----------------------------------------**/

    /**
     * @param floorNum 树的第几层
     * @title: numOfLevelNodes
     * @description: 获取树第n层上结点个数
     * @author: HanYu
     * @date: 2019-08-22 13:16
     * @return: int  树第n层上结点个数
     * @throws:
     */
    private int numOfLevelNodes(Node treeRoot, int floorNum) {
        if(treeRoot == null || floorNum < 1) {
            return 0;
        }
        if (floorNum == 1) {
            return 1;
        }
        return numOfLevelNodes(treeRoot.getLeftChildNode(),floorNum - 1)
                + numOfLevelNodes(treeRoot.getRightChildNode(),floorNum - 1);
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: createTreeByPreOrder
     * @description: 通过前序构造二叉树
     * @author: HanYu
     * @date: 2019-08-22 14:02
     * @param content 字符串中每个字符为结点内容,其中'#'为 null
     * @return:
     * @throws: Exception 当输入参数为空或null时,抛出异常
     */
    private Node createTreeByPreOrder(char[] content) throws Exception {
        if(content == null || "".equals(content)) {
            throw new Exception("构建内容为空");
        }
        if (count > content.length - 1 || content[count] == '#') {
            return null;
        }
        Node node = new Node(content[count]);
        count++;
        node.setLeftChildNode(createTreeByPreOrder(content));
        count++;
        node.setRightChildNode(createTreeByPreOrder(content));
        return node;
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: createTreeByPostOrder
     * @description: 通过后序构造二叉树
     * @author: HanYu
     * @date: 2019-08-22 14:02
     * @param content 字符串中每个字符为结点内容,其中'#'为 null
     * @return:
     * @throws: Exception 当输入参数为空或null时,抛出异常
     */
    private Node createTreeByPostOrder(char[] content) throws Exception {
        if(content == null || "".equals(content)) {
            throw new Exception("构建内容为空");
        }
        if (count < 0 || content[count] == '#') {
            return null;
        }
        Node node = new Node(content[count]);
        count--; //注:后序遍历创建,可以从字符串的末位往前读,即根结点->右孩子->左孩子
        node.setRightChildNode(createTreeByPostOrder(content));
        count--;
        node.setLeftChildNode(createTreeByPostOrder(content));
        return node;
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: createTreeByPreAndInOrder
     * @description: 通过前序和中序构造二叉树
     * @author: HanYu
     * @date: 2019-10-09 18:03
     * @param preContent 前序序列
     * @param inContent  后序序列
     * @return: Node
     * @throws:
     */
    private Node createTreeByPreAndInOrder(char[] preContent, char[] inContent) {
        if (preContent == null || inContent == null || preContent.length == 0 || inContent.length == 0) return null;
        Node node = new Node(preContent[0]);
        for (int i = 0; i < inContent.length; i++) {
            if(preContent[0] == inContent[i]) {
                node.setLeftChildNode(createTreeByPreAndInOrder(Arrays.copyOfRange(preContent,1,i + 1),Arrays.copyOfRange(inContent,0,i)));
                node.setRightChildNode(createTreeByPreAndInOrder(Arrays.copyOfRange(preContent,i + 1,preContent.length),Arrays.copyOfRange(inContent,i + 1,inContent.length)));
            }
        }
        return node;
    }

}
