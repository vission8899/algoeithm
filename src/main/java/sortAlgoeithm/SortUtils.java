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

    public static void printlnArr(int[] arr) {
        for (int cur : arr){
            System.out.print(String.valueOf(cur)+" ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.getArr(10000);
        SortUtils.printlnArr(arr);
        int[] a = arr;
        int[] b = arr;
        int[] c = arr;
        BubbleSorting.bubbleSorting(a);
        SelectionSorting.selectionSorting(b);
        InsertSorting.insertSorting(c);
        SortUtils.printlnArr(a);
        SortUtils.printlnArr(b);
        SortUtils.printlnArr(c);
        try {
            SortUtils.logarithm(a,b);
            SortUtils.logarithm(a,c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
