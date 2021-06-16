package com.eason.gobang

fun isExistingFiveContinuousNaturalNumbers(list: List<Int>): Boolean {
    val sortedList = list.sorted()
    if (sortedList.count() < 5) return false
    for (number in sortedList) {
        if (number + 4 <= sortedList.last() && sortedList.containsAll((number until number + 5).toList())) {
            return true
        }
    }
    return false
}