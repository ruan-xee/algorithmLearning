package day03;

/**
 * 基数排序
 */
public class RadixSort {
    public static void radixSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        radixSort(arr, 0, arr.length-1, maxbits(arr));
    }

    private static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0){
            max /= 10;
            res++;
        }
        return res;
    }

    private static void radixSort(int[] arr, int l, int r, int digit) {
        final int radix = 10;   //因为是十进制，所以落桶的时候只会落在0~9这十个数中
        int[] bucket = new int[r-l+1];
        int i = 0, j = 0;
        for (int d = 1; d <= digit; d++) {   //有多少位就进出多少次
            // 10个空间
            // count[0] 当前位（d位）是0的数字有多少个
            // count[1] 当前位（d位）是0~1的数字有多少个
            // count[2] 当前位（d位）是0~2的数字有多少个
            // count[i] 当前位（d位）是0~i的数字有多少个
            int[] count = new int[radix];
            //先将数组按d位落入count内
            for (i = l; i <= r; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            //将count进行累计
            for (i = 1; i < radix; i++) {
                count[i] += count[i-1];
            }
            //将arr数组从右往左遍历，完成该d位上的排序
            for (i = r; i >= l; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            //将数值替换回原数组完成排序
            for (i = l, j = 0; i <= r; i++,j++) {
                arr[i] = bucket[j];
            }

        }
    }

    //获取指定d位的尾数
    private static int getDigit(int i, int d) {
        return ((i / ((int)Math.pow(10, d-1))) % 10);
    }


}
