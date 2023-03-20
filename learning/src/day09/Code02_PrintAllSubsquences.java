package day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串
 * 求该字符串的所有子集序列（包括空）
 */
public class Code02_PrintAllSubsquences {
    public static void printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        process(chs, i + 1);
        char temp = chs[i];
        chs[i] = 0;
        process(chs, i + 1);
        chs[i] = temp;
    }

    public static void function(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0, new ArrayList<Character>());
    }

    public static void process(char[] str, int i, List<Character> res) {
        if (i == str.length) {
            System.out.println(Arrays.toString(res.toArray()));
            return;
        }
        List<Character> resKeep = new ArrayList<>(res);
        resKeep.add(str[i]);
        process(str, i + 1, resKeep);
        List<Character> resNoInclude = new ArrayList<>(res);
        process(str, i + 1, resNoInclude);
    }
}
