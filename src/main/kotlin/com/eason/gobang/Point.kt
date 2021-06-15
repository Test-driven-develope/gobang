package com.eason.gobang

class Point(val rowIndex:Int, val columnIndex:Int) {
    fun getPointName(): String {
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
