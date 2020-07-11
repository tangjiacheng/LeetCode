package com.string;

import java.util.*;

/**
 * @Author: TJC
 * @Date: 2020/6/25 19:49
 * @description: TODO
 */
public class WordBreak {
    int minLength = Integer.MAX_VALUE;
    int maxLength = 0;
    Set<String> dict = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null)
            return false;
        if (wordDict == null || wordDict.size() == 0 && s.length() != 0) return false;

        for (String str : wordDict) {
            dict.add(str);
            minLength = Math.min(minLength, str.length());
            maxLength = Math.max(maxLength, str.length());
        }
        return doWordBreak(s);
    }

    public boolean doWordBreak(String s) {
        if ("".equals(s)) {
            return true;
        }
        if (s.length() < minLength) {
            return false;
        }
        boolean flag = false;
        int index = minLength;
        while (index <= s.length() && index <= maxLength) {
            if (dict.contains(s.substring(0, index))) {
                flag = doWordBreak(s.substring(index));
                if (flag) {
                    break;
                }
            }
            index++;
        }
        return flag;
    }

}
