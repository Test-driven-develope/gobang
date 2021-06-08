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
        gobang.setChessPieces(4, 5)
        val chessPiece: ChessPiece = gobang.getNeedInputChessPiece()
        Assertions.assertEquals(chessPiece, ChessPiece.WHITE)
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
        val chessboard:String = gobang.getChessBoard()
        val expectChessboard:String  = """
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
        val chessboard:String = gobang.getChessBoard()
        val expectChessboard:String  = """
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
        val chessboard:String = gobang.getChessBoard()
        val expectChessboard:String  = """
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
}