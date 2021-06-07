package com.eason.gobang

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class GobangTest {
    private val gobang: Gobang = Gobang(10, 10)

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
}