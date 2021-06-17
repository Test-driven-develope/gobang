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

    @Throws(InputException::class)
    fun setChessPiece(rowIndex: Int, columnIndex: Int) {
        val point = points.first { it.rowIndex == rowIndex && it.columnIndex == columnIndex }
        if (point.getChesssPiece() != null) throw InputException("输入的坐标已经有棋子了! ")
        point.setChessPiece(getNeedInputChessPiece())
        currentPoint = point
    }

    fun getNeedInputChessPiece(): ChessPiece {
        val chessPiecesMap =
            points.mapNotNull { it.getChesssPiece() }.groupBy { it.value }.map { it.key to it.value.size }.toMap()
        return if (chessPiecesMap.get(ChessPiece.BLACK.value) == chessPiecesMap.get(ChessPiece.WHITE.value)) ChessPiece.BLACK else ChessPiece.WHITE
    }

    fun isOver(): Boolean {
        return isWin() || points.filter { point -> point.getChesssPiece() != null }.count() == row * column
    }

    fun isWin(): Boolean {
        val chessPiecePoints =
            points.filter { it.getChesssPiece() != null && it.getChesssPiece() == currentPoint.getChesssPiece() }

        return when {
            isExistingFiveContinuousNaturalNumbers(chessPiecePoints.filter { it.rowIndex == currentPoint.rowIndex }.map { it.columnIndex }) -> true
            isExistingFiveContinuousNaturalNumbers(chessPiecePoints.filter { it.columnIndex == currentPoint.columnIndex }.map { it.rowIndex }) -> true
            isExistingFiveContinuousNaturalNumbers(chessPiecePoints.filter { it.columnIndex - it.rowIndex == currentPoint.columnIndex - currentPoint.rowIndex }.map { it.rowIndex }) -> true
            isExistingFiveContinuousNaturalNumbers(chessPiecePoints.filter { it.columnIndex + it.rowIndex == currentPoint.columnIndex + currentPoint.rowIndex }.map { it.rowIndex }) -> true
            else -> false
        }
    }
}
