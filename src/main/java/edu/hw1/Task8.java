package edu.hw1;

public final class Task8 {
    private static final int KNIGHT_MOVE_1 = 1;
    private static final int KNIGHT_MOVE_2 = 2;
    private static final int KNIGHT_MOVE_NEGATIVE_1 = -1;
    private static final int KNIGHT_MOVE_NEGATIVE_2 = -2;

    private Task8() {
    }

    public static boolean knightBoardCapture(final int[][] chessBoard) {

        for (var row = 0; row < chessBoard.length; row++) {
            for (var colum = 0; colum < chessBoard[0].length; colum++) {
                if (chessBoard[row][colum] == 1
                    && canCapture(row, colum, chessBoard)) {
                    return false;
                }
            }
        }
        return true;
    }

    @SuppressWarnings("MagicNumber")
    private static boolean canCapture(
        final int row, final int colum, final int[][] chessBoard
    ) {
        int[] possibleRow = {
            KNIGHT_MOVE_2,
            KNIGHT_MOVE_1,
            KNIGHT_MOVE_NEGATIVE_1,
            KNIGHT_MOVE_NEGATIVE_2,
            KNIGHT_MOVE_NEGATIVE_2,
            KNIGHT_MOVE_NEGATIVE_1,
            KNIGHT_MOVE_1,
            KNIGHT_MOVE_2
        };
        int[] possibleCol = {
            KNIGHT_MOVE_1,
            KNIGHT_MOVE_2,
            KNIGHT_MOVE_2,
            KNIGHT_MOVE_1,
            KNIGHT_MOVE_NEGATIVE_1,
            KNIGHT_MOVE_NEGATIVE_2,
            KNIGHT_MOVE_NEGATIVE_2,
            KNIGHT_MOVE_NEGATIVE_1
        };

        for (var way = 0; way < possibleRow.length; way++) {
            int newRow = row + possibleRow[way];
            int newCol = colum + possibleCol[way];

            if (newRow >= 0 && newRow < chessBoard.length
                && newCol >= 0 && newCol < chessBoard[0].length) {
                if (chessBoard[newRow][newCol] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
