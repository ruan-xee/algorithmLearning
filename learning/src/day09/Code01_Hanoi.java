package day09;

/**
 * 问题规则：Hanoi(汉诺)塔问题。
 * 古代有一个焚塔，塔内有3个座A,B,C,开始时A座上有64个盘子，
 * 盘子大小不等，大的在上，小的在下，有一个老和尚想把这64个盘子从A座移到C座，
 * 但规定每次只允许移到一个盘，且在移动过程中在3个座上都始终保持大盘在下，小盘在上，
 * 在移动过程中可以利用B座。输出移动盘子的步骤。
 */
public class Code01_Hanoi {
    public static void hanoi(int n) {
        if (n > 0) {
            func(n, "左", "右", "中");
        }
    }

    // 1~i 圆盘 目标是from->to，other是另外一个
    public static void func(int i, String start, String end, String other) {
        if (i == 1) {
            System.out.println("Move 1 from " + start + " to " + end);
        } else {
            func(i - 1, start, other, end);
            System.out.println("Move " + i + " from " + start + " to " + end);
            func(i - 1, other, end, start);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }
}
