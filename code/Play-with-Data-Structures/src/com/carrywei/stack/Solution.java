package com.carrywei.stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean isValid(String s) {

        //
        /***************************方法1***************************
        if (s.isEmpty()) {
            return true;
        }
        char[] data = new char[s.length()];
        int index = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                data[index] = c;
                index++;
            } else {
                // 无左括号匹配
                if (index == 0) {
                    return false;
                }
                if (c == ')' && data[index - 1] == '(') {
                    index--; // 匹配成功，模拟出栈操作
                }
                else if (c == ']' && data[index - 1] == '[') {
                    index--;
                } else if (c == '}' && data[index - 1] == '{') {
                    index--;
                } else {
                    //未匹配上
                    return false;
                }
            }
        }
        return index == 0;
         *************************************end 方法1 ***********************************/
        if (s.isEmpty()) {
            return true;

        }
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.peek() == '(') {
                    stack.pop(); // 出栈操作
                }
                else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    //未匹配上
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("{[]}"));
    }

}
