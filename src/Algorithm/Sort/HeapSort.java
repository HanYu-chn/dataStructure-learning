/**
 * projectName: dataStructure-Learning
 * fileName: HeapSort.java
 * packageName: Algorithm.Sort
 * date: 2019-10-07 13:44
 * copyright(c) HanYu
 */
package Algorithm.Sort;

/**
 * @version: V1.0
 * @author: HanYu
 * @className: HeapSort
 * @packageName: Algorithm.Sort
 * @description: 堆排序
 * @data: 2019-10-07 13:44
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7,5,2,9,4,6,3,0,8,1};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void sort(int[] content) {
        //初始化堆
        for(int i = content.length - 1; i >= 0; i--) {
            maxHeapBuildRecursion(content, i, content.length - 1);
        }
        //交换数组位置,并重构堆
        for (int i = content.length - 1; i > 0; i--) {
            int temp = content[0];
            content[0] = content[i];
            content[i] = temp;
            maxHeapBuildRecursion(content,0,i);
        }
    }

    private static void maxHeapBuildRecursion(int[] content,int root,int size) {
        if(root >= size) return;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        int maxIndex = root;
        if(leftChild < size && content[maxIndex] < content[leftChild]) {
            maxIndex = leftChild;
        }
        if(rightChild < size && content[maxIndex] < content[rightChild]) {
            maxIndex = rightChild;
        }
        if (maxIndex != root) {
            int temp = content[root];
            content[root] = content[maxIndex];
            content[maxIndex] = temp;
            maxHeapBuildRecursion(content,maxIndex,size);
        }
    }
}