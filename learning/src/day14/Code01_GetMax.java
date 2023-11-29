package day14;

/**
 * 设计求出a、b中的最大值，要求不能用比较运算
 */
public class Code01_GetMax {
    // 请保证参数n 不是1就是0的情况下
    // 1 -> 0
    // 0 -> 1
    public static int flip(int n) {
        return n ^ 1;
    }

    // n是非负数，返回1
    // n是负数，返回0
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    public static int getMax1(int a, int b) {
        int c = a - b; // 有溢出风险
        int scA = sign(c); // a-b为非负，scA为1；a-b为负，scA为0
        int scB = flip(scA); // scA为0，scB为1；scA为1，scB为0
        return scA * a + scB * b;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb; // a和b的符号相同，为0，不一样，为1
        int sameSab = flip(difSab);
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }
}
