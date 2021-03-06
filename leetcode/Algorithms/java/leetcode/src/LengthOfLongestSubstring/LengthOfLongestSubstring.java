package LengthOfLongestSubstring;

import org.junit.Test;

import java.util.HashSet;

public class LengthOfLongestSubstring {
    //暴力循环
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        HashSet<Character> cSet = new HashSet<>();
        int count = 1;
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            cSet.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (cSet.contains(s.charAt(j))) {
                    break;
                }
                cSet.add(s.charAt(j));
                count++;
            }

            if (count > max) {
                max = count;
            }
            cSet.clear();
            count = 1;
        }
        return max;
    }

    //滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int rp = -1;
        HashSet<Character> cSet = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                cSet.remove(s.charAt(i - 1));
            }

            while (rp + 1 < len && !cSet.contains(s.charAt(rp + 1))) {
                cSet.add(s.charAt(rp + 1));
                rp++;
            }

            max = Math.max(max, rp - i +1);
        }

        return max;
    }

    //参考：https://github.com/wind-liang/leetcode/blob/master/leetCode-3-Longest-Substring-Without-Repeating-Characters.md
    //trick仅适合ASCII字符
    public int lengthOfLongestSubstring3(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int max = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            max = Math.max(max, i - start + 1);
            last[index] = i;
        }

        return max;
    }

    @Test
    public void test1() {
        String s = "abcabcbb";
        HashSet<Character> aaa = new HashSet<>();
        System.out.println(lengthOfLongestSubstring3(s));
    }
}
