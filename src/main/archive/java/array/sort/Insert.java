package array.sort;

import array.utils.SortUtils;

/**
 * @author vission.lu 插入排序，范围逐渐变大的冒泡排序
 * @date 2022/3/10 11:22 PM
 */
public class Insert {

    /**
     * 抓牌，越抓越多，抓一张牌，排序一次
     *
     * @param arr 待排序数组
     */
    public static void insertSorting(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) { //遍历数组
            //手上的牌范围逐渐变大 新抓的牌从手上最后的牌开始比较，如果小交换位置
            //类似于冒泡，冒上去直至处于最小的位置
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    SortUtils.swap(arr, j + 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.getArr(10);
        SortUtils.printlnArr(arr);
        Insert.insertSorting(arr);
        SortUtils.printlnArr(arr);
    }


}
