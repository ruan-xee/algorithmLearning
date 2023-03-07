package day02;

/**
 * 小和问题
 * 求一个数组中的每个元素左侧比自身小的元素的和
 * 例如：[1,3,4,2,5]
 * 1没有左侧，所以不产生小值
 * 3的左侧1小于自己，所以产生1个1
 * 4的左侧1、3小于自己，所以产生1个1，1个3
 * 2的左侧1小于自己，所以产生1个1
 * 5的左侧1、3、4、2小于自己，所以产生1个1，1个3，1个4，1个2
 * 将产生的小值求和得到16
 */
public class SmallSum {
    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        return process(arr, 0, arr.length-1);
    }

    private static int process(int[] arr, int head, int front) {
        if (head == front){
            return 0;
        }
        int mid = head + ((front - head) >> 1);
        return process(arr, head, mid) + process(arr, mid+1, front) + merge(arr, head, mid, front);
    }

    private static int merge(int[] arr, int head, int mid, int front) {
        int smallsum = 0;
        int[] help = new int[front - head + 1];
        int i = 0;
        int p1 = head;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= front){
            smallsum += arr[p1] < arr[p2] ? arr[p1]*(front-p2+1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= front){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++){
            arr[head+i] = help[i];
        }
        return smallsum;
    }
}
