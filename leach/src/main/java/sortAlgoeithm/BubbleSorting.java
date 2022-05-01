package sortAlgoeithm;

/**
 * @description 冒泡排序
 * @author  weicheng.lu
 * @date   2022/3/10 11:22 PM
*/
public class BubbleSorting {
    public static void bubbleSorting(int[] arr){
        int size = arr.length-1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if (arr[j]>arr[j+1]){
                    SortUtils.swap(arr,j,j+1);
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.getArr(100);
        SortUtils.printlnArr(arr);
        bubbleSorting(arr);
        SortUtils.printlnArr(arr);
    }




}
