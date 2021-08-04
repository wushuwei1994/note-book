package com.carrywei.problems;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class _020_validParentheses {
    public boolean isValid(String s) {
        // 定义一个char数组，当栈对象
        char[] stack = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                // 左括号入栈
                top++;
                stack[top] = c;
            } else {
                // 右括号匹配左括号，并出栈
                // 无元素匹配，返回false
                if (top == -1) {
                    return false;
                }
                char topC = stack[top];
                if (c == ')' &&  topC != '(') {
                    return false;
                }
                if (c == ']' && topC != '[') {
                    return false;
                }
                if (c == '}' && topC != '{') {
                    return false;
                }
                // 出栈
                top--;
            }
        }
        // 如果栈有元素，则表示有括号未匹配
        if (top != -1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _020_validParentheses().isValid("[]}"));
    }
}
