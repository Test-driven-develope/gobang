package com.eason.gobang

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GobangTest {

    @Test
    fun should_print_black_piece_in_chess_board() {
        val except = """  0 1 2 3 4 5 6 7 8 9
0 ┌─┬─┬─┬─┬─┬─┬─┬─┬─┐
1 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
2 ├─┼─◉─┼─┼─┼─┼─┼─┼─┤
3 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
4 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
5 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
6 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
7 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
8 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
9 └─┴─┴─┴─┴─┴─┴─┴─┴─┘""".trimIndent()
        val gobang = Gobang(10, 10)
        gobang.setChessPiece(2, 2)
        val chessBoard = gobang.getChessBoard()
        assertEquals(except, chessBoard)
    }

    @Test
    fun should_print_black_and_white_piece_in_chess_board() {
        val except = """  0 1 2 3 4 5 6 7 8 9
0 ┌─┬─┬─┬─┬─┬─┬─┬─┬─┐
1 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
2 ├─┼─◉─┼─┼─┼─┼─┼─┼─┤
3 ├─┼─┼─◯─┼─┼─┼─┼─┼─┤
4 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
5 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
6 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
7 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
8 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
9 └─┴─┴─┴─┴─┴─┴─┴─┴─┘""".trimIndent()
        val gobang = Gobang(10, 10)
        gobang.setChessPiece(2, 2)
        gobang.setChessPiece(3, 3)
        val chessBoard = gobang.getChessBoard()
        assertEquals(except, chessBoard)
    }
}