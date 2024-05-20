package com.gittes.basiccalculator

data class CalculatorState(
    val previousNumber: String = "0",
    val currentNumber: String = "0",
    val operation: CalculatorOperation? = null
) {
    val screenNumber = if (currentNumber != "0") currentNumber else previousNumber
}