package com.carrywei.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class _290_wordPattern {
    public boolean wordPattern(String pattern, String s) {
        //都为null,则为true
        if (pattern == s) {
            return true;
        }
        if (pattern == null) {
            return false;
        }
        if (s == null) {
            return false;
        }
        String[] allWords = s.split(" ");
        if (pattern.length() != allWords.length) {
            return false;
        }
        Map<Character, Integer> pattern1 = new HashMap<>();
        Map<String, Integer> pattern2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            // 相同规律即前面出现过的词位置相同 如：「aabb」 「dog dog cat cat」
            // 注意，如果从map获取的值为空，表示前面未出现过，当两者前面都未出现过，视为相同规律
            Integer target1 = pattern1.get(Character.valueOf(pattern.charAt(i)));
            Integer target2 = pattern2.get(allWords[i]);

            if(!Objects.equals(target1, target2)){
                return false;
            }
            pattern1.put(Character.valueOf(pattern.charAt(i)), i);
            pattern2.put(allWords[i], i);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _290_wordPattern().wordPattern("abba", "dog cat cat dog"));

    }
}
