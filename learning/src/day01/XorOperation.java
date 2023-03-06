package day01;

/**
 * 异或运算的问题及解决
 * 异或运算满足：
 *      ① 0 ^ n = n;
 *         n ^ n = 0;
 *      ② a ^ b = b ^ a;
 *        (a ^ b) ^ c = a ^ (b ^ c)
 *
 * 问题1：有一个数组中只有一个数字出现了奇数次，其余数字出现了偶数次，找出这个奇数次的数
 * 例如：[2,2,4,4,5,6,⑦,6,5,8,8,2,2]
 * 问题2：一个数组中有两个数字出现了奇数次，其余数字出现了偶数次，找出这两个奇数次的数
 * 例如：[2,2,3,3,4,⑤,⑥,4,4,4]
 */
public class XorOperation {
    public static int findOneOdd(int[] arr){
        // 因为偶数次异或为0，所以直接对整个数组进行异或操作就可以得到只出现奇数次的数
        int xor = 0;
        for (int num:
             arr) {
            xor = num ^ xor;
        }
        return xor;
    }

    public static int[] findTwoOdd(int[] arr){
        int xor = 0;
        // 假设两个奇数为a, b
        // 在一次遍历后，xor = a ^ b
        for (int num:
                arr) {
            xor = num ^ xor;
        }

        // 因为a,b一定不相同，所以a ^ b的2进制上至少有一位不同，一个为0，一个为1
        // 获取最右边的a ^ b上为1的值
        int rightOne = xor & (~xor + 1);
        int selectOne = 0;
        for (int num:
                arr) {
            // 这边通过筛选num，可以使a或b其中一个数进入
            if ((rightOne & num) == 0){
                selectOne = selectOne ^ num;
            }
        }
        xor = xor ^ selectOne;

        return new int[]{xor, selectOne};
    }
}
