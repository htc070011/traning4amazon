package com.bupt;

public class EditDistance {

    public int minDistance(String word1, String word2) {

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        dp[0][0] = 0;
        for(int i = 1; i <= w1.length; i++) {
            dp[i][0] = i;
        }
        for(int i = 1; i <= w2.length; i++) {
            dp[0][i] = i;
        }

        for(int i = 1; i <= w1.length; i++) {
            for(int j = 1; j <= w2.length; j++) {
                if(w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[w1.length][w2.length];
    }
}
