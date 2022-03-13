package sortAlgoeithm;

/**
 * @description 插入排序，范围逐渐变大的冒泡排序
 * @author  weicheng.lu
 * @date   2022/3/10 11:22 PM
*/
public class InsertSorting {
    public static void insertSorting(int[] arr){
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (arr[j+1]<arr[j]){
                    SortUtils.swap(arr,j+1,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.getArr(10);
        SortUtils.printlnArr(arr);
        insertSorting(arr);
        SortUtils.printlnArr(arr);
    }




}
