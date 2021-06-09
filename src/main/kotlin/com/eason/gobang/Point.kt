package com.eason.gobang

class Point(val rowIndex: Int, val columnIndex: Int) {
    private lateinit var chessPiece: ChessPiece

    fun setChessPiece(piece: ChessPiece): Boolean {
        if (this::chessPiece.isInitialized) {
            return false
        }
        chessPiece = piece
        return true
    }

    fun getChessPiece(): ChessPiece? {
        return if (this::chessPiece.isInitialized) chessPiece else null
    }

    fun getPointName(): String {
        if (this::chessPiece.isInitialized) {
            return "${chessPiece.value}${if (columnIndex == 9) "" else "─"}"
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
}