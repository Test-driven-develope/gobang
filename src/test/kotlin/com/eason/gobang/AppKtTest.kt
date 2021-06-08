package com.eason.gobang

import main
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import verifyCoordinate
import java.io.ByteArrayOutputStream

import java.io.PrintStream
import java.io.ByteArrayInputStream
import java.io.InputStream


internal class AppKtTest {

    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @Test
    fun should_print_chessboard_when_app_init_run() {
        val str = """欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
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
请黑子先输入行列坐标(如3,4):
输入的坐标无效，请输入正确的行列坐标(如3,4):""".trimIndent()
        main()
        Assertions.assertEquals(str, outputStreamCaptor.toString().trim())
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