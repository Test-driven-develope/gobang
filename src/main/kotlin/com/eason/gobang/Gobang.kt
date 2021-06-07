package com.eason.gobang

class Gobang(private val row: Int = 10, private val column: Int = 10) {
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
        val rowsContent = points.groupBy { it.rowIndex }.toList().joinToString(separator = "\n") {
            "${it.first} ${
                it.second.joinToString(separator = "") { point: Point -> point.getPointName() }
            }"
        }
        return """$rowHeader
$rowsContent""".trimIndent()
    }

    fun setChessPieces(rowIndex: Int, columnIndex: Int) {
        val chessPiece : ChessPiece = generateCurrentInputChessPiece(rowIndex, columnIndex);
        val point  = points.first { point -> point.rowIndex == rowIndex && point.columnIndex == columnIndex }
        point.chessPiece = chessPiece
    }

    private fun generateCurrentInputChessPiece(rowIndex: Int, columnIndex: Int): ChessPiece {
        return ChessPiece(rowIndex, columnIndex, "Black")
    }
}
