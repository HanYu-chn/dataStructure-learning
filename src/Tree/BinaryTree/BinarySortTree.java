/**
 * projectName: dataStructure-Learning
 * fileName: BinarySortTree.java
 * packageName: Tree.BinaryTree
 * date: 2019-08-26 14:35
 * copyright(c) HanYu
 */
package Tree.BinaryTree;

/**
 * @version: V1.0
 * @author: HanYu
 * @interfaceName: BinarySortTree
 * @packageName: Tree.BinaryTree
 * @description: 二叉排序树接口
 * @data: 2019-08-26 14:35
 **/
public interface BinarySortTree {
    /**
     * @title: searchBST
     * @description: 搜索二叉排序树
     * @author: HanYu
     * @date: 2019-08-26 13:16
     * @param data 搜索数据
     * @return: boolean
     * @throws:
     */
    boolean searchBST(char data);
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
    boolean insertBST(char data);

    /*---------------------------------------分割线-----------------------------------------**/
    boolean deleteBST(char data);
}