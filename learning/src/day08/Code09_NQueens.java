package day08;

/**
 * 给定一个N*N的棋盘，需要在棋盘上摆放N个皇后
 * 要求皇后与皇后之间不能同行、同列、同斜线
 * 问：有多少种摆放的方法
 */
public class Code09_NQueens {
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        // 用单数组就可以表示棋盘皇后的摆放位置
        // n表示行数，record[n]表示皇后在第n行的第record[n]列上
        int[] record = new int[n];
        return process(0, record, n);
    }

    // record[0..i-1]的皇后已经符合题目要求
    // 目前来到第i行
    // record[0..i-1]存放了之前摆放的皇后位置
    // n整体行数
    // 返回值是，摆完所有的皇后，合理的摆法有多少种
    private static int process(int i, int[] record, int n) {
        if (i == n) {   // 终止行，最后一行是 i = n-1
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    private static boolean isValid(int[] record, int i, int j) {
        //for (int k = i-1, l=1; k >= 0; k--, l++) {
        //    if (record[k] == j || record[k] + l == record[i] || record[k] - l == record[i]) {
        //        return false;
        //    }
        //}
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(i - k) == Math.abs(j - record[k])) {
                return false;
            }
        }
        return true;
    }

    // 请不要超过32皇后问题
    public static int num2(int n) {
        if ( n < 1 || n > 32) {
            return 0;
        }
        // 生成一个后n位都是1前面都是0的数
        // 例如n=8, 00000000000000000000000011111111
        int limit = n == 32 ? - 1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    // colLim 列的限制，1的位置不能放皇后，0的位置可以
    // leftDiaLim 左斜线的限制，1的位置不能放皇后，0的位置可以
    // rightDiaLim 右斜线的限制，1的位置不能放皇后，0的位置可以
    private static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return 1;
        }
        int mostRightOne = 0;
        // 位为1的位置表示可以摆放皇后的位置
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            // 提取最右侧的1（最右侧的可放置皇后的位置）
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit, colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    // >>>表示无符号右移
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Code09_NQueens.num2(4));
    }
}
