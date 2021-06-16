package com.eason.gobang

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.io.ByteArrayOutputStream

import java.io.PrintStream


internal class AppKtTest {

    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @Test
    fun should_print_message_when_game_start() {
        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
pass
请黑子(◉)输入行列坐标(如3,4):""".trimIndent()
        val gobang = mock(Gobang::class.java)
        `when`(gobang.getChessBoard()).thenReturn("pass")
        startGame(gobang)
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
    }
}