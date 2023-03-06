package day01;

import common.Utils;

public class PopSort {
    /**
     * 冒泡排序（从小到大）
     */
    public static int[] popSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return arr;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]){
                    Utils.swap(arr, j, j+1);
                }
            }
        }
        return arr;
    }


}
