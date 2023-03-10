package array.sort;

import array.utils.SortUtils;

/**
 * 快速排序
 *
 * @author vission.lu
 * @date 2022/3/13 5:07 PM
 */
public class Quick {

    public static void quickSortingV1(int[] arr, int l, int r) {
        if (l < r) {
            int[] flag = Quick.partitionV1(arr, l, r);
            Quick.quickSortingV1(arr, l, flag[0] - 1);
            Quick.quickSortingV1(arr, flag[0] + 1, r);
        }
    }

    public static void quickSortingV2(int[] arr, int l, int r) {
        if (l < r) {
            int[] flag = Quick.partitionV2(arr, l, r);
            Quick.quickSortingV2(arr, l, flag[0] - 1);
            Quick.quickSortingV2(arr, flag[1] + 1, r);
        }
    }

    public static void quickSortingV3(int[] arr, int l, int r) {
        if (l < r) {
            SortUtils.swap(arr, r, l + (int) Math.random() * (r - l + 1));
            int[] flag = Quick.partitionV2(arr, l, r);
            Quick.quickSortingV2(arr, l, flag[0] - 1);
            Quick.quickSortingV2(arr, flag[1] + 1, r);
        }
    }

    public static void quickSorting(int[] arr) {
        Quick.quickSortingV3(arr, 0, arr.length - 1);
    }

    /**
     * 荷兰国旗 分两层
     *
     * @author vission.lu
     * @date 2022/3/17 00:26
     */
    public static int[] partitionV1(int[] arr, int l, int r) {
        int less = l - 1;
        while (l < r) {
            if (arr[l] <= arr[r]) {
                SortUtils.swap(arr, ++less, l++);
            } else {
                l++;
            }

        }
        SortUtils.swap(arr, less + 1, r);
        return new int[]{less + 1};
    }

    /**
     * 荷兰国旗 分三层
     *
     * @author vission.lu
     * @date 2022/3/17 00:26
     */
    public static int[] partitionV2(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                SortUtils.swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                SortUtils.swap(arr, --more, l);
            } else {
                l++;
            }
        }
        SortUtils.swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.getArr(100);
        int[] arrPartitionV1 = SortUtils.copyArr(arr);
        int[] arrPartitionV2 = SortUtils.copyArr(arr);

        int[] arrQuickSortV1 = SortUtils.copyArr(arr);
        int[] arrQuickSortV2 = SortUtils.copyArr(arr);
        int[] arrQuickSortV3 = SortUtils.copyArr(arr);
        int start = 0;
        int end = arr.length - 1;
        SortUtils.printlnArr(arr);
        //荷兰国旗 v1 <=放左边 分两层
        Quick.partitionV1(arrPartitionV1, start, end);
        SortUtils.printlnArr(arrPartitionV1);
        //荷兰国旗 v2 <放左边 =放中间 >放右边 分三层
        Quick.partitionV2(arrPartitionV2, start, end);
        SortUtils.printlnArr(arrPartitionV2);
        //快速排序 v1 快速排序 <=放左边 分两层
        Quick.quickSortingV1(arrQuickSortV1, start, end);
        SortUtils.printlnArr(arrQuickSortV1);
        //快速排序 v2 快速排序 <放左边 =放中间 >放右边 分三层
        Quick.quickSortingV2(arrQuickSortV2, start, end);
        SortUtils.printlnArr(arrQuickSortV2);
        //快速排序 v3 快速排序 <放左边 =放中间 >放右边 分三层 引入随机选择num
        Quick.quickSortingV3(arrQuickSortV3, start, end);
        SortUtils.printlnArr(arrQuickSortV3);
    }
}
