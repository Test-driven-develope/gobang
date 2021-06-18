package com.eason.gobang

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream

import java.io.PrintStream


internal class AppKtTest {

    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @Test
    fun should_print_chessboard_when_app_init_run() {
        val expect = "欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):"
        main()
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
    }
}