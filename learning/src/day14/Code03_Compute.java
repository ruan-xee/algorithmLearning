package day14;

/**
 * 给定两个有符号32位整数a和b，不能使用算术运算符，分别实现a和b的加、减、乘、除运算
 */
public class Code03_Compute {
    /**
     * 加法
     */
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum =  a ^ b; // 无进位相加结果
            b = (a & b) << 1; // 进位信息
            a =  sum;
        }
        return  sum;
    }

    /**
     * 求n的相反数
     */
    public static int negNum(int n) {
        return add(~n, 1);
    }

    /**
     * 减法，就是一个数加上另一个数的相反数
     */
    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    /**
     * 乘法
     */
    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
               res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    /**
     * 除法
     */
    public static int divide(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; i = minus(i, 1)) {
            if ((x>>i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

}
