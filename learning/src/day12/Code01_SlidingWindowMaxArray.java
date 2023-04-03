package day12;

import java.util.LinkedList;

public class Code01_SlidingWindowMaxArray {
    public static class WindowMax {
        private int L;
        private int R;
        private int[] arr;
        private LinkedList<Integer> qmax;

        public WindowMax(int[] a) {
            arr = a;
            L = -1;
            R = 0;
            qmax = new LinkedList<>();
        }

        public void addNumFromRight() {
            if (R == arr.length) {
                return;
            }
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);
            R++;
        }

        public void removeNumFromleft() {
            if (L >= R - 1) {
                return;
            }
            L++;
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }
        }

        public Integer getMax() {
            if (!qmax.isEmpty()) {
                return arr[qmax.peekFirst()];
            }
            return null;
        }
    }

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
