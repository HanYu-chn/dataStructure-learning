/**
 * projectName: dataStructure-Learning
 * fileName: ConflationSort.java
 * packageName: Algorithm.Sort
 * date: 2019-10-07 15:48
 * copyright(c) HanYu
 */
package Algorithm.Sort;

/**
 * @version: V1.0
 * @author: HanYu
 * @className: ConflationSort
 * @packageName: Algorithm.Sort
 * @description: 归并排序
 * @data: 2019-10-07 15:48
 **/
public class ConflationSort {
    public static void main(String[] args) {
        int[] arr = {7,5,2,9,4,6,3,0,8,1};
        int[] sortedArr = conflationSort(arr,0,arr.length - 1);
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.println(sortedArr[i]);
        }
    }

    public static int[] conflationSort(int[] content,int start,int end) {
        if(start == end) {
            int[] arr = new int[1];
            arr[0] = content[start];
            return arr;
        }
        int middle = (start + end) / 2;
        int[] leftPart = conflationSort(content, start, middle);
        int[] rightPart = conflationSort(content, middle + 1, end);
        int[] mergePart = new int[end - start + 1];
        int leftCount = 0;
        int rightCount = 0;
        int mergeCount = 0;
        while (leftCount < leftPart.length && rightCount < rightPart.length) {
            if(leftPart[leftCount] <= rightPart[rightCount]) {
                mergePart[mergeCount] = leftPart[leftCount];
                mergeCount++;
                leftCount++;
            } else {
                mergePart[mergeCount] = rightPart[rightCount];
                mergeCount++;
                rightCount++;
            }
        }
        if (mergeCount < mergePart.length) {
            if(leftCount != leftPart.length) {
                for(int i = leftCount;i < leftPart.length; i++) {
                    mergePart[mergeCount] = leftPart[leftCount];
                    mergeCount++;
                    leftCount++;
                }
            }
            if(rightCount != rightPart.length) {
                for(int i = rightCount;i < rightPart.length; i++) {
                    mergePart[mergeCount] = rightPart[rightCount];
                    mergeCount++;
                    rightCount++;
                }
            }
        }
        return mergePart;
    }
}