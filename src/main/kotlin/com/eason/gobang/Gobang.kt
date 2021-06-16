package com.eason.gobang

class Gobang(private val row: Int, private val column: Int) {
    private val points = mutableSetOf<Point>()
    private lateinit var currentPoint: Point

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
    fun setChessPiece(rowIndex: Int, columnIndex: Int) {
        val point = points.first{ it.rowIndex == rowIndex && it.columnIndex == columnIndex}
        point.setChessPiece(getNeedInputChessPiece())
        currentPoint = point
    }

    fun getNeedInputChessPiece(): ChessPiece {
        val chessPiecesMap = points.mapNotNull { it.getChesssPiece() }.groupBy { it.value }.map { it.key to it.value.size }.toMap()
        return if (chessPiecesMap.get(ChessPiece.BLACK.value)== chessPiecesMap.get(ChessPiece.WHITE.value)) ChessPiece.BLACK else ChessPiece.WHITE
    }

    fun isOver(): Boolean {
        val columnIndex = points.filter { it.getChesssPiece() != null && it.rowIndex == currentPoint.rowIndex && it.getChesssPiece() == currentPoint.getChesssPiece() }.map { it.columnIndex }.toList().sorted()
        if (columnIndex.size < 5) return false
        for (index in columnIndex) {
            if (index + 4 < column && columnIndex.containsAll((index until (index + 5)).toList())) {
                return true
            }
        }
        return false
    }
}
