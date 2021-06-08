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
        val chessPiece : ChessPiece = getNeedInputChessPiece()
        val point  = points.first { point -> point.rowIndex == rowIndex && point.columnIndex == columnIndex }
        point.chessPiece = chessPiece
    }

    fun getNeedInputChessPiece(): ChessPiece {
        val chessPieces = points.filter { point -> point.chessPiece != null }.map { point: Point -> point.chessPiece }
        val blackPiecesCount = chessPieces.filter{piece -> piece == ChessPiece.BlACK}.count()
        val whitePiecesCount = chessPieces.filter { piece -> piece == ChessPiece.WHITE }.count()
        return if (blackPiecesCount == whitePiecesCount) ChessPiece.BlACK else ChessPiece.WHITE
    }
}
