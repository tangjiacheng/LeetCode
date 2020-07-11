package com.recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
*/
public class LetterCombinations {
    private StringBuffer sb = new StringBuffer();
    private HashMap<Character, String> hm = new HashMap<>();
    ArrayList<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return list;
        init();
        recall(digits);

        return list;
    }

    public void init() {
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
    }

    public void recall(String digits) {
        String letters = hm.get(digits.charAt(0));
        int len = sb.length();
        for (char letter :
        letters.toCharArray()){
            sb.append(letter);
            if (digits.length() == 1)
                list.add(sb.toString());
            else
                recall(digits.substring(1));
            sb.deleteCharAt(len);
        }
    }
}
