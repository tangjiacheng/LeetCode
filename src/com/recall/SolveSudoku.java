/*
package com.recall;

*/
/**
 * @Author: TJC
 * @Date: 2020/6/22 15:30
 * @description: TODO
 *//*

public class SolveSudoku {
    char[][] result;

    public void solveSudoku(char[][] board) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[x][y] == '.') {

                }
            }
        }
    }

    public boolean isAvailable(char[][] board, int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (i != y) {
                if (board[x][y] == board[x][i])
                    return false;
            }
            if (i != x) {
                if (board[x][y] == board[i][y])
                    return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != x%3 && j != y%3) {
                    if (board[x][y] == board[i + 3*(x/3)][j + 3*(y/3)]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public boolean fillNum(char[][] board) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[x][y] == '.') {
                    board[x][y] = '1';
                    if ()
                }
            }
        }
    }
}
*/
