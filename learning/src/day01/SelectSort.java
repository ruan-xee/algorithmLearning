package day01;

import common.Utils;

public class SelectSort {
    /**
     * 选择排序（从小到大）
     * @param arr
     * @return
     */
    public static int[] selectSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Utils.swap(arr, i, minIndex);
            }
        }
        return arr;
    }


}
