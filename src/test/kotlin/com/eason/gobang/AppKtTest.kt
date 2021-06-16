package com.eason.gobang

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito.*
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream

import java.io.PrintStream
import java.util.*


internal class AppKtTest {

    private val outputStreamCaptor = ByteArrayOutputStream()
    private val gobang = mock(Gobang::class.java)
    private val reader = mock(Scanner::class.java)

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @Test
    fun should_print_message_when_input_enter() {
        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
pass
请黑子(◉)输入行列坐标(如3,4):""".trimIndent()
        `when`(gobang.getChessBoard()).thenReturn("pass")
        `when`(gobang.isOver()).thenReturn(true)
        val stream: InputStream = ByteArrayInputStream("\r".encodeToByteArray())
        System.setIn(stream)
        startGame(gobang, reader)
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
        verify(reader, times(0)).nextLine()
    }

    @Test
    fun should_print_message_when_input_1_1() {
        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
pass
请黑子(◉)输入行列坐标(如3,4):
pass
请白子(◯)输入行列坐标(如3,4):""".trimIndent()
        `when`(gobang.getChessBoard()).thenReturn("pass")
        `when`(gobang.isOver()).thenReturn(false, true)
        `when`(gobang.getNeedInputChessPiece()).thenReturn(ChessPiece.BLACK)
        `when`(reader.nextLine()).thenReturn("1,1")
        val stream: InputStream = ByteArrayInputStream("1,1\r".encodeToByteArray())
        System.setIn(stream)
        startGame(gobang, reader)
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
        verify(reader, times(1)).nextLine()
    }

    @Test
    fun should_print_message_when_input_1_1_2_2() {
        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
pass
请黑子(◉)输入行列坐标(如3,4):
pass
请白子(◯)输入行列坐标(如3,4):
pass
请黑子(◉)输入行列坐标(如3,4):""".trimIndent()
        `when`(gobang.getChessBoard()).thenReturn("pass")
        `when`(gobang.isOver()).thenReturn(false, false, true)
        `when`(gobang.getNeedInputChessPiece()).thenReturn(ChessPiece.BLACK, ChessPiece.WHITE)
        `when`(reader.nextLine()).thenReturn("1,1","2,2")
        val stream: InputStream = ByteArrayInputStream("1,1\r2,2\r".encodeToByteArray())
        System.setIn(stream)
        startGame(gobang, reader)
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
    }

    @Test
    fun gobang_should_receive_coordinate() {
        `when`(gobang.getChessBoard()).thenReturn("pass")
        `when`(gobang.isOver()).thenReturn(false, true)
        `when`(gobang.getNeedInputChessPiece()).thenReturn(ChessPiece.BLACK)
        `when`(reader.nextLine()).thenReturn("1,1")
        val stream: InputStream = ByteArrayInputStream("1,1\r".encodeToByteArray())
        System.setIn(stream)
        startGame(gobang, reader)
        verify(gobang, times(1)).setChessPiece(1, 1)
    }
}