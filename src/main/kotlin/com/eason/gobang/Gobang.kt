package com.eason.gobang

class Gobang(private val row: Int = 10, private val column: Int = 10) {
    private val points = mutableSetOf<Point>()
    lateinit var currentPoint: Point

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
        return rowHeader + "\n" + rowsContent
    }

    fun setChessPieces(rowIndex: Int, columnIndex: Int): Boolean {
        currentPoint = points.first { point -> point.rowIndex == rowIndex && point.columnIndex == columnIndex }
        return currentPoint.setChessPiece(getNeedInputChessPiece())
    }

    fun getNeedInputChessPiece(): ChessPiece {
        val chessPieces =
            points.filter { point -> point.getChessPiece() != null }.map { point: Point -> point.getChessPiece() }
        val blackPiecesCount = chessPieces.filter { piece -> piece == ChessPiece.BlACK }.count()
        val whitePiecesCount = chessPieces.filter { piece -> piece == ChessPiece.WHITE }.count()
        return if (blackPiecesCount == whitePiecesCount) ChessPiece.BlACK else ChessPiece.WHITE
    }

    fun isWin(): Boolean {
        val sameChessPiecePoints =
            points.filter { point -> point.getChessPiece() != null && point.getChessPiece() == currentPoint.getChessPiece() }

        return when {
            sameChessPiecePoints.count() < 5 -> false
            isHaveSerialFivePoints(getAcrossPointsColumnIndexes(sameChessPiecePoints)) -> true
            isHaveSerialFivePoints(getVerticalPointsRowIndexes(sameChessPiecePoints)) -> true
            isHaveSerialFivePoints(getPositiveRakePointsRowIndexes(sameChessPiecePoints)) -> true
            isHaveSerialFivePoints(getBevelPointsRowIndexes(sameChessPiecePoints)) -> true
            else -> false
        }
    }

    private fun getAcrossPointsColumnIndexes(points: List<Point>): List<Int> {
        return points.filter { point -> point.rowIndex == currentPoint.rowIndex }
            .map { it.columnIndex }.sorted()
    }

    private fun getVerticalPointsRowIndexes(points: List<Point>): List<Int> {
        return points.filter { point -> point.columnIndex == currentPoint.columnIndex }
            .map { it.rowIndex }.sorted()
    }

    private fun getPositiveRakePointsRowIndexes(points: List<Point>): List<Int> {
        return points.filter { point -> point.rowIndex - point.columnIndex == currentPoint.rowIndex - currentPoint.columnIndex }
            .map { it.rowIndex }.sorted()
    }

    private fun getBevelPointsRowIndexes(points: List<Point>): List<Int> {
        return points.filter { point -> point.rowIndex + point.columnIndex == currentPoint.rowIndex + currentPoint.columnIndex }
            .map { it.rowIndex }.sorted()
    }

    private fun isHaveSerialFivePoints(indexes: List<Int>): Boolean {
        if (indexes.count() < 5) {
            return false
        }

        val allIndexes = indexes.minOrNull()!!.rangeTo(indexes.maxOrNull()!!)
        val leftPoints = allIndexes.subtract(indexes)

        if (allIndexes.count() >= 5 && leftPoints.count() == 0) {
            return true
        }

        leftPoints.forEachIndexed { index, value ->
            if (index + 1 == leftPoints.count()) {
                return false
            }

            if (leftPoints.elementAt(index + 1) - value >= 5) {
                return true
            }
        }
        return false
    }

    fun isOver(): Boolean {
        return isWin() || points.filter { point -> point.getChessPiece() != null }.count() == row * column
    }
}
