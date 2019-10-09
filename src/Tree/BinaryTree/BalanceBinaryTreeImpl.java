/**
 * projectName: dataStructure-Learning
 * fileName: BalanceBinaryTreeImpl.java
 * packageName: Tree.BinaryTree
 * date: 2019-08-27 12:51
 * copyright(c) HanYu
 */
package Tree.BinaryTree;

/**
 * @version: V1.0
 * @author: HanYu
 * @className: BalanceBinaryTreeImpl
 * @packageName: Tree.BinaryTree
 * @description: 平衡二叉树实现类
 * @data: 2019-08-27 12:51
 **/
public class BalanceBinaryTreeImpl extends BinaryTreeImpl implements BalanceBinaryTree{
//    /*根结点*/
//    private Node rootNode;
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: insert
     * @description: 平衡二叉树的插入操作
     * @author: HanYu
     * @date: 2019-08-27 14:31
     * @param value  插入的值
     * @return: void
     * @throws:
     */
    @Override
    public void insert(char value) {
        if(rootNode == null) {
            rootNode = new Node(value);
            return;
        }
        rootNode = insertAVL(rootNode, value);
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: height
     * @description: 返回树的高度
     * @author: HanYu
     * @date: 2019-08-27 19:55
     * @param
     * @return: int  树的高度
     * @throws:
     */
    @Override
    public int height() {
        return height(rootNode);
    }

    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: insertAVL
     * @description: 二叉排序树的插入处理操作
     * @author: HanYu
     * @date: 2019-08-27 12:56
     * @param root  插入后重新形成子树的根结点
     * @return: Node 返回重新形成子树后的根结点
     * @throws:
     */
    private Node insertAVL(Node root, char value) {
        if(root == null) return root;
        if (root.getContent() > value) {
            if(root.getLeftChildNode() == null) {
                root.setLeftChildNode(new Node(value));
            } else {
                root.setLeftChildNode(insertAVL(root.getLeftChildNode(),value));
            }
            if(height(root.getLeftChildNode()) - height(root.getRightChildNode()) == 2) {
                if(root.getLeftChildNode().getContent() > value) {
                    //LL插入,执行右旋
                    return rightRotate(root);
                } else{
                    //LR插入,先左旋后右旋操作
                    return leftAndRightRotate(root);
                }
            }
        } else if(root.getContent() < value) {
            if(root.getRightChildNode() == null) {
                root.setRightChildNode(new Node(value));
            } else {
                root.setRightChildNode(insertAVL(root.getRightChildNode(),value));
            }
            if(height(root.getRightChildNode()) - height(root.getLeftChildNode()) == 2) {
                if(root.getRightChildNode().getContent() < value) {
                    //RR操作,执行左旋
                    return leftRotate(root);
                } else{
                    //RL操作,先右旋后左旋操作
                    return rightAndLeftRotate(root);
                }
            }
        } else {
            return root;
        }
//        if(root.getLeftChildNode() == null && root.getRightChildNode() != null) {
//            root.setHeight(root.getRightChildNode().getHeight() + 1);
//        } else if(root.getLeftChildNode() != null && root.getRightChildNode() == null) {
//            root.setHeight(root.getLeftChildNode().getHeight() + 1);
//        } else if(root.getLeftChildNode() != null && root.getRightChildNode() != null) {
//            root.setHeight(Math.max(root.getLeftChildNode().getHeight(),root.getRightChildNode().getHeight()) + 1);
//        } else {
//            root.setHeight(1);
//        }
//        root.setHeight(Math.max(height(root.getLeftChildNode()),height(root.getRightChildNode())) + 1);
          return root;
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: rightRotate
     * @description: 二叉排序树的右旋处理操作
     * @author: HanYu
     * @date: 2019-08-27 12:56
     * @param root  最小不平衡子树的根结点
     * @return: Node 返回旋转后的根结点
     * @throws:
     */
    private Node rightRotate(Node root) {
        if (root == null) return root;
        Node leftNode = root.getLeftChildNode();
        if(leftNode == null) return root;
        root.setLeftChildNode(leftNode.getRightChildNode());
        leftNode.setRightChildNode(root);
        root.setHeight(Math.max(height(root.getLeftChildNode()),height(root.getRightChildNode())) + 1);
        leftNode.setHeight(Math.max(height(leftNode.getLeftChildNode()),height(leftNode.getRightChildNode())) + 1);
        return leftNode;
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: leftRotate
     * @description: 二叉排序树的左旋处理操作
     * @author: HanYu
     * @date: 2019-08-27 12:56
     * @param root  最小不平衡子树的根结点
     * @return: Node 返回旋转后的根结点
     * @throws:
     */
    private Node leftRotate(Node root) {
        if (root == null) return root;
        Node rightNode = root.getRightChildNode();
        if(rightNode == null) return root;
        root.setRightChildNode(rightNode.getLeftChildNode());
        rightNode.setLeftChildNode(root);
        root.setHeight(Math.max(height(root.getLeftChildNode()),height(root.getRightChildNode())) + 1);
        rightNode.setHeight(Math.max(height(rightNode.getLeftChildNode()),height(rightNode.getRightChildNode())) + 1);
        return rightNode;
    }

    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: leftAndRightRotate
     * @description: 平衡二叉树先左旋后右旋操作
     * @author: HanYu
     * @date: 2019-08-27 19:44
     * @param root 最小不平衡子树的根结点
     * @return: Node 返回旋转后的根结点
     * @throws:
     */
    private Node leftAndRightRotate(Node root) {
        if(root == null) return root;
        root.setLeftChildNode(leftRotate(root.getLeftChildNode()));
        return rightRotate(root);
    }
    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: leftAndRightRotate
     * @description: 平衡二叉树先右旋后左旋操作
     * @author: HanYu
     * @date: 2019-08-27 19:44
     * @param root 最小不平衡子树的根结点
     * @return: Node 返回旋转后的根结点
     * @throws:
     */
    private Node rightAndLeftRotate(Node root) {
        if(root == null) return root;
        root.setRightChildNode(rightRotate(root.getRightChildNode()));
        return rightRotate(root);
    }

    /*---------------------------------------分割线-----------------------------------------**/
    /**
     * @title: height
     * @description: 获得以传入结点为根的子树的树高
     * @author: HanYu
     * @date: 2019-08-27 19:58
     * @param root  子树的根结点
     * @return: int 子树的树高
     * @throws:
     */
    private int height(Node root) {
        if(root == null) return 0;
        return Math.max(height(root.getLeftChildNode()),height(root.getRightChildNode())) + 1;
    }
}