package com.eason.gobang

class Point(val rowIndex: Int, val columnIndex: Int) {
    var chessPiece: ChessPiece ?= null

    fun getPointName(): String {
        if (this.chessPiece != null) {
            return "${chessPiece!!.value}─"
        }

        if (rowIndex == 0 && columnIndex in 1 until 9) {
            return "┬─"
        }

        if (rowIndex == 9 && columnIndex in 1 until 9) {
            return "┴─"
        }

        if (columnIndex == 0 && rowIndex in 1 until 9) {
            return "├─"
        }

        if (columnIndex == 9 && rowIndex in 1 until 9) {
            return "┤"
        }

        if (rowIndex == 0 && columnIndex == 0) {
            return "┌─"
        }

        if (rowIndex == 9 && columnIndex == 0) {
            return "└─"
        }

        if (rowIndex == 0 && columnIndex == 9) {
            return "┐"
        }

        if (rowIndex == 9 && columnIndex == 9) {
            return "┘"
        }
        return "┼─"
    }
}