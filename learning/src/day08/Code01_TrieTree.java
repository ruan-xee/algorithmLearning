package day08;

public class Code01_TrieTree {
    public static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            // 将每一个下标记作一个字母的存放
            // 不为空
            nexts = new TrieNode[26];
        }
    }
}
