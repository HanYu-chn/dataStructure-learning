/**
 * projectName: dataStructure-Learning
 * fileName: QuickSort.java
 * packageName: Algorithm.Sort
 * date: 2019-10-07 16:18
 * copyright(c) HanYu
 */
package Algorithm.Sort;

/**
 * @version: V1.0
 * @author: HanYu
 * @className: QuickSort
 * @packageName: Algorithm.Sort
 * @description: 快速排序
 * @data: 2019-10-07 16:18
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7,5,2,9,4,6,3,0,8,1};
        quickSort(arr,0,arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int[] content, int start, int end) {
        if(start == end) return;
        int temp = content[start];
        int lowPoint = start;
        int highPoint = end;
        boolean highMove = true;
        while(lowPoint < highPoint) {
            while(highMove && lowPoint < highPoint){
                if(content[highPoint] > temp) {
                    highPoint--;
                } else {
                    highMove = false;
                }
            }
            while(!highMove && lowPoint < highPoint){
                if(content[lowPoint] <= temp) {
                    lowPoint++;
                } else {
                    int tmp = content[lowPoint];
                    content[lowPoint] = content[highPoint];
                    content[highPoint] = tmp;
                    highMove = true;
                }
            }
        }
        if (content[lowPoint] < temp) {
            content[start] = content[lowPoint];
            content[lowPoint] = temp;
            quickSort(content, start, lowPoint);
            quickSort(content, lowPoint + 1, end);
        } else {
            quickSort(content,start + 1,end);
        }
    }

}