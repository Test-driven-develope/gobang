package com.eason.gobang

class Point(val rowIndex: Int, val columnIndex: Int, private val name: String) {
    private lateinit var chessPiece: ChessPiece

    fun getPointName(): String {
        if (this::chessPiece.isInitialized) {
            return "${chessPiece.value}${if (columnIndex == 9) "" else "─"}"
        }

        return name
    }

    fun setChessPiece(chessPiece: ChessPiece) {
        this.chessPiece = chessPiece
    }

    fun getChessPiece(): ChessPiece? {
        return if (this::chessPiece.isInitialized) chessPiece else null
    }
}
