package day02;

/**
 * 归并排序
 */
public class MergeSort {
    public static int[] mergeSort(int[] arr, int head, int front){
        if (arr == null || arr.length < 2 || head == front){
            return arr;
        }
        int mid = head + ((front - head) >> 1);
        mergeSort(arr, head, mid);
        mergeSort(arr, mid+1, front);
        merge(arr, head, front, mid);

        return arr;
    }

    private static void merge(int[] arr, int head, int front, int mid) {
        int[] help = new int[front - head + 1];
        int i = 0;
        int p1 = head;
        int p2 = mid+1;
        while(p1 <= mid && p2 <= front){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= front){
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            //将排好序的临时数组覆写回原数组
            arr[head + i] = help[i];
        }
    }
}
