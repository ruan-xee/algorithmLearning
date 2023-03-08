package day02;

import common.Utils;

/**
 * 快排3.0
 * 随机选取数组中的一个数作为基准比对位置
 */
public class QuickSort {
    public static void quicksort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quicksort(arr, 0, arr.length-1);
    }

    private static void quicksort(int[] arr, int L, int R) {
        if (L < R){
            Utils.swap2(arr, L+(int)(Math.random()*(R-L+1)), R);
            //p中只会存在两个数，p[0]表示与基准值相等的左界，p[1]表示与基准值相等的右界
            int[] p = partition(arr, L, R);
            quicksort(arr, L, p[0] - 1);
            quicksort(arr, p[1] + 1, R);
        }

    }

    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;   //  <区左边界
        int more = R;       //  >区右边界
        while (L < more) {  //  将L选作当前位置
            if (arr[L] > arr[R]){
                Utils.swap2(arr, L, --more);
            } else if (arr[L] < arr[R]){
                Utils.swap2(arr, L++, ++less);
            } else {
                L++;
            }
        }
        Utils.swap2(arr, more, R);
        return new int[]{less+1, more};

    }
}
