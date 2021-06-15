package com.eason.gobang

class Point(val rowIndex:Int, val columnIndex:Int) {
    private lateinit var chessPiece:ChessPiece

    fun getPointName(): String {
        if (this::chessPiece.isInitialized) {
            return chessPiece.value + "─"
        }

        return when {
            rowIndex == 0 && columnIndex in 1 until 9 -> "┬─"
            rowIndex == 9 && columnIndex in 1 until 9 -> "┴─"
            columnIndex == 0 && rowIndex in 1 until 9 -> "├─"
            columnIndex == 9 && rowIndex in 1 until 9 -> "┤"
            rowIndex == 0 && columnIndex == 0 -> "┌─"
            rowIndex == 9 && columnIndex == 0 -> "└─"
            rowIndex == 0 && columnIndex == 9 -> "┐"
            rowIndex == 9 && columnIndex == 9 -> "┘"
            else -> "┼─"
        }
    }

    fun setChessPiece(chessPiece: ChessPiece) {
        this.chessPiece = chessPiece
    }

    fun getChesssPiece(): ChessPiece? {
        if (this::chessPiece.isInitialized) {
            return chessPiece
        }
        return null
    }
}
