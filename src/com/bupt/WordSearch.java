package com.bupt;

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        if(word == null || word.length() == 0)
            return false;
        char[] ch = word.toCharArray();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, new boolean[board.length][board[0].length], ch, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, boolean[][] visited, char[] ch, int ptr, int x, int y) {

        if(ptr >= ch.length) {
            return true;
        }

        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != ch[ptr] || visited[x][y]) {
            return false;
        }

        boolean ret = false;
        visited[x][y] = true;

        if(dfs(board, visited, ch, ptr + 1, x, y + 1) || dfs(board, visited, ch, ptr + 1, x + 1, y) ||
                dfs(board, visited, ch, ptr + 1, x - 1, y) || dfs(board, visited, ch, ptr + 1, x, y - 1))
            ret = true;

        visited[x][y] = false;

        return ret;
    }
}
