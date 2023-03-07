package day01;

import common.Utils;

/**
 * 插入排序
 */
public class InsertSort {
    public static int[] insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                Utils.swap(arr, j, j-1);
            }
        }
        return arr;
    }
}
