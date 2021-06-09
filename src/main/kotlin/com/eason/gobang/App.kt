package com.eason.gobang

import java.lang.Exception
import java.util.*

fun main() {
    println("欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):")
    val gobang = Gobang(10, 10)
    println(gobang.getChessBoard())
    startGame(gobang)
}

fun startGame(gobang: Gobang) {
    while (!gobang.isOver()) {
        val color = if (gobang.getNeedInputChessPiece() == ChessPiece.BlACK) "黑子(◉)" else "白子(◯)"
        val reader = Scanner(System.`in`)
        println("请${color}输入行列坐标(如3,4):")
        val coordinate = reader.nextLine()
        if (!coordinate.isNullOrBlank() && verifyCoordinate(coordinate)) {
            gobang.setChessPieces(coordinate.split(",")[0].toInt(), coordinate.split(",")[1].toInt())
            println(gobang.getChessBoard())
        } else {
            println("输入的坐标无效，请${color}重新输入正确的行列坐标(如3,4):")
        }
    }
    if (gobang.isWin()) {
        println("\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5游戏结束，恭喜${if (gobang.currentPoint.getChessPiece() == ChessPiece.BlACK) "黑子(◉)" else "白子(◯)"}获胜!\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5")
    } else {
        println("棋盘已经沾满，未分胜负，请重新开始一局吧!")
    }
}

fun verifyCoordinate(coordinate: String): Boolean {
    val splitCoordinate = coordinate.split(",")
    if (splitCoordinate.size == 2) {
        try {
            val firstValue = splitCoordinate[0].toInt()
            val secondValue = splitCoordinate[1].toInt()
            if (firstValue in 0..9 && secondValue in 0..9) {
                return true
            }
        } catch (e: Exception) {
            return false
        }
    }

    return false
}