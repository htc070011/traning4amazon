package com.bupt;

public class MinimumPathSum {


    /*
    *
    *Given a m x n grid filled with non-negative numbers,
    *find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
    *
    *   [1,3,1],
        [1,5,1],
        [4,2,1]
    *
    *
    * */
    public int minPathSum(int[][] grid) {

        if(grid == null || grid.length == 0)
            return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0) {
                    dp[i][j] = j == 0? grid[0][0]: dp[i][j - 1] + grid[0][j];
                } else if(j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][0];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }


}
