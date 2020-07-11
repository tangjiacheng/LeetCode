package com.string;

/**
 * @Author: TJC
 * @Date: 2020/6/23 9:24
 * @description: TODO
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String str = a;
            a = b;
            b = str;
        }

        StringBuilder sb = new StringBuilder(a.length() + 1);
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        char flag = 0;

        while (indexB >= 0) {
            int tmp = a.charAt(indexA--) + b.charAt(indexB--) + flag - 2 * '0';
            if (tmp > 1) {
                tmp = tmp - 2;
                flag = 1;
            }
            else flag = 0;
            sb.append(tmp);
        }
        while (indexA >= 0) {
            int tmp = a.charAt(indexA--) + flag - '0';
            if (tmp > 1) {
                tmp = tmp - 2;
                flag = 1;
            }
            else flag = 0;
            sb.append(tmp);
        }
        if (flag == 1) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }
}
