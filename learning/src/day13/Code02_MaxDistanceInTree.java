package day13;

public class Code02_MaxDistanceInTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int v) {
            this.value = v;
        }
    }

    public static class Info {
        public int maxDistance;
        public int height;
        public Info(int dis, int h) {
            maxDistance = dis;
            height = h;
        }

        public static Info process(Node x) {
            if (x == null) {
                return new Info(0, 0);
            }
            Info leftInfo = process(x.left);
            Info rightInfo = process(x.right);

            int p1 = leftInfo.maxDistance;
            int p2 = rightInfo.maxDistance;
            int p3 = leftInfo.height + 1 + rightInfo.height;
            int maxDistance = Math.max(Math.max(p1, p2), p3);
            int height = Math.max(leftInfo.height, rightInfo.height) + 1;
            return new Info(maxDistance, height);
        }

        public static int maxDistance(Node head) {
            return process(head).maxDistance;
        }
    }
}
