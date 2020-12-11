package ru.job4j.puzzle;

public class Win {

    public static boolean check(int[][] board) {
        /*============================= One line ===============================================================
        return diagonal(board) != 1 && (horCheck(board, diagonal(board)) || verCheck(board, diagonal(board)));
        ======================================================================================================*/
        var crossCell = diagonal(board);
        if (crossCell != -1) {
            return horCheck(board, crossCell) || verCheck(board, crossCell);
        }
        return false;
    }

    private static int diagonal(int[][] board) {
        var index = -1;
        while (++index < board.length) {
            if (board[index][index] != 0) {
                return index;
            }
        }
        return -1;
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
