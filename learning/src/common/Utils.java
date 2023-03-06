package common;

import java.util.Arrays;

public class Utils {

    /**
     * 获取长度随机、内容数值随机的整型数组
     * @param maxSize   最大长度
     * @param maxValue  最大值
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue){
        //Math.random() -> [0,1) 所有的小数，等概率返回一个
        //Math.random() * N -> [0,N) 所有小数，等概率返回一个
        //(int)(Math.random() * N) -> [0,N-1] 所有的整数，等概率返回一个

        int[] arr = new int[(int) ((maxSize+1)* Math.random())];    //长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue+1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 交换数组中的元素(两个交换的元素不能指向同一位置)
     * @param arr   数组
     * @param i     当前位置
     * @param j     最小值的位置
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    /**
     * 打印数组
     */
    public static void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
