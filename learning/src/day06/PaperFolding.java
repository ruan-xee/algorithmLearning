package day06;

/**
 * 将一张长条纸进行n次对折，自上向下，打印凹凸折痕
 *
 *              凹
 *             /  \
 *            凹   凸
 *          /   \/   \
 *         凹   凸凹   凸
 */
public class PaperFolding {
    public static void printAllFolding(int N) {
        printProcess(1, N, true);
    }

    /**
     * 递归的过程函数
     * @param i     当前来到的层数
     * @param N     总共层数
     * @param down  down == true 表示凹， down == false 表示凸
     */
    private static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.print(down ? "凹 " : "凸 ");
        printProcess(i + 1, N, false);
    }

    public static void main(String[] args) {
        printAllFolding(3);
    }
}
