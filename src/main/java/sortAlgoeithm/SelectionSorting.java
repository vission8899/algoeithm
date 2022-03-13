package sortAlgoeithm;

/**
 * @description 选择排序
 * @author  weicheng.lu
 * @date   2022/3/11 12:07 AM
*/
public class SelectionSorting {
    public static void selectionSorting(int[] arr){
        int minTag = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (arr[j]<arr[minTag]){
                    minTag = j;
                }
            }
            if (minTag != i){
                SortUtils.swap(arr,i,minTag);
            }
            minTag = i+1;
        }

    }
    public static void main(String[] args) {
        int[] arr = SortUtils.getArr(1000);
        SortUtils.printlnArr(arr);
        selectionSorting(arr);
        SortUtils.printlnArr(arr);
        selectionSorting(arr);
    }
}
