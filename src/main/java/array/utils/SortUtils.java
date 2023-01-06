package array.utils;

import array.sort.Bubble;
import array.sort.Insert;
import array.sort.Merge;
import array.sort.Quick;
import array.sort.Selection;

/**
 * @author vission.lu 排序工具
 * @date 2022/3/17 00:24
 */
public class SortUtils {

    /**
     * 交换 亦或无进位加减法
     *
     * @param arr 数组
     * @param i   换位
     * @param j   换位
     */
    public static void swap(int[] arr, int i, int j) {
        //运用了异或的远离，所以 i != j
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 创建size大小的随机数组
     *
     * @param size 大小
     * @return 数组
     */
    public static int[] getArr(int size) {
        int[] tmp = new int[size];
        for (int i = 0; i < size; i++) {
            tmp[i] = i;
        }
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            double v = Math.random() * size;
            arr[i] = tmp[(int) v];
        }
//        printlnArr(arr);
        return arr;
    }

    /**
     * 对数器
     *
     * @author vission.lu
     * @date 2022/3/11 12:50 AM
     */
    public static void logarithm(int[] a, int[] b) throws Exception {
        if (a.length != b.length) {
            throw new Exception("a.length!=b.length");
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                throw new Exception("a.arr.sort!=b.arr.sort" + i);
            }
        }
    }

    /**
     * 打印数组
     *
     * @author vission.lu
     * @date 2022/3/17 00:22
     */
    public static void printlnArr(int[] arr) {
        for (int cur : arr) {
            System.out.print(cur + " ");
        }
        System.out.println("\n");
    }

    /**
     * 复制数组
     *
     * @author vission.lu
     * @date 2022/3/17 00:22
     */
    public static int[] copyArr(int[] arr) {
        int length = arr.length;
        int[] copyArr = new int[length];
        System.arraycopy(arr, 0, copyArr, 0, length);
        return copyArr;
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.getArr(10000);
        SortUtils.printlnArr(arr);
        int[] arrBubbleSorting = SortUtils.copyArr(arr);
        int[] arrSelectionSorting = SortUtils.copyArr(arr);
        int[] arrInsertSorting = SortUtils.copyArr(arr);
        int[] arrMergeSorting = SortUtils.copyArr(arr);
        int[] arrQuickSorting = SortUtils.copyArr(arr);
        //冒泡排序
        Bubble.bubbleSorting(arrBubbleSorting);
        SortUtils.printlnArr(arrBubbleSorting);
        //选择排序
        Selection.selectionSorting(arrSelectionSorting);
        SortUtils.printlnArr(arrSelectionSorting);
        //插入排序
        Insert.insertSorting(arrInsertSorting);
        SortUtils.printlnArr(arrInsertSorting);
        //归并排序
        Merge.mergeSorting(arrMergeSorting);
        SortUtils.printlnArr(arrMergeSorting);
        //快速排序
        Quick.quickSorting(arrQuickSorting);
        SortUtils.printlnArr(arrQuickSorting);
        try {
            SortUtils.logarithm(arrBubbleSorting, arrMergeSorting);
            SortUtils.logarithm(arrSelectionSorting, arrBubbleSorting);
            SortUtils.logarithm(arrInsertSorting, arrBubbleSorting);
            SortUtils.logarithm(arrMergeSorting, arrBubbleSorting);
            SortUtils.logarithm(arrQuickSorting, arrBubbleSorting);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
