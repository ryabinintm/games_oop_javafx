package ru.job4j.puzzle;

public class Win {

    public static boolean check(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                if (horCheck(board, i) || verCheck(board, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean horCheck(int[][] board, int cell) {
        var result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[cell][i] == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean verCheck(int[][] board, int cell) {
        var result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][cell] == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
