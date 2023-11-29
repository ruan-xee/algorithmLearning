package day15;

public class Code01_RobotWalk {
    public static int walkWays1(int N, int E, int S, int K) {
        return f1(N, E, S, K);
    }


    // 一共是1～N个位置 固定参数
    // 最终的目标位置E 固定参数
    // 当前所在的位置cur
    // 还剩步数rest
    // 返回方法数
    public static int f1(int N, int E, int cur, int rest) {
        if (rest == 0) {
            return cur == E ? 1 : 0;
        }
        if (cur == 1) { // 当前位置为左界，只能往右走
            return f1(N, E, cur + 1, rest - 1);
        }
        if (cur == N) { //  当前位置为右界，只能往左走
            return f1(N, E, cur - 1, rest - 1);
        }
        return f1(N, E, cur - 1, rest - 1) + f1(N, E, cur + 1, rest - 1);
    }




    public static int walkWays2(int N, int E, int S, int K) {
        int[][]  f = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                f[i][j] = -1;
            }
        }
        return f2(N, E, S, K, f);
    }


    public static int f2(int N, int E, int cur, int rest, int[][] dp) {
        if (dp[rest][cur] != -1) {
            return dp[rest][cur];
        }
        if (rest == 0) {
            dp[rest][cur] = cur == E ? 1 : 0;
            return cur == E ? 1 : 0;
        }
        if (cur == 1) { // 当前位置为左界，只能往右走
            dp[rest][cur] = f2(N, E, cur + 1, rest - 1, dp);
        } else if (cur == N) { //  当前位置为右界，只能往左走
            dp[rest][cur] = f2(N, E, cur - 1, rest - 1, dp);
        } else {
            dp[rest][cur] = f2(N, E, cur - 1, rest - 1, dp) + f2(N, E, cur + 1, rest - 1, dp);
        }
        return dp[rest][cur];
    }
}
