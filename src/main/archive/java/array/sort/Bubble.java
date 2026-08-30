package array.sort;

import array.utils.SortUtils;

/**
 * 冒泡排序
 *
 * @author vission.lu
 * @date 2022/3/10 11:22 PM
 */
public class Bubble {

    public static void bubbleSorting(int[] arr) {
        int size = arr.length - 1;
        for (int i = 0; i < size; i++) {
            //每一轮冒泡最大的都在最右边
            for (int j = 0; j < size - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtils.swap(arr, j, j + 1);
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.getArr(1000);
        SortUtils.printlnArr(arr);
        Bubble.bubbleSorting(arr);
        SortUtils.printlnArr(arr);
    }


}
