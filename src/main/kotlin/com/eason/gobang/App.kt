package com.eason.gobang

import java.lang.NumberFormatException
import java.util.*

const val row = 10
const val column = 10

fun main() {
    val reader = Scanner(System.`in`)
    val gobang = Gobang(row, column)
    startGame(gobang, reader)
}

fun startGame(gobang: Gobang, reader: Scanner) {
    println(
        """
        欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
        ${gobang.getChessBoard()}
        请黑子(◉)输入行列坐标(如3,4):
    """.trimIndent()
    )
    while (!gobang.isOver()) {
        try {
            val coordinate = parseInput(reader.nextLine())
            gobang.setChessPiece(coordinate.first, coordinate.second)
        } catch (e: InputException) {
            val chessPiece = gobang.getNeedInputChessPiece()
            println("输入的坐标无效，请${if (chessPiece == ChessPiece.BLACK) "黑子(◉)" else "白子(◯)"}重新输入正确的行列坐标(如3,4):")
            continue
        }
        println(gobang.getChessBoard())
        val chessPiece = gobang.getNeedInputChessPiece()
        if (gobang.isWin()) {
            println("\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5游戏结束，恭喜${if (chessPiece == ChessPiece.WHITE) "黑子(◉)" else "白子(◯)"}获胜!\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5")
        } else {
            println("请${if (chessPiece == ChessPiece.WHITE) "白子(◯)" else "黑子(◉)"}输入行列坐标(如3,4):")
        }
    }
}

fun parseInput(input: String): Pair<Int, Int> {
    val coordinator = input.split(",")
    if (coordinator.size == 2) {
        try {
            val rowIndex = coordinator[0].toInt()
            val columnIndex = coordinator[1].toInt()
            if (rowIndex in 0 until row && columnIndex in 0 until column) return Pair(rowIndex, columnIndex)
        } catch (e: NumberFormatException) {
            throw InputException("输入的坐标无效")
        }
    }
    throw InputException("输入的坐标无效")
}