package com.carrywei.set;

import java.util.HashSet;

/**
 * Leetcode题目：804. 唯一摩尔斯密码词
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
 *
 * 返回我们可以获得所有词不同单词翻译的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-morse-code-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet ret = new HashSet();
        String[] mos = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (String word : words) {
            //每个单词转换为摩尔斯密码格式
            StringBuilder mStr = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                mStr.append(mos[word.charAt(i) - 'a']);
            }
            ret.add(mStr.toString());
        }
        return ret.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
