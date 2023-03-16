package day08;

import common.Utils;

import java.util.Comparator;
import java.util.PriorityQueue;

// 一个数据流中，随时可以取到中位数
public class Code02_MidNum {
    public static class MinComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static Double getMidNum(int[] arr) {
        if (arr.length == 1) {
            return arr[0]*1.0;
        } else if (arr.length == 2) {
            return (arr[0]*1.0+arr[1])/2;
        } else if (arr.length == 0) {
            return null;
        }
        PriorityQueue<Integer> bigQueue = new PriorityQueue<>(new MaxComparator());
        PriorityQueue<Integer> smallQueue = new PriorityQueue<>(new MinComparator());

        bigQueue.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= bigQueue.peek()) {
                bigQueue.add(arr[i]);
            } else {
                smallQueue.add(arr[i]);
            }

            if (bigQueue.size() - smallQueue.size() == 2) {
                smallQueue.add(bigQueue.poll());
            } else if (smallQueue.size() - bigQueue.size() == 2) {
                bigQueue.add(smallQueue.poll());
            }
        }

        if (arr.length % 2 == 1) {
         return smallQueue.size() > bigQueue.size() ? smallQueue.poll()*1.0 : bigQueue.poll()*1.0;
        } else {
            return (smallQueue.poll() + bigQueue.poll()) * 1.0 / 2;
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] array = Utils.generateRandomArray(10, 20);
            Utils.printArray(array);
            System.out.println("中位数：" + Code02_MidNum.getMidNum(array));
        }
    }
}
