package sortAlgoeithm;

public class SortUtils {
    /**
     * 交换
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j){
        //运用了异或的远离，所以 i != j
        if (i==j){
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    /**
     * 创建size大小的随机数组
     * @param size 大小
     * @return
     */
    public static int[] getArr(int size) {
        int[] tmp = new int[size];
        for (int i = 0; i < size; i++) {
            tmp[i] = i;
        }
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            double v = Math.random() * size;
            arr[i] = tmp[(int) v];
        }
//        printlnArr(arr);
        return arr;
    }

    /**
     * @description 对数器
     * @author  weicheng.lu
     * @date   2022/3/11 12:50 AM
    */
    public static void logarithm(int[]a,int[]b) throws Exception {
        if (a.length!=b.length){
            throw new Exception("a.length!=b.length");
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i]!=b[i]){
                throw new Exception("a.sort!=b.sort"+i);
            }
        }
    }

    /**
     * @description 打印数组
     * @author  weicheng.lu
     * @date   2022/3/17 00:22
    */
    public static void printlnArr(int[] arr) {
        for (int cur : arr){
            System.out.print(String.valueOf(cur)+" ");
        }
        System.out.println("\n");
    }

    /**
     * @description 复制数组
     * @author  weicheng.lu
     * @date   2022/3/17 00:22
    */
    public static int[] copyArr(int[] arr) {
        int length = arr.length;
        int[] copyArr = new int[length];
        for (int i = 0; i < length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.getArr(10000);
        SortUtils.printlnArr(arr);
        int[] arrBubbleSorting = copyArr(arr);
        int[] arrSelectionSorting = copyArr(arr);
        int[] arrInsertSorting = copyArr(arr);
        int[] arrMergeSorting = copyArr(arr);
        int[] arrQuickSorting = copyArr(arr);
        //冒泡排序
        BubbleSorting.bubbleSorting(arrBubbleSorting);
        printlnArr(arrBubbleSorting);
        //选择排序
        SelectionSorting.selectionSorting(arrSelectionSorting);
        printlnArr(arrSelectionSorting);
        //插入排序
        InsertSorting.insertSorting(arrInsertSorting);
        printlnArr(arrInsertSorting);
        //归并排序
        MergeSorting.mergeSorting(arrMergeSorting);
        printlnArr(arrMergeSorting);
        //快速排序
        QuickSorting.quickSorting(arrQuickSorting);
        printlnArr(arrQuickSorting);
        try {
            SortUtils.logarithm(arrBubbleSorting,arrMergeSorting);
            SortUtils.logarithm(arrSelectionSorting,arrBubbleSorting);
            SortUtils.logarithm(arrInsertSorting,arrBubbleSorting);
            SortUtils.logarithm(arrMergeSorting,arrBubbleSorting);
            SortUtils.logarithm(arrQuickSorting,arrBubbleSorting);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
