package com.eason.gobang

class Gobang(row: Int = 10, column: Int = 10) {
    private val row = row
    private val column = column
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
        val rowsContent = points.groupBy { it.rowIndex }.toList()
            .map {
                "${it.first} ${
                    it.second.map { point: Point -> point.getPointName() }.joinToString(separator = "")
                }"
            }
            .joinToString(separator = "\n")
        return """${rowHeader}
${rowsContent}""".trimIndent()
    }
}
