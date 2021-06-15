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
    fun should_print_message_when_game_start() {
        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
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
请黑子(◉)输入行列坐标(如3,4):""".trimIndent()
        main()
        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
    }

//    @Test
//    fun should_print_black_and_white_piece_in_gobang() {
//        val expect = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
//  0 1 2 3 4 5 6 7 8 9
//0 ┌─┬─┬─┬─┬─┬─┬─┬─┬─┐
//1 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//2 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//3 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//4 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//5 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//6 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//7 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//8 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//9 └─┴─┴─┴─┴─┴─┴─┴─┴─┘
//请黑子(◉)输入行列坐标(如3,4):
//2,2
//  0 1 2 3 4 5 6 7 8 9
//0 ┌─┬─┬─┬─┬─┬─┬─┬─┬─┐
//1 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//2 ├─┼─◉─┼─┼─┼─┼─┼─┼─┤
//3 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//4 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//5 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//6 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//7 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//8 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
//9 └─┴─┴─┴─┴─┴─┴─┴─┴─┘
//请白子(◯)输入行列坐标(如3,4):""".trimIndent()
//        main()
//        Assertions.assertEquals(expect, outputStreamCaptor.toString().trim())
//    }
}