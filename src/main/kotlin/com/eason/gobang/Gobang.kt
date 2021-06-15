package com.eason.gobang

class Gobang(val row: Int, val column: Int) {
    private val points = mutableSetOf<Point>()

    init {
        for (rowIndex in 0 until row) {
            for (columnIndex in 0 until column) {
                points.add(Point(rowIndex, columnIndex))
            }
        }
    }

    fun getChessBoard(): String {
        val rowHeader = (0 until column).toList().joinToString(prefix = "  ", separator = " ")
        val content = points.groupBy { it.rowIndex }.toList().joinToString(separator = "\n") {
            "${it.first} ${it.second.toList().joinToString(separator = "") { it.getPointName() }}"
        }
        return rowHeader + "\n" + content
    }
}
