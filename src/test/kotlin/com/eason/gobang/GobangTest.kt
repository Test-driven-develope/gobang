package com.eason.gobang

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GobangTest {

    private val gobang = Gobang(10, 10)

    @Test
    fun should_get_init_chess_board() {
        val except = """  0 1 2 3 4 5 6 7 8 9
0 ┌─┬─┬─┬─┬─┬─┬─┬─┬─┐
1 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
2 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
3 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
4 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
5 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
6 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
7 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
8 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
9 └─┴─┴─┴─┴─┴─┴─┴─┴─┘"""
        val actual = gobang.getChessBoard()
        assertEquals(except, actual)
    }

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
        gobang.setChessPiece(2, 2)
        gobang.setChessPiece(3, 3)
        val chessBoard = gobang.getChessBoard()
        assertEquals(except, chessBoard)
    }

    @Test
    fun should_return_true_when_five_continuous_chess_pieces() {
        gobang.setChessPiece(2,1)
        gobang.setChessPiece(3,1)
        gobang.setChessPiece(2,2)
        gobang.setChessPiece(3, 2)
        gobang.setChessPiece(2, 3)
        gobang.setChessPiece(3, 3)
        gobang.setChessPiece(2, 4)
        gobang.setChessPiece(3, 4)
        gobang.setChessPiece(2, 5)
        val win = gobang.isWin()
        assertTrue(win)
    }

    @Test
    fun should_return_false_when_three_continuous_chess_pieces() {
        gobang.setChessPiece(2,1)
        gobang.setChessPiece(3,1)
        gobang.setChessPiece(2,2)
        gobang.setChessPiece(3, 2)
        gobang.setChessPiece(2, 3)
        val win = gobang.isWin()
        assertFalse(win)
    }

    @Test
    fun should_return_false_when_five_not_continuous_chess_pieces() {
        gobang.setChessPiece(2,1)
        gobang.setChessPiece(3,1)
        gobang.setChessPiece(2,2)
        gobang.setChessPiece(3, 2)
        gobang.setChessPiece(2, 3)
        gobang.setChessPiece(3, 3)
        gobang.setChessPiece(2, 4)
        gobang.setChessPiece(3, 4)
        gobang.setChessPiece(2, 8)
        val win = gobang.isWin()
        assertFalse(win)
    }

    @Test
    fun should_return_false_when_five_across_chess_pieces() {
        gobang.setChessPiece(2,1)
        gobang.setChessPiece(3,1)
        gobang.setChessPiece(2,2)
        gobang.setChessPiece(3, 2)
        gobang.setChessPiece(2, 3)
        gobang.setChessPiece(3, 3)
        gobang.setChessPiece(2, 4)
        gobang.setChessPiece(2, 5)
        gobang.setChessPiece(2, 8)
        val win = gobang.isWin()
        assertFalse(win)
    }

    @Test
    fun should_return_false_when_gobang_init() {
        val over = gobang.isOver()
        assertFalse(over)
    }

    @Test
    fun should_return_true_when_five_continuous_chess_pieces_in_vertical() {
        gobang.setChessPiece(2,1)
        gobang.setChessPiece(2,2)
        gobang.setChessPiece(3,1)
        gobang.setChessPiece(3, 2)
        gobang.setChessPiece(4, 1)
        gobang.setChessPiece(4, 2)
        gobang.setChessPiece(5, 1)
        gobang.setChessPiece(5, 2)
        gobang.setChessPiece(6, 1)
        val win = gobang.isWin()
        assertTrue(win)
    }

    @Test
    fun should_return_false_when_thre_continuous_chess_pieces_in_vertical() {
        gobang.setChessPiece(2,1)
        gobang.setChessPiece(2,2)
        gobang.setChessPiece(3,1)
        gobang.setChessPiece(3, 2)
        gobang.setChessPiece(4, 1)
        val win = gobang.isWin()
        assertFalse(win)
    }

    @Test
    fun should_return_false_when_five_not_continuous_chess_pieces_in_vertical() {
        gobang.setChessPiece(2,1)
        gobang.setChessPiece(2,2)
        gobang.setChessPiece(3,1)
        gobang.setChessPiece(3, 2)
        gobang.setChessPiece(4, 1)
        gobang.setChessPiece(4, 2)
        gobang.setChessPiece(5, 1)
        gobang.setChessPiece(5, 2)
        gobang.setChessPiece(7, 1)
        val win = gobang.isWin()
        assertFalse(win)
    }

    @Test
    fun should_return_false_when_white_and_black_chess_pieces_in_vertical() {
        gobang.setChessPiece(1, 1)
        gobang.setChessPiece(2,1)
        gobang.setChessPiece(3,1)
        gobang.setChessPiece(4,1)
        gobang.setChessPiece(5, 1)
        gobang.setChessPiece(6, 1)
        gobang.setChessPiece(7, 1)
        gobang.setChessPiece(8, 1)
        gobang.setChessPiece(9, 1)
        val win = gobang.isWin()
        assertFalse(win)
    }

    @Test
    fun should_return_true_when_black_chess_pieces_are_five_continuous_in_backslash() {
        gobang.setChessPiece(1, 1)
        gobang.setChessPiece(2,1)
        gobang.setChessPiece(2,2)
        gobang.setChessPiece(3,1)
        gobang.setChessPiece(3, 3)
        gobang.setChessPiece(4, 1)
        gobang.setChessPiece(4, 4)
        gobang.setChessPiece(5, 1)
        gobang.setChessPiece(5, 5)
        val win = gobang.isWin()
        assertTrue(win)
    }

    @Test
    fun should_return_false_when_black_chess_pieces_are_three_continuous_in_backslash() {
        gobang.setChessPiece(1, 1)
        gobang.setChessPiece(2,1)
        gobang.setChessPiece(2,2)
        gobang.setChessPiece(3,1)
        gobang.setChessPiece(3, 3)
        val win = gobang.isWin()
        assertFalse(win)
    }

    @Test
    fun should_return_false_when_black_chess_pieces_are_five_not_continuous_in_backslash() {
        gobang.setChessPiece(1, 1)
        gobang.setChessPiece(2,1)
        gobang.setChessPiece(2,2)
        gobang.setChessPiece(3,1)
        gobang.setChessPiece(3, 3)
        gobang.setChessPiece(4, 1)
        gobang.setChessPiece(4, 4)
        gobang.setChessPiece(5, 1)
        gobang.setChessPiece(6, 6)
        gobang.setChessPiece(6, 1)
        gobang.setChessPiece(7, 7)
        val win = gobang.isWin()
        assertFalse(win)
    }

    @Test
    fun should_return_false_when_black_or_white_chess_pieces_are_five_not_continuous_in_backslash() {
        gobang.setChessPiece(1, 1)
        gobang.setChessPiece(2,2)
        gobang.setChessPiece(3, 3)
        gobang.setChessPiece(4, 4)
        gobang.setChessPiece(5, 5)
        gobang.setChessPiece(6, 6)
        gobang.setChessPiece(7, 7)
        gobang.setChessPiece(8, 8)
        gobang.setChessPiece(9, 9)
        val win = gobang.isWin()
        assertFalse(win)
    }

    @Test
    fun should_return_true_when_black_chess_pieces_are_five_continuous_in_slash() {
        gobang.setChessPiece(8, 1)
        gobang.setChessPiece(9,1)
        gobang.setChessPiece(7,2)
        gobang.setChessPiece(8,2)
        gobang.setChessPiece(6, 3)
        gobang.setChessPiece(7, 3)
        gobang.setChessPiece(5, 4)
        gobang.setChessPiece(6, 4)
        gobang.setChessPiece(4, 5)
        val win = gobang.isWin()
        assertTrue(win)
    }

    @Test
    fun should_return_false_when_black_chess_pieces_are_three_continuous_in_slash() {
        gobang.setChessPiece(8, 1)
        gobang.setChessPiece(9,1)
        gobang.setChessPiece(7,2)
        gobang.setChessPiece(8,2)
        gobang.setChessPiece(6, 3)
        val win = gobang.isWin()
        assertFalse(win)
    }

    @Test
    fun should_return_false_when_black_chess_pieces_are_five_not_continuous_in_slash() {
        gobang.setChessPiece(8, 1)
        gobang.setChessPiece(9,1)
        gobang.setChessPiece(7,2)
        gobang.setChessPiece(8,2)
        gobang.setChessPiece(6, 3)
        gobang.setChessPiece(7, 3)
        gobang.setChessPiece(5, 4)
        gobang.setChessPiece(6, 4)
        gobang.setChessPiece(3, 6)
        val win = gobang.isWin()
        assertFalse(win)
    }

    @Test
    fun should_return_false_when_black_or_white_chess_pieces_are_five_not_continuous_in_slash() {
        gobang.setChessPiece(9, 0)
        gobang.setChessPiece(8, 1)
        gobang.setChessPiece(7,2)
        gobang.setChessPiece(6, 3)
        gobang.setChessPiece(5, 4)
        gobang.setChessPiece(4, 5)
        gobang.setChessPiece(3, 6)
        gobang.setChessPiece(2, 7)
        gobang.setChessPiece(1, 8)
        gobang.setChessPiece(0, 9)
        val win = gobang.isWin()
        assertFalse(win)
    }

}