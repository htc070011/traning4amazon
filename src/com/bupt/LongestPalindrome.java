package com.bupt;

import org.junit.Test;

public class LongestPalindrome {

    @Test
    public void test() {
        String str= "abbacf";
        String res = longestPalindrome(str);
        System.out.println(res);
    }


    public String longestPalindrome(String s) {

        if(s == null || s.length() == 0) {
            return s;
        }
        String ret = s.substring(0,1);
        char[] ch = s.toCharArray();
        boolean[][] dp = new boolean[ch.length][ch.length];
        for(int i = 0; i < ch.length; i++) {
            dp[i][i] = true;
        }
        for(int i = 0; i < ch.length - 1; i++) {
            dp[i][i + 1] = ch[i] == ch[i + 1]? true: false;
            if(dp[i][i + 1]) {
                ret = s.substring(i, i + 2);
            }
        }
        for(int i = 2; i < ch.length; i++) {
            for(int j = 0; j < ch.length - i; j++) {
                dp[j][j + i] = (ch[j] == ch[j + i] && dp[j + 1][j + i - 1]);
                if(dp[j][j + i]) {
                    ret = s.substring(j, j + i + 1);
                }
            }
        }
        return ret;
    }
}
