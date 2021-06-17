package com.eason.gobang

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito.*
import java.io.ByteArrayOutputStream

import java.io.PrintStream
import java.util.*


internal class AppKtTest {

    private val outputStreamCaptor = ByteArrayOutputStream()
    private val gobang = mock(Gobang::class.java)
    private val reader = mock(Scanner::class.java)

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
        `when`(gobang.getChessBoard()).thenReturn("pass")
    }

    @Test
    fun should_print_message_when_input_enter() {
        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
pass
请黑子(◉)输入行列坐标(如3,4):
pass
棋盘已经沾满,未分胜负,请重新开始一局吧!""".trimIndent()
        `when`(gobang.isOver()).thenReturn(false, true)
        `when`(gobang.isWin()).thenReturn(false)
        `when`(gobang.getNeedInputChessPiece()).thenReturn(ChessPiece.BLACK)
        `when`(reader.nextLine()).thenReturn("1,1")
        startGame(gobang, reader)
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
        verify(reader, times(1)).nextLine()
    }

    @Test
    fun should_print_error_message_when_black_input_aaa_bbb() {
        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
pass
请黑子(◉)输入行列坐标(如3,4):
输入的坐标无效，请黑子(◉)输入行列坐标(如3,4):
pass
棋盘已经沾满,未分胜负,请重新开始一局吧!""".trimIndent()
        `when`(gobang.isOver()).thenReturn(false, false, true)
        `when`(gobang.isWin()).thenReturn(false)
        `when`(reader.nextLine()).thenReturn("aaa,bbb", "1,1")
        `when`(gobang.getNeedInputChessPiece()).thenReturn(ChessPiece.BLACK)
        startGame(gobang, reader)
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
    }

    @Test
    fun should_print_error_message_when_white_input_aaa_bbb() {
        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
pass
请黑子(◉)输入行列坐标(如3,4):
输入的坐标无效，请黑子(◉)输入行列坐标(如3,4):
pass
棋盘已经沾满,未分胜负,请重新开始一局吧!""".trimIndent()
        `when`(gobang.isOver()).thenReturn(false, false, true)
        `when`(gobang.isWin()).thenReturn(false)
        `when`(reader.nextLine()).thenReturn("aaa,bbb", "1,1")
        `when`(gobang.getNeedInputChessPiece()).thenReturn(ChessPiece.BLACK)
        startGame(gobang, reader)
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
    }

    @Test
    fun should_print_error_message_when_white_input_coordinate_has_black_chess_piece() {
        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
pass
请黑子(◉)输入行列坐标(如3,4):
输入的坐标已经有棋子了! 棋盘已经沾满,未分胜负,请重新开始一局吧!""".trimIndent()
        `when`(gobang.isOver()).thenReturn(false, true)
        `when`(gobang.isWin()).thenReturn(false)
        `when`(gobang.setChessPiece(1, 1)).thenThrow(InputException("输入的坐标已经有棋子了! "))
        `when`(reader.nextLine()).thenReturn("1,1")
        `when`(gobang.getNeedInputChessPiece()).thenReturn(ChessPiece.BLACK)
        startGame(gobang, reader)
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
    }

    @Test
    fun should_print_message_when_input_1_1() {
        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
pass
请黑子(◉)输入行列坐标(如3,4):
pass
请白子(◯)输入行列坐标(如3,4):
pass
棋盘已经沾满,未分胜负,请重新开始一局吧!""".trimIndent()
        `when`(gobang.isOver()).thenReturn(false, false, true)
        `when`(gobang.isWin()).thenReturn(false)
        `when`(gobang.getNeedInputChessPiece()).thenReturn(ChessPiece.BLACK, ChessPiece.WHITE)
        `when`(reader.nextLine()).thenReturn("1,1")
        startGame(gobang, reader)
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
        verify(reader, times(2)).nextLine()
    }

    @Test
    fun should_print_message_when_input_1_1_2_2() {
        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
pass
请黑子(◉)输入行列坐标(如3,4):
pass
请白子(◯)输入行列坐标(如3,4):
pass
请黑子(◉)输入行列坐标(如3,4):
pass
棋盘已经沾满,未分胜负,请重新开始一局吧!""".trimIndent()
        `when`(gobang.isOver()).thenReturn(false, false, false, true)
        `when`(gobang.isWin()).thenReturn(false)
        `when`(gobang.getNeedInputChessPiece()).thenReturn(ChessPiece.BLACK, ChessPiece.WHITE, ChessPiece.BLACK)
        `when`(reader.nextLine()).thenReturn("1,1", "2,2", "3,3")
        startGame(gobang, reader)
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
        verify(reader, times(3)).nextLine()
    }

    @Test
    fun should_print_tie_message_when_input_enter() {
        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
pass
请黑子(◉)输入行列坐标(如3,4):
pass
棋盘已经沾满,未分胜负,请重新开始一局吧!""".trimIndent()
        `when`(gobang.isOver()).thenReturn(false, true)
        `when`(gobang.isWin()).thenReturn(false)
        `when`(reader.nextLine()).thenReturn("1,1")
        startGame(gobang, reader)
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
    }


    @Test
    fun gobang_should_receive_coordinate() {
        `when`(gobang.isOver()).thenReturn(false, true)
        `when`(gobang.isWin()).thenReturn(false)
        `when`(gobang.getNeedInputChessPiece()).thenReturn(ChessPiece.WHITE)
        `when`(reader.nextLine()).thenReturn("1,1")
        startGame(gobang, reader)
        verify(gobang, times(1)).setChessPiece(1, 1)
    }

    @Test
    fun black_chess_piece_win_the_game() {
        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
pass
请黑子(◉)输入行列坐标(如3,4):
pass
💥💥💥💥💥游戏结束，恭喜黑子(◉)获胜!💥💥💥💥💥""".trimIndent()
        `when`(gobang.isOver()).thenReturn(false, true)
        `when`(gobang.getNeedInputChessPiece()).thenReturn(ChessPiece.BLACK)
        `when`(reader.nextLine()).thenReturn("1,1")
        `when`(gobang.isWin()).thenReturn(true)
        startGame(gobang, reader)
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
    }

    @Test
    fun white_chess_piece_win_the_game() {
        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
pass
请黑子(◉)输入行列坐标(如3,4):
pass
请白子(◯)输入行列坐标(如3,4):
pass
💥💥💥💥💥游戏结束，恭喜白子(◯)获胜!💥💥💥💥💥""".trimIndent()
        `when`(gobang.isOver()).thenReturn(false, false, true)
        `when`(gobang.getNeedInputChessPiece()).thenReturn(ChessPiece.BLACK, ChessPiece.WHITE)
        `when`(reader.nextLine()).thenReturn("1,1")
        `when`(gobang.isWin()).thenReturn(true)
        startGame(gobang, reader)
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
    }

    @Test
    fun should_return_1_1_when_input_1_1() {
        val expect = Pair(1, 1)
        val actual = parseInput("1,1")
        Assertions.assertEquals(expect, actual)
    }

    @Test
    fun should_throw_exception_when_input_1() {
        Assertions.assertThrows(InputException::class.java) {
            parseInput("1")
        }
    }

    @Test
    fun should_throw_exception_when_input_aaa_bbb() {
        Assertions.assertThrows(InputException::class.java) {
            parseInput("aaa,bbb")
        }
    }

    @Test
    fun should_throw_exception_when_input_30_40() {
        Assertions.assertThrows(InputException::class.java) {
            parseInput("30,40")
        }
    }

    @Test
    fun should_throw_exception_when_input_negative() {
        Assertions.assertThrows(InputException::class.java) {
            parseInput("-3,4")
        }
    }

    @Test
    fun should_throw_exception_when_input_other_comma() {
        Assertions.assertThrows(InputException::class.java) {
            parseInput("1，1")
        }
    }
}