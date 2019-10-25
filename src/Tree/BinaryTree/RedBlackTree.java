/**
 * projectName: TestDemo
 * fileName: RedBlackTree.java
 * packageName: Tree
 * date: 2019-10-22 19:51
 * copyright(c) HanYu
 */
package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version: V1.0
 * @author: HanYu
 * @className: RedBlackTree
 * @packageName: Tree
 * @description:
 * @data: 2019-10-22 19:51
 **/
public class RedBlackTree {
    /*---------------------------------------分割线-----------------------------------------**/
    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        for (int i = 0; i < 10; i++) {
            redBlackTree.insert(i);
        }
        redBlackTree.delete(redBlackTree.getNode(5));
        redBlackTree.printTree();
        System.out.println("end");
    }

    /*---------------------------------------分割线-----------------------------------------**/
    public static Node root;

    private class Node {
        int val;
        Node leftChild;
        Node rightChild;
        Node parent;
        boolean isRed;

        public Node(int val) {
            this.val = val;
        }
    }

    public void insert(int element) {
        if (root == null) {
            root = new Node(element);
        } else if (root.val >= element && root.leftChild != null) {
            insertRecursion(root.leftChild, element);
        } else if (root.val >= element && root.leftChild == null) {
            root.leftChild = new Node(element);
            root.leftChild.isRed = true;
            root.leftChild.parent = root;
        } else if (root.val < element && root.rightChild != null) {
            insertRecursion(root.rightChild, element);
        } else {
            root.rightChild = new Node(element);
            root.rightChild.isRed = true;
            root.rightChild.parent = root;
        }
    }

    /*---------------------------------------分割线-----------------------------------------**/
    /*---------------------------------------分割线-----------------------------------------**/
    private Node findBottomLeftNode(Node root) {
        if (root == null) return null;
        if (root.leftChild == null) {
            return root;
        } else {
            return findBottomLeftNode(root.leftChild);
        }
    }

    /*---------------------------------------分割线-----------------------------------------**/
    private void insertRecursion(Node parentNode, int element) {
        if (parentNode == null) return;
        if (parentNode.val >= element && parentNode.leftChild != null) {
            insertRecursion(parentNode.leftChild, element);
            return;
        }
        if (parentNode.val < element && parentNode.rightChild != null) {
            insertRecursion(parentNode.rightChild, element);
            return;
        }
        if (parentNode.val >= element && parentNode.leftChild == null) {
            parentNode.leftChild = new Node(element);
            parentNode.leftChild.isRed = true;
            parentNode.leftChild.parent = parentNode;
            changeStructure(parentNode.leftChild);
            return;
        }
        if (parentNode.val < element && parentNode.rightChild == null) {
            parentNode.rightChild = new Node(element);
            parentNode.rightChild.isRed = true;
            parentNode.rightChild.parent = parentNode;
            changeStructure(parentNode.rightChild);
            return;
        }
    }

    /*---------------------------------------分割线-----------------------------------------**/
    private void changeStructure(Node newNode) {
        if (newNode == null) return;
        //若无父结点,则为根结点
        if (newNode.parent == null) {
            newNode.isRed = false;
            root = newNode;
            return;
        }
        Node parentNode = newNode.parent;
        Node grandParentNode = parentNode.parent;
        //若parent结点为黑色结点,则直接添加
        if (parentNode.isRed == false) return;
        //若parent结点为红色结点,并且其兄弟结点也为红色
        if ((grandParentNode.leftChild != null && grandParentNode.leftChild.isRed == true)
                && (grandParentNode.rightChild != null && grandParentNode.rightChild.isRed == true)) {
            grandParentNode.leftChild.isRed = false;
            grandParentNode.rightChild.isRed = false;
            grandParentNode.isRed = true;
            changeStructure(grandParentNode);
        } else { //若parent结点为红色结点,并且其兄弟结点为黑色或空结点(也认为是黑色)
            boolean isLeftChild;
            boolean parentIsLeftChild;
            isLeftChild = parentNode.leftChild == newNode;
            parentIsLeftChild = grandParentNode.leftChild == parentNode;
            //左左情况
            if (isLeftChild && parentIsLeftChild) {
                parentNode.isRed = false;
                grandParentNode.isRed = true;
                rightRotation(grandParentNode);
                //changeStructure(parentNode);
            }
            //右右情况
            if (!isLeftChild && !parentIsLeftChild) {
                parentNode.isRed = false;
                grandParentNode.isRed = true;
                leftRotation(grandParentNode);
                //changeStructure(parentNode);
            }
            //左右情况
            if (!isLeftChild && parentIsLeftChild) {
                leftRotation(parentNode);
                newNode.isRed = false;
                grandParentNode.isRed = true;
                rightRotation(grandParentNode);
                //changeStructure(newNode);
            }
            //右左情况
            if (isLeftChild && !parentIsLeftChild) {
                rightRotation(parentNode);
                newNode.isRed = false;
                grandParentNode.isRed = true;
                leftRotation(grandParentNode);
                //changeStructure(newNode);
            }
        }
    }

    /*---------------------------------------分割线-----------------------------------------**/
    private void leftRotation(Node rotationNode) {
        if (rotationNode == null || rotationNode.rightChild == null) return;
        Node topNode = rotationNode.rightChild;
        Node discardNode = topNode.leftChild;
        Node oldParentNode = rotationNode.parent;
        if (discardNode != null) discardNode.parent = rotationNode;
        rotationNode.rightChild = discardNode;
        rotationNode.parent = topNode;
        topNode.leftChild = rotationNode;
        topNode.parent = oldParentNode;
        if (oldParentNode != null) {
            boolean isLeftChild = oldParentNode.leftChild == rotationNode;
            if (isLeftChild) {
                oldParentNode.leftChild = topNode;
            } else {
                oldParentNode.rightChild = topNode;
            }
        }
        if (topNode.parent == null) {
            root = topNode;
        }
    }

    /*---------------------------------------分割线-----------------------------------------**/
    private void rightRotation(Node rotationNode) {
        if (rotationNode == null || rotationNode.leftChild == null) return;
        Node topNode = rotationNode.leftChild;
        Node discardNode = topNode.rightChild;
        Node oldParentNode = rotationNode.parent;
        rotationNode.leftChild = discardNode;
        if (discardNode != null) discardNode.parent = rotationNode;
        topNode.rightChild = rotationNode;
        rotationNode.parent = topNode;
        topNode.parent = oldParentNode;
        if (oldParentNode != null) {
            boolean isLeftChild = oldParentNode.leftChild == rotationNode;
            if (isLeftChild) {
                oldParentNode.leftChild = topNode;
            } else {
                oldParentNode.rightChild = topNode;
            }
        }
        if (topNode.parent == null) {
            root = topNode;
        }
    }

    /*---------------------------------------分割线-----------------------------------------**/
    public void delete(Node node) {
        if (node == null) return;
        //有两个子孩子
        if (node.leftChild != null && node.rightChild != null) {
            Node trueDeleteNode = null;
            for (trueDeleteNode = node.rightChild; trueDeleteNode.leftChild != null; trueDeleteNode = trueDeleteNode.leftChild)
                ;
            node.val = trueDeleteNode.val;
            //找到后继结点,递归调用,实际只会执行一次递归.
            delete(trueDeleteNode);
            return;
        }
        //只有一个孩子
        if ((node.leftChild == null && node.rightChild != null)
            || (node.rightChild == null && node.leftChild != null)) {
            //此时node结点必为黑色,node的子孩子必为红色
            Node parent = node.parent;
            Node child = node.leftChild == null ? node.rightChild : node.leftChild;
            child.isRed = false;
            if (parent == null) { //此时待删除结点为根结点
                root = child;
            } else { //非根结点
                boolean isLeft = parent.leftChild == node;
                if (isLeft) {
                    parent.leftChild = child;
                    child.parent = parent;
                } else {
                    parent.rightChild = child;
                    child.parent = parent;
                }
            }
            return; //只有一个孩子的情况处理完毕,结束.
        }
        //无孩子
        if (node.leftChild == null && node.rightChild == null) {
            //无孩子结点,且为根结点,则直接删除
            Node parent = node.parent;
            if (parent == null) {
                root = null;
                return;
            }
            boolean isLeft = parent.leftChild == node;
            //先把待删除结点删掉
            if (isLeft) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            //无孩子结点,且自身为红时,可直接删除
            if (node.isRed == true) return; //无孩子结点,且自身为红,结束.
            //无孩子结点,且自身为黑时
            if (node.isRed == false) {
                if(isLeft) {
                    deleteRecursion(null, parent, true); //因为删除结点无子孩子,所以删除后替上来的结点为null
                } else {
                    deleteRecursion(null, parent, false); //因为删除结点无子孩子,所以删除后替上来的结点为null
                }
                return;
            }
        }
    }
    /*---------------------------------------分割线-----------------------------------------**/
    private void deleteRecursion(Node replace, Node parent, boolean isLeft) {
        //replace为删除结点后替换上来的结点;
        //或者在删除结点,兄弟结点,兄弟的两孩子结点,父结点都为黑色情况时,将兄弟结点置红色,此时的父结点即可看作replace结点.
        if(replace == root) return; //已是root,不需要平衡
        //replace为parent结点的左孩子时,右结点时逻辑一样,旋转等方法是其镜像

        //按逻辑,此处的repalce结点必为黑色
        if(isLeft) {
            Node brother = parent.rightChild;
            //父为红色,兄,兄孩子全黑
            if(brother.isRed == false && parent.isRed == true
               && (brother.leftChild == null || !brother.leftChild.isRed)
               && (brother.rightChild == null || !brother.rightChild.isRed)) {
               parent.isRed = false;
               brother.isRed = true;
               return;  //平衡掉了,结束
            }
            //父颜色随意,兄黑色,左孩子为红色,右孩子随意
            if(brother.isRed == false && brother.leftChild != null && brother.leftChild.isRed) {
                Node leftChild = brother.leftChild;
                brother.leftChild = leftChild.rightChild;
                if(leftChild.rightChild != null) leftChild.rightChild.parent = brother;
                parent.rightChild = leftChild;
                leftChild.parent = parent;
                leftChild.rightChild = brother;
                brother.parent = leftChild;
                leftRotation(parent);
                //涂色
                leftChild.isRed = parent.isRed;
                parent.isRed = false;
                return; //平衡掉了,结束
            }
            //父颜色随意,兄黑色,左孩子随意(因为有上面的判断,这里只能是黑色),右孩子为红
            if(brother.isRed == false && brother.rightChild != null && brother.rightChild.isRed) {
                Node rightChild = brother.rightChild;
                leftRotation(parent);
                //涂色
                rightChild.isRed = false;
                brother.isRed = parent.isRed;
                parent.isRed = false;
                return; //平衡掉了,结束
            }
            //父,兄,兄孩子全黑
            if(brother.isRed == false && parent.isRed == false
                    && (brother.leftChild == null || !brother.leftChild.isRed)
                    && (brother.rightChild == null || !brother.rightChild.isRed)) {
                brother.isRed = true;
                boolean isLeftChild = parent.parent.leftChild == parent;
                deleteRecursion(parent,parent.parent,isLeftChild);
                return; //递归完就平衡掉了,结束
            }
            //上述四个条件走完,即为兄弟为黑情况下的全集.(变量:父,兄,兄孩子的颜色)
            //兄弟为红色时
            if(brother.isRed == true) {
                leftRotation(parent);
                //涂色
                brother.isRed = false;
                parent.rightChild.isRed = true;
                return; //平衡掉了,结束
            }
            //到此处,即replace为黑色结点时(且replace必为黑色结点),父,兄,兄孩子的所有情况都分析完了.
        } else {
            //replace为右孩子时
            Node brother = parent.leftChild;
            //父为红色,兄,兄孩子全黑
            if(brother.isRed == false && parent.isRed == true
                    && (brother.leftChild == null || !brother.leftChild.isRed)
                    && (brother.rightChild == null || !brother.rightChild.isRed)) {
                parent.isRed = false;
                brother.isRed = true;
                return;  //平衡掉了,结束
            }
            //父颜色随意,兄黑色,右孩子为红色,左孩子随意
            if(brother.isRed == false && brother.rightChild != null && brother.rightChild.isRed) {
                Node rightChild = brother.rightChild;
                brother.rightChild = rightChild.leftChild;
                if(rightChild.leftChild != null) rightChild.leftChild.parent = brother;
                rightChild.leftChild = brother;
                brother.parent = rightChild;
                parent.leftChild = rightChild;
                rightChild.parent = parent;

                rightRotation(parent);
                //涂色
                rightChild.isRed = parent.isRed;
                parent.isRed = false;
                return; //平衡掉了,结束
            }
            //父颜色随意,兄黑色,右孩子随意(因为有上面的判断,这里只能是黑色),左孩子为红
            if(brother.isRed == false && brother.leftChild != null && brother.leftChild.isRed) {
                Node leftChild = brother.leftChild;
                rightRotation(parent);
                //涂色
                leftChild.isRed = false;
                brother.isRed = parent.isRed;
                parent.isRed = false;
                return; //平衡掉了,结束
            }
            //父,兄,兄孩子全黑
            if(brother.isRed == false && parent.isRed == false
                    && (brother.leftChild == null || !brother.leftChild.isRed)
                    && (brother.rightChild == null || !brother.rightChild.isRed)) {
                brother.isRed = true;
                boolean isLeftChild = parent.parent.leftChild == parent;
                deleteRecursion(parent,parent.parent,isLeftChild);
                return; //递归完就平衡掉了,结束
            }
            //上述四个条件走完,即为兄弟为黑情况下的全集.(变量:父,兄,兄孩子的颜色)
            //兄弟为红色时
            if(brother.isRed == true) {
                rightRotation(parent);
                //涂色
                brother.isRed = false;
                parent.leftChild.isRed = true;
                return; //平衡掉了,结束
            }
            //到此处,即replace为黑色结点时(且replace必为黑色结点),父,兄,兄孩子的所有情况都分析完了.
        }
        //到此处,即replace为黑色结点时,是parent的左右孩子的情况都分析完了.
    }
    /*---------------------------------------分割线-----------------------------------------**/
    public Node getNode(int value) {
        Node currentNode = root;
        while(currentNode != null) {
            if(currentNode.val == value) return currentNode;
            if(currentNode.val < value) currentNode = currentNode.rightChild;
            if(currentNode.val > value) currentNode = currentNode.leftChild;
        }
        return null;
    }
    /*---------------------------------------分割线-----------------------------------------**/
    public void printTree() {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        Node currentNode = root;
        boolean oneFloor = true;
        queue.add(null);
        while(currentNode != null) {
            if(currentNode.leftChild != null) queue.add(currentNode.leftChild);
            if(currentNode.rightChild != null) queue.add(currentNode.rightChild);
            if(currentNode.parent != null) {
                builder.append("父").append(currentNode.parent.val).append(currentNode.isRed == true ? "红" : "黑").append(currentNode.val).append("--");
            } else {
                builder.append(currentNode.isRed == true ? "红" : "黑").append(currentNode.val).append("--");

            }
            if(queue.peek() == null) {
                queue.poll();
                queue.add(null);
                builder.append("\n");
            }
            currentNode = queue.poll();
        }
        System.out.println(builder.toString());
    }
}