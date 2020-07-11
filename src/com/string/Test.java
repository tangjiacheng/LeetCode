package com.string;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // validPalindrome
        /*ValidPalindrome vp = new ValidPalindrome();
        String s = "abca";
        System.out.println(vp.validPalindrome(s));*/

        // findTheLongestSubstring
        /*String s = "elllsdfe";
        FindTheLongestSubstring f = new FindTheLongestSubstring();
        System.out.println(f.findTheLongestSubstring(s));*/

        // longestPalindrome
        /*String s = "abbc";
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome(s));*/

        // minWindow
        /*String S = "ADOBECODEBANC";
        String T = "ABC";
        MinWindow mw = new MinWindow();
        System.out.println(mw.minWindow(S, T));*/

        // decodeString
//        DecodeString ds = new DecodeString();
//        String s = "2[abc]3[cd]ef";
//        System.out.println(ds.decodeString(s));
//    }

        // wordBreak
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aa");
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak(s, wordDict));
    }
}
