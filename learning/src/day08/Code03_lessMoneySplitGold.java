package day08;

import java.util.PriorityQueue;

/**
 * 给一个金条分段
 * 铁匠根据要求给金条切分所要长度，并收取原长度数的铜钱
 * 例如，60cm的金条需要分成【10、20、30】长度
 * 可以先将60分为10、50，收取60铜钱
 * 再将50分为20、30，收取50铜钱
 * 共计110铜钱
 * 也可以将60分为30、30，收取60铜钱
 * 再将30分为10、20，收取30铜钱
 * 共计90铜钱
 * 问：如何切割最省钱
 */
public class Code03_lessMoneySplitGold {
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
        }
        int sum = 0;
        int cur = 0;
        while (queue.size() > 1) {
            cur = queue.poll() + queue.poll();
            sum += cur;
            queue.add(cur);
        }
        return sum;
    }
}
