package com.string;

public class ValidPalindrome {

    private int flag = 1;

    public boolean validPalindrome(String s) {
        return palindrome(s, 0, s.length() - 1);
    }

    public boolean palindrome(String s, int left, int right) {
        if (left == right)
            return true;
        if (left + 1 == right) {
            if (flag == 1) {
                return true;
            }
            return s.charAt(left) == s.charAt(right);
        }
        if (s.charAt(left) == s.charAt(right)) {
            return palindrome(s, left + 1, right - 1);
        }
        else {
            if (flag == 0)
                return false;
            flag--;
            return palindrome(s, left + 1, right) || palindrome(s, left, right - 1);
        }
    }
}
