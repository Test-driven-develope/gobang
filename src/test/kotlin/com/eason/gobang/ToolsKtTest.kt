package com.eason.gobang

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ToolsKtTest {

    @Test
    fun should_return_false_for_1_2_3() {
        val actual = isExistingFiveContinuousNaturalNumbers(listOf(1, 2, 3))
        assertFalse(actual)
    }

    @Test
    fun should_return_true_for_1_2_3_4_5() {
        val actual = isExistingFiveContinuousNaturalNumbers(listOf(1, 2, 3, 4, 5))
        assertTrue(actual)
    }

    @Test
    fun should_return_false_for_1_2_3_5_6() {
        val actual = isExistingFiveContinuousNaturalNumbers(listOf(1, 2, 3, 5, 6))
        assertFalse(actual)
    }
}