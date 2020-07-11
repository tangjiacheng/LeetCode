package com.jd;

import java.util.TreeMap;

/**
 * @Author: TJC
 * @Date: 2020/6/30 18:54
 * @description: TODO
 */
public class Numbers {
    public int press(String s) {
        if (s == null || s.length() == 0) return 0;
        boolean lock = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (lock == isBig(s.charAt(i)))
                count++;
            else {
                if (i < s.length() - 1 && lock != isBig(s.charAt(i + 1))) {
                    lock = !lock;
                }
                count += 2;
            }
        }
        return count;
    }

    private boolean isBig(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
    
}
