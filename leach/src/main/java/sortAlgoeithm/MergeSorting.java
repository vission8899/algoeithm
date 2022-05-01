package sortAlgoeithm;

/**
 * @description 归并排序
 * @author  weicheng.lu
 * @date   2022/3/13 5:07 PM
*/
public class MergeSorting {
    public static void mergeSorting(int[] arr){
        process(arr,0, arr.length-1);
    }

    public static void process(int[] arr,int l,int r){
        if (r == l){
            return;
        }
        int mid = l+((r-l)>>1);
        process(arr,l,mid);
        process(arr,mid+1,r);
        merge(arr,l,r,mid);

    }

    public static void merge(int[] arr,int l,int r,int mid){
        int i = 0;
        int p1 = l;
        int p2 = mid +1;
        int help[] =new int[r-l+1];
        while (p1 <= mid && p2 <= r){
            help[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[i++] = arr[p1++];
        }
        while(p2<=r){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length ; i++) {
            arr[l+i] = help[i];

        }

    }

    public static void main(String[] args) {
        int[] arr = SortUtils.getArr(100);
        mergeSorting(arr);
        SortUtils.printlnArr(arr);
    }
}
