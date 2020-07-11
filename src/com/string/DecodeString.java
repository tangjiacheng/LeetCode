package com.string;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: TJC
 * @Date: 2020/5/28 11:56
 * @description:
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class DecodeString {

//    Stack<Character> stack = new Stack<>();
    public String decodeString(String s) {

        LinkedList<String> stack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        StringBuilder num = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num.append(ch);

            }
            else if (Character.isLetter(ch)) {
                stack.addLast(String.valueOf(ch));
            }
            else if (ch == '[') {
                stack.addLast(num.length() == 0 ? "1" : num.toString());
                num = new StringBuilder();
                stack.addLast("[");
            }else if (ch == ']') {
                LinkedList<String> rev = new LinkedList<>();
                while (!"[".equals(stack.getLast())) {
                    rev.add(stack.removeLast());
                }
                StringBuilder subString = new StringBuilder();
                while (!rev.isEmpty()) {
                    subString.append(rev.removeLast());
                }
                String sub = subString.toString();
                stack.removeLast();
                int n = Integer.parseInt(stack.removeLast());
                subString.append(sub.repeat(Math.max(0, n - 1)));
                stack.addLast(subString.toString());
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.removeFirst());
        }
        return res.toString();
    }
}
