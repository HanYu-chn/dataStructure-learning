/**
 * projectName: dataStructure-Learning
 * fileName: BinarySortTreeImpl.java
 * packageName: Tree.BinaryTree
 * date: 2019-08-26 14:37
 * copyright(c) HanYu
 */
package Tree.BinaryTree;

/**
 * @version: V1.0
 * @author: HanYu
 * @className: BinarySortTreeImpl
 * @packageName: Tree.BinaryTree
 * @description: 二叉排序树实现类
 * @data: 2019-08-26 14:37
 **/
public class BinarySortTreeImpl extends BinaryTreeImpl implements BinarySortTree {
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: searchBST
     * @description: 搜索二叉排序树
     * @author: HanYu
     * @date: 2019-08-26 13:16
     * @param data 搜索数据
     * @return: boolean
     * @throws:
     */
    @Override
    public boolean searchBST(char data) {
        return searchBST(rootNode,data);
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: insertBST
     * @description: 二叉排序树的插入操作
     * @author: HanYu
     * @date: 2019-08-26 13:44
     * @param data 待插入数据
     * @return: boolean
     * @throws:
     */
    @Override
    public boolean insertBST(char data) {
        if(rootNode == null) {
            rootNode = new Node(data);
            return true;
        }
        return insertBST(rootNode, data);
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: deleteBST
     * @description: 二叉排序树删除操作
     * @author: HanYu
     * @date: 2019-08-26 15:27
     * @param data  待删除数据
     * @return: boolean
     * @throws:
     */
    @Override
    public boolean deleteBST(char data) {
        return deleteBST(rootNode, data);
    }

    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: searchBST
     * @description: 搜索二叉排序树
     * @author: HanYu
     * @date: 2019-08-26 13:16
     * @param node 搜索的根结点
     * @param data 搜索数据
     * @return: boolean
     * @throws:
     */
    private boolean searchBST(Node node , char data) {
        if(node == null) {
            return false;
        }
        if (node.getContent() == data) {
            return true;
        } else if (node.getContent() > data) {
            return searchBST(node.getRightChildNode(), data);
        } else {
            return searchBST(node.getLeftChildNode(), data);
        }
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: insertBST
     * @description: 二叉排序树的插入操作
     * @author: HanYu
     * @date: 2019-08-26 13:44
     * @param node 插入的根结点
     * @param data 待插入数据
     * @return: boolean
     * @throws:
     */
    private boolean insertBST(Node node, char data) {
        if (node.getContent() > data) {
            if(node.getLeftChildNode() == null) {
                Node newNode = new Node(data);
                node.setLeftChildNode(newNode);
                return true;
            } else {
                return insertBST(node.getLeftChildNode(), data);
            }
        } else if (node.getContent() < data) {
            if(node.getRightChildNode() == null) {
                Node newNode = new Node(data);
                node.setRightChildNode(newNode);
                return true;
            } else {
                return insertBST(node.getRightChildNode(), data);
            }
        } else {
            return false;
        }
    }

    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: deleteBST
     * @description: 二叉树删除操作,找出是否存在待删除结点,若存在,则调用deleteByBST方法删除
     * @author: HanYu
     * @date: 2019-08-26 15:28
     * @param node 待比较所给数据是否相等的结点
     * @param data 待删除数据
     * @return: boolean
     * @throws:
     */
    private boolean deleteBST(Node node, char data) {
        if (node == null) {
            return false;
        }
        if (node.getContent() == data) {
            return deleteByBST(node);
        } else if (node.getContent() > data) {
            return deleteBST(node.getLeftChildNode(), data);
        } else {
            return deleteBST(node.getRightChildNode(), data);
        }
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: deleteBST
     * @description: 二叉树删除操作
     * @author: HanYu
     * @date: 2019-08-26 15:28
     * @param node 待删除结点
     * @return: boolean
     * @throws:
     */
    private boolean deleteByBST(Node node) {
        if(node.getRightChildNode() == null && node.getLeftChildNode() == null) {
            node = null;
            return true;
        } else if(node.getRightChildNode() == null && node.getLeftChildNode() != null) {
            node = node.getLeftChildNode();
        } else if(node.getRightChildNode() != null && node.getLeftChildNode() == null) {
            node = node.getRightChildNode();
        } else {
            Node parentNode = node;
            Node bottomNode = node.getLeftChildNode();
            while (bottomNode.getRightChildNode() != null) {
                parentNode = bottomNode;
                bottomNode = bottomNode.getRightChildNode();
            }
            node.setContent(bottomNode.getContent());
            if (parentNode == node) {
                parentNode.setLeftChildNode(bottomNode.getLeftChildNode());
            } else {
                parentNode.setRightChildNode(bottomNode.getLeftChildNode());
            }
        }
        return true;
    }
}