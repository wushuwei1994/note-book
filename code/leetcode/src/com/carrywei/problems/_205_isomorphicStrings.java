package com.carrywei.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 可以假设 s 和 t 长度相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _205_isomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (Objects.equals(s, t)) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        // 定义一个Map，key为字符串字符，value为另字符串字符。如果key已出现，其value必须与字符串相同；
        // 如key未出现过，则value也应该不重复
        HashMap<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = map.get(s.charAt(i));
            if (c == null) {
                if (set.contains(t.charAt(i))) {
                    return false;
                }
            }else{
                if(!c.equals(t.charAt(i))){
                    return false;
                }
            }
            map.put(s.charAt(i), t.charAt(i));
            set.add(t.charAt(i));
        }
        return true;
    }
}
