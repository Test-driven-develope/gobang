package com.eason.gobang

fun main() {
    println("欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):")
    val gobang = Gobang(10, 10)
    println(gobang.getChessBoard())
    println("请黑子(◉)输入行列坐标(如3,4):")
}