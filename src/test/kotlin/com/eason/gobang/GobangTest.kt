package com.eason.gobang

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class GobangTest {
    private val gobang: Gobang = Gobang(10, 10)

    @Test
    fun should_return_need_input_black_chess_piece_when_gobang_init() {
        val chessPiece: ChessPiece = gobang.getNeedInputChessPiece()
        Assertions.assertEquals(chessPiece, ChessPiece.BlACK)
    }

    @Test
    fun should_return_need_input_white_chess_piece_when_input_white_piece() {
        val result = gobang.setChessPieces(4, 5)
        val chessPiece: ChessPiece = gobang.getNeedInputChessPiece()
        Assertions.assertTrue(result)
        Assertions.assertEquals(chessPiece, ChessPiece.WHITE)
    }

    @Test
    fun should_return_false_when_location_existing_piece() {
        val result1 = gobang.setChessPieces(4, 5)
        val result2 = gobang.setChessPieces(4, 5)
        Assertions.assertTrue(result1)
        Assertions.assertFalse(result2)
    }

    @Test
    fun should_return_need_input_black_chess_piece_when_input_black_piece() {
        gobang.setChessPieces(4, 5)
        gobang.setChessPieces(5, 6)
        val chessPiece: ChessPiece = gobang.getNeedInputChessPiece()
        Assertions.assertEquals(chessPiece, ChessPiece.BlACK)
    }

    @Test
    fun should_return_chessboard_when_app_start() {
        val chessboard: String = gobang.getChessBoard()
        val expectChessboard: String = """
        0 1 2 3 4 5 6 7 8 9
      0 ┌─┬─┬─┬─┬─┬─┬─┬─┬─┐
      1 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      2 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      3 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      4 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      5 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      6 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      7 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      8 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      9 └─┴─┴─┴─┴─┴─┴─┴─┴─┘
        """.trimIndent()
        Assertions.assertEquals(expectChessboard, chessboard)
    }

    @Test
    fun should_return_chessboard_with_black_one_chess_pieces() {
        gobang.setChessPieces(4, 5)
        val chessboard: String = gobang.getChessBoard()
        val expectChessboard: String = """
        0 1 2 3 4 5 6 7 8 9
      0 ┌─┬─┬─┬─┬─┬─┬─┬─┬─┐
      1 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      2 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      3 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      4 ├─┼─┼─┼─┼─◉─┼─┼─┼─┤
      5 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      6 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      7 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      8 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      9 └─┴─┴─┴─┴─┴─┴─┴─┴─┘
        """.trimIndent()
        Assertions.assertEquals(expectChessboard, chessboard)
    }

    @Test
    fun should_return_chessboard_with_white_one_chess_pieces() {
        gobang.setChessPieces(4, 5)
        gobang.setChessPieces(5, 6)
        val chessboard: String = gobang.getChessBoard()
        val expectChessboard: String = """
        0 1 2 3 4 5 6 7 8 9
      0 ┌─┬─┬─┬─┬─┬─┬─┬─┬─┐
      1 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      2 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      3 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      4 ├─┼─┼─┼─┼─◉─┼─┼─┼─┤
      5 ├─┼─┼─┼─┼─┼─◯─┼─┼─┤
      6 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      7 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      8 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
      9 └─┴─┴─┴─┴─┴─┴─┴─┴─┘
        """.trimIndent()
        Assertions.assertEquals(expectChessboard, chessboard)
    }

    @Test
    fun should_return_no_win_when_app_init() {
        val isWin = gobang.isWin()
        Assertions.assertFalse(isWin)
    }

    @Test
    fun should_return_win_when_black_chess_piece_equals_5() {
        gobang.setChessPieces(2, 1)
        gobang.setChessPieces(1, 1)
        gobang.setChessPieces(3, 2)
        gobang.setChessPieces(2, 2)
        gobang.setChessPieces(4, 3)
        gobang.setChessPieces(3, 3)
        gobang.setChessPieces(5, 4)
        gobang.setChessPieces(4, 4)
        gobang.setChessPieces(6, 5)
        val isWin = gobang.isWin()
        Assertions.assertTrue(isWin)
    }

    @Test
    fun should_return_win_when_black_chess_piece_across_equals_5() {
        gobang.setChessPieces(2, 1)
        gobang.setChessPieces(1, 1)
        gobang.setChessPieces(2, 2)
        gobang.setChessPieces(1, 2)
        gobang.setChessPieces(2, 3)
        gobang.setChessPieces(1, 3)
        gobang.setChessPieces(2, 4)
        gobang.setChessPieces(1, 4)
        gobang.setChessPieces(2, 5)
        val isWin = gobang.isWin()
        Assertions.assertTrue(isWin)
    }

    @Test
    fun should_return_no_win_when_black_chess_piece_across_equals_5() {
        gobang.setChessPieces(2, 1)
        gobang.setChessPieces(1, 1)
        gobang.setChessPieces(2, 2)
        gobang.setChessPieces(1, 2)
        gobang.setChessPieces(2, 3)
        gobang.setChessPieces(1, 3)
        gobang.setChessPieces(2, 6)
        gobang.setChessPieces(1, 4)
        gobang.setChessPieces(2, 5)
        val isWin = gobang.isWin()
        Assertions.assertFalse(isWin)
    }

    @Test
    fun should_return_win_when_black_chess_piece_vertical_equals_5() {
        gobang.setChessPieces(1, 2)
        gobang.setChessPieces(1, 1)
        gobang.setChessPieces(2, 2)
        gobang.setChessPieces(2, 1)
        gobang.setChessPieces(3, 2)
        gobang.setChessPieces(3, 1)
        gobang.setChessPieces(4, 2)
        gobang.setChessPieces(4, 1)
        gobang.setChessPieces(5, 2)
        val isWin = gobang.isWin()
        Assertions.assertTrue(isWin)
    }

    @Test
    fun should_return_no_win_when_black_chess_piece_vertical_equals_5() {
        gobang.setChessPieces(1, 2)
        gobang.setChessPieces(1, 1)
        gobang.setChessPieces(2, 2)
        gobang.setChessPieces(2, 1)
        gobang.setChessPieces(3, 2)
        gobang.setChessPieces(3, 1)
        gobang.setChessPieces(4, 2)
        gobang.setChessPieces(4, 1)
        gobang.setChessPieces(7, 2)
        val isWin = gobang.isWin()
        Assertions.assertFalse(isWin)
    }

    @Test
    fun should_return_win_when_black_chess_piece_bevel_equals_5() {
        gobang.setChessPieces(6, 1)
        gobang.setChessPieces(7, 2)
        gobang.setChessPieces(5, 2)
        gobang.setChessPieces(6, 3)
        gobang.setChessPieces(4, 3)
        gobang.setChessPieces(5, 4)
        gobang.setChessPieces(3, 4)
        gobang.setChessPieces(4, 5)
        gobang.setChessPieces(2, 5)
        val isWin = gobang.isWin()
        Assertions.assertTrue(isWin)
    }

    @Test
    fun should_return_no_win_when_black_chess_piece_bevel_equals_5() {
        gobang.setChessPieces(6, 1)
        gobang.setChessPieces(7, 2)
        gobang.setChessPieces(5, 2)
        gobang.setChessPieces(6, 3)
        gobang.setChessPieces(4, 3)
        gobang.setChessPieces(5, 4)
        gobang.setChessPieces(3, 4)
        gobang.setChessPieces(4, 5)
        gobang.setChessPieces(1, 6)
        val isWin = gobang.isWin()
        Assertions.assertFalse(isWin)
    }

    @Test
    fun should_over_when_black_win() {
        gobang.setChessPieces(6, 1)
        gobang.setChessPieces(7, 2)
        gobang.setChessPieces(5, 2)
        gobang.setChessPieces(6, 3)
        gobang.setChessPieces(4, 3)
        gobang.setChessPieces(5, 4)
        gobang.setChessPieces(3, 4)
        gobang.setChessPieces(4, 5)
        gobang.setChessPieces(2, 5)
        val isOver = gobang.isOver()
        Assertions.assertTrue(isOver)
    }

    @Test
    fun should_over_when_no_left_points() {
        for (rowIndex in 0 until 10) {
            for (columnIndex in 0 until 3) {
                gobang.setChessPieces(rowIndex, columnIndex)
            }
        }

        for (rowIndex in 0 until 10) {
            gobang.setChessPieces(rowIndex, 3)
        }

        for (rowIndex in 9 downTo 0) {
            for (columnIndex in 4 until 7) {
                gobang.setChessPieces(rowIndex, columnIndex)
            }
        }

        for (rowIndex in 9 downTo 0) {
            for (columnIndex in 7 until 10) {
                gobang.setChessPieces(rowIndex, columnIndex)
            }
        }
        println(gobang.getChessBoard())
        val isOver = gobang.isOver()
        Assertions.assertTrue(isOver)
    }

}

