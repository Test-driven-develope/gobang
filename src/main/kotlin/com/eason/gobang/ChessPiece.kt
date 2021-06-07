package com.eason.gobang

class ChessPiece(private val rowIndex: Int, private val columnIndex: Int, private val name: String) {

    fun getPrintValue(): String {
        return if (name == "Black") "◉" else "◯"
    }
}