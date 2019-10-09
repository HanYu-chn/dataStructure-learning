/**
 * projectName: dataStructure-Learning
 * fileName: BalanceBinaryTree.java
 * packageName: Tree.BinaryTree
 * date: 2019-08-27 12:50
 * copyright(c) HanYu
 */
package Tree.BinaryTree;

/**
 * @version: V1.0
 * @author: HanYu
 * @interfaceName: BalanceBinaryTree
 * @packageName: Tree.BinaryTree
 * @description: 平衡二叉树
 * @data: 2019-08-27 12:50
 **/
public interface BalanceBinaryTree {
    /**
     * @title: insert
     * @description: 平衡二叉树的插入操作
     * @author: HanYu
     * @date: 2019-08-27 14:31
     * @param value  插入的值
     * @return: void
     * @throws:
     */
    public void insert(char value);
    /*---------------------------------------分割线-----------------------------------------**/
    public int height();
}