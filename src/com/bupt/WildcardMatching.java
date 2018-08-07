package com.bupt;

public class WildcardMatching {


    /*
    *   '?' Matches any single character.
        '*' Matches any sequence of characters (including the empty sequence).
    *
    *   s = "acdcb"
        p = "a*c?b"
    * */


    public boolean isMatch(String s, String p) {

        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for(int i = 1; i <= plen; i++) {
            if(p.charAt(i - 1) == '*')
                dp[0][i] = dp[0][i - 1];
        }
        for(int i = 1; i <= slen; i++) {
            for(int j = 1; j <= plen; j++) {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if(p.charAt(j - 1) == '*') {

                        dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[slen][plen];
    }
}
