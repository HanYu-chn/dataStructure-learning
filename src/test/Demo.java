/**
 * projectName: dataStructure-learning
 * fileName: Demo.java
 * packageName: test
 * date: 2019-10-09 18:30
 * copyright(c) HanYu
 */
package test;

import Tree.BinaryTree.BinaryTreeImpl;

/**
 * @version: V1.0
 * @author: HanYu
 * @className: Demo
 * @packageName: test
 * @description:
 * @data: 2019-10-09 18:30
 **/
public class Demo {
    public static void main(String[] args) {
        BinaryTreeImpl tree = new BinaryTreeImpl();
        tree.createTreeByPreAndInOrder("ABCDEF","CBAEDF");
        tree.inorderTraverse(tree.getRootNode());
    }
}