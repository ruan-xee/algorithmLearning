package day15;

/**
 * 给定一个数组arr，其中arr[i]表示第i个硬币的价值，再给定一个数n
 * 问最少多少个硬币可以达到n的价值
 */
public class Code02_CoinsMin {
    public static int min1(int[] arr, int aim) {
        return f1(arr, 0, aim);
    }

    /**
     * arr[index...]组成出rest这么多钱，最少的硬币数量返回
     */
    public static int f1(int arr[], int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            return 0;
        }
        if (index == arr.length) {
            return -1;
        }

        int p1 = f1(arr, index + 1, rest);
        int p2Next = f1(arr, index + 1, rest - arr[index]);
        if (p1 == -1 && p2Next == -1) {
            return -1;
        } else {
            if (p1 == -1) {
                return p2Next + 1;
            }
            if (p2Next == -1) {
                return p1;
            }
            return Math.min(p1, p2Next + 1);
        }
    }


    public static int min2(int[] arr, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = -2;
            }
        }
        return f2(arr, 0, aim, dp);
    }

    public static int f2(int arr[], int index, int rest, int[][] dp) {
        if (rest < 0) {
            return -1;
        }
        if (dp[index][rest] != -2) {
            return dp[index][rest];
        }
        if (rest == 0) {
            dp[index][rest] = 0;
        } else if (index == arr.length) {
            dp[index][rest] = -1;
        } else {
            int p1 = f2(arr, index + 1, rest, dp);
            int p2Next = f2(arr, index + 1, rest - arr[index], dp);
            if (p1 == -1 && p2Next == -1) {
                dp[index][rest] = -1;
            } else {
                if (p1 == -1) {
                    dp[index][rest] = p2Next + 1;
                } else if (p2Next == -1) {
                    dp[index][rest] = p1;
                } else {
                    dp[index][rest] = Math.min(p1, p2Next + 1);
                }
            }
        }
        return dp[index][rest];
    }


    public static int min3(int[] arr, int aim) {
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        for (int row = 0; row <= N; row++) {
            dp[row][0] = 0;
        }
        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }

        for (int index = N-1; index >= 0; index--) {
            for (int rest = 1; rest <= aim; rest++) {
                int p1 = dp[index + 1][rest];
                int p2Next = -1;
                if (rest - arr[index] >= 0) {
                    p2Next = dp[index + 1][rest - arr[index]];
                }

                if (p1 == -1 && p2Next == -1) {
                    dp[index][rest] = -1;
                } else {
                    if (p1 == -1) {
                        dp[index][rest] = p2Next + 1;
                    } else if (p2Next == -1) {
                        dp[index][rest] = p1;
                    } else {
                        dp[index][rest] = Math.min(p1, p2Next + 1);
                    }
                }
            }
        }

        return dp[0][aim];
    }
}
