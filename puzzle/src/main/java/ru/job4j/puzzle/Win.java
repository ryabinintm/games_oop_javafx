package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        rsl = (horCheck(board) || verCheck(board)) ? true : false;
        return rsl;
    }

    public static boolean horCheck(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    break;
                }
                if (j == board.length - 1) {
                    rsl = true;
                    return rsl;
                }
            }
        }
        return rsl;
    }

    public static boolean verCheck(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 0) {  // долго думал, чтобы индексы
                    break;               // поменять местами
                }
                if (j == board.length - 1) {
                    rsl = true;
                    return rsl;
                }
            }
        }
        return rsl;
    }
}
