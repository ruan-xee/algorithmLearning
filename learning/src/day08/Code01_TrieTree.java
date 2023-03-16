package day08;

public class Code01_TrieTree {
    public static class TrieNode {
        public int pass;
        public int end;
        // 如果字符串包含字符范围不止26个，可以用哈希表
        // HashMap<Char, Node> nexts
        public TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            // 将每一个下标记作一个字母的存放
            // 不为空表示该位置存在字母
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            for (int i = 0; i < chs.length; i++) {
                int index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        // 查询word插入次数
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chs.length; i++) {
                int index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        // 查询以word为前缀的字符串有多少
        public int searchPreWord(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chs.length; i++) {
                int index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

        // 删除前缀树中word
        public void delete(String word) {
            if (search(word) == 0) {    // 如果前缀树上没有该字符串，就不删
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass--;
            for (int i = 0; i < chs.length; i++) {
                int index = chs[i] - 'a';
                if (--node.nexts[index].pass == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }

    }
}
