package com.eason.gobang

import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    val gobang = Gobang(10, 10)
    startGame(gobang, reader)
}

fun startGame(gobang: Gobang, reader: Scanner) {
    println("欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):")
    println(gobang.getChessBoard())
    println("请黑子(◉)输入行列坐标(如3,4):")
    while (!gobang.isOver()) {
        val coordinate = reader.nextLine()
        gobang.setChessPiece(coordinate.split(",")[0].toInt(), coordinate.split(",")[1].toInt())
        println(gobang.getChessBoard())
        val chessPiece = gobang.getNeedInputChessPiece()
        if (gobang.isWin()) {
            println(if (chessPiece == ChessPiece.WHITE) "\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5游戏结束，恭喜黑子(◉)获胜!\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5" else "\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5游戏结束，恭喜白子(◯)获胜!\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5")
        } else {
            println(if (chessPiece == ChessPiece.WHITE) "请白子(◯)输入行列坐标(如3,4):" else "请黑子(◉)输入行列坐标(如3,4):")
        }
    }
}