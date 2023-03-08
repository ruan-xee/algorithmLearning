package day03;

import common.Utils;

/**
 * 堆排序（从小到大）
 */
public class HeapSort {
    /**
     * 先通过遍历一次数组，逐渐形成一个大根堆，再通过大根堆的特性排序
     */
    public static void heapSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        while (heapSize > 0) {
            Utils.swap2(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
    }

    /**
     * 直接将数组从局部到整体的转换成大根堆，再通过大根堆的特性排序
     */
    public static void heapSort2(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--){
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        while (heapSize > 0) {
            Utils.swap2(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
    }


    //大根堆的元素上移
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index-1)/2]){
            Utils.swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    //大根堆的元素下移
    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize){//判断左孩子是否越界（存在）

            //比较左右孩子谁更大就将下标给largest
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ?
                        left + 1 : left;

            //比较较大的孩子是否比父节点大
            largest = arr[largest] > arr[index] ? largest : index;

            //说明左右孩子都不比父节点大，停止
            if (index == largest){
                break;
            }

            Utils.swap2(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
}
