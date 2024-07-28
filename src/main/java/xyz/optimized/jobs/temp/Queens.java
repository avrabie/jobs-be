package xyz.optimized.jobs.temp;

public class Queens {
    public static void main(String[] args) {
        int n = 8;
        int[] board = new int[n];
        placeQueens(board, 0, n);
        System.out.println("Done");
    }

    private static void placeQueens(int[] board, int i, int n) {
        if (i == n) {
            printBoard(board);
            System.out.println("************");
        }
        for (int j = 0; j < n; j++) {
            if(isValid(board, i, j)) {
                board[i] = j;
                placeQueens(board, i+1, n);
            }
        }


    }

    private static boolean isValid(int[] board, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == board[k] || Math.abs(i-k) == Math.abs(j-board[k])) {
                return false;
            }
        }
        return true;

//        for (int k = 0; k < i; k++) {
//            if (board[k] == j || Math.abs(board[k] - j) == Math.abs(k - i)) {
//                return false;
//            }
//        }
//        return true;
    }

    private static void printBoard(int[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i]==j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
