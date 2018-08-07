package com.bupt;

import org.junit.Test;

public class RegularExpressionMatching {

    @Test
    public void test() {
        String s = "";
        String p = ".*";
        boolean ret = isMatch(s, p);
        System.out.println(ret);
    }

    public boolean isMatch(String s, String p) {

        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;

        for(int i = 1; i <= plen; i++) {
            if(p.charAt(i - 1) == '*')
                dp[0][i] = dp[0][i - 2];
        }

        for(int i = 1; i <= slen; i++) {
            for(int j = 1; j <= plen; j++) {
                if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if(p.charAt(j - 1) == '*') {
                        if(p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1))
                            dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
                        else
                            dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[slen][plen];
    }

}
