package com.eason.gobang

import main
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito
import org.mockito.Mockito.*
import startGame
import verifyCoordinate
import java.io.ByteArrayOutputStream

import java.io.PrintStream
import java.io.ByteArrayInputStream
import java.io.InputStream


internal class AppKtTest {

    private val outputStreamCaptor = ByteArrayOutputStream()
    private val gobang:Gobang = mock(Gobang::class.java)

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @Test
    fun should_print_chessboard_when_app_init_run() {
        val expect = """请黑子(◉)输入行列坐标(如3,4):
  0 1 2 3 4 5 6 7 8 9
0 ┌─┬─┬─┬─┬─┬─┬─┬─┬─┐
1 ├─◉─┼─┼─┼─┼─┼─┼─┼─┤
2 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
3 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
4 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
5 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
6 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
7 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
8 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
9 └─┴─┴─┴─┴─┴─┴─┴─┴─┘
💥💥💥💥💥游戏结束，恭喜黑子(◉)获胜!💥💥💥💥💥
        """.trimMargin()
        `when`(gobang.isOver()).thenReturn(false, true)
        `when`(gobang.getNeedInputChessPiece()).thenReturn(ChessPiece.BlACK)
        `when`(gobang.getChessBoard()).thenReturn("""
  0 1 2 3 4 5 6 7 8 9
0 ┌─┬─┬─┬─┬─┬─┬─┬─┬─┐
1 ├─◉─┼─┼─┼─┼─┼─┼─┼─┤
2 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
3 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
4 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
5 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
6 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
7 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
8 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
9 └─┴─┴─┴─┴─┴─┴─┴─┴─┘
""".trimMargin())
        `when`(gobang.isWin()).thenReturn(true)
        val point = Point(1, 1)
        point.setChessPiece(ChessPiece.BlACK)
        `when`(gobang.currentPoint).thenReturn(point)
        val coordinate = "1,1"
        val stream: InputStream = ByteArrayInputStream(coordinate.encodeToByteArray())
        val stdin = System.`in`
        System.setIn(stream)
        startGame(gobang)
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
        System.setIn(stdin)
    }

    @Test
    fun should_return_game_over_when_is_over_is_true() {
        `when`(gobang.isOver()).thenReturn(true)
        `when`(gobang.isWin()).thenReturn(false)
        startGame(gobang)
        val expect = "棋盘已经沾满，未分胜负，请重新开始一局吧!"
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
    }

    @Test
    fun should_return_invalid_input() {
        `when`(gobang.isOver()).thenReturn(false, true)
        `when`(gobang.getNeedInputChessPiece()).thenReturn(ChessPiece.BlACK)
        `when`(gobang.isWin()).thenReturn(false)
        val coordinate = "3,4,5"
        val stream: InputStream = ByteArrayInputStream(coordinate.encodeToByteArray())
        val stdin = System.`in`
        System.setIn(stream)
        startGame(gobang)
        val expect = """请黑子(◉)输入行列坐标(如3,4):
输入的坐标无效，请黑子(◉)重新输入正确的行列坐标(如3,4):
棋盘已经沾满，未分胜负，请重新开始一局吧!
        """.trimMargin()
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
        System.setIn(stdin)
    }

    @Test
    fun should_print_hint_when_input_coordinate_3_4_5() {
        val coordinate = "3,4,5"
        val stream: InputStream = ByteArrayInputStream(coordinate.encodeToByteArray())
        val stdin = System.`in`
        System.setIn(stream)
        val result = verifyCoordinate(coordinate)
        Assertions.assertEquals(false, result)
        System.setIn(stdin)
    }

    @Test
    fun should_print_hint_when_input_coordinate_3_4() {
        val coordinate = "3,4"
        val stream: InputStream = ByteArrayInputStream(coordinate.encodeToByteArray())
        val stdin = System.`in`
        System.setIn(stream)
        val result = verifyCoordinate(coordinate)
        Assertions.assertEquals(true, result)
        System.setIn(stdin)
    }

    @Test
    fun should_print_hint_when_input_coordinate_a_b() {
        val coordinate = "a,b"
        val stream: InputStream = ByteArrayInputStream(coordinate.encodeToByteArray())
        val stdin = System.`in`
        System.setIn(stream)
        val result = verifyCoordinate(coordinate)
        Assertions.assertEquals(false, result)
        System.setIn(stdin)
    }

    @Test
    fun should_print_hint_when_input_coordinate_10_9() {
        val coordinate = "10,9"
        val stream: InputStream = ByteArrayInputStream(coordinate.encodeToByteArray())
        val stdin = System.`in`
        System.setIn(stream)
        val result = verifyCoordinate(coordinate)
        Assertions.assertEquals(false, result)
        System.setIn(stdin)
    }

    @Test
    fun should_print_hint_when_input_coordinate_0_9() {
        val coordinate = "0,9"
        val stream: InputStream = ByteArrayInputStream(coordinate.encodeToByteArray())
        val stdin = System.`in`
        System.setIn(stream)
        val result = verifyCoordinate(coordinate)
        Assertions.assertEquals(true, result)
        System.setIn(stdin)
    }

    @Test
    fun should_print_hint_when_input_coordinate_0_0() {
        val coordinate = "0,0"
        val stream: InputStream = ByteArrayInputStream(coordinate.encodeToByteArray())
        val stdin = System.`in`
        System.setIn(stream)
        val result = verifyCoordinate(coordinate)
        Assertions.assertEquals(true, result)
        System.setIn(stdin)
    }

    @Test
    fun should_print_hint_when_input_coordinate_9_9() {
        val coordinate = "0,0"
        val stream: InputStream = ByteArrayInputStream(coordinate.encodeToByteArray())
        val stdin = System.`in`
        System.setIn(stream)
        val result = verifyCoordinate(coordinate)
        Assertions.assertEquals(true, result)
        System.setIn(stdin)
    }

}