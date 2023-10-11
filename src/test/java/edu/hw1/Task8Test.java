package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task8Test {

    @Test
    @DisplayName("Не может захватить")
    void testThatKnightBoardCaptureInDifferentPlacesReturnedTrue() {
        // given
        int[][] chessBoard = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };

        // when
        boolean cannotCapture = Task8.knightBoardCapture(chessBoard);

        // then
        assertThat(cannotCapture)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Может захватить")
    void testThatKnightBoardCaptureReturnedFalse() {
        // given
        int[][] chessBoard = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };

        // when
        boolean cannotCapture = Task8.knightBoardCapture(chessBoard);

        // then
        assertThat(cannotCapture)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Может захватить")
    void testThatKnightBoardCapture2ReturnedFalse() {
        // given
        int[][] chessBoard = {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };

        // when
        boolean cannotCapture = Task8.knightBoardCapture(chessBoard);

        // then
        assertThat(cannotCapture)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Не может захватить - подаем одного коня")
    void testThatKnightBoardHaveOnlyPieceReturnedTrue() {
        // given
        int[][] chessBoard = {
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };

        // when
        boolean cannotCapture = Task8.knightBoardCapture(chessBoard);

        // then
        assertThat(cannotCapture)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Может захватить несколько фигур")
    void testThatKnightBoardHaveTwoOptionsReturnedFalse() {
        // given
        int[][] chessBoard = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };

        // when
        boolean cannotCapture = Task8.knightBoardCapture(chessBoard);

        // then
        assertThat(cannotCapture)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Не может захватить - пустое поле")
    void testThatKnightBoardCaptureEmptyReturnedTrue() {
        // given
        int[][] chessBoard = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };

        // when
        boolean cannotCapture = Task8.knightBoardCapture(chessBoard);

        // then
        assertThat(cannotCapture)
            .isEqualTo(true);
    }
}
