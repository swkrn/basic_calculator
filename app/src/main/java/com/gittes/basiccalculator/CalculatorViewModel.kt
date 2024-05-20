package com.gittes.basiccalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun enterNumber(num: Int) {
        if (state.currentNumber.length >= 12) {
            return
        }
        if (state.currentNumber == "0") {
            state = state.copy(
                currentNumber = num.toString()
            )
            return
        }

        state = state.copy(
            currentNumber = state.currentNumber + num
        )
    }


    fun enterDecimal() {
        if (state.currentNumber.contains(".")) {
            return
        }
        state = state.copy(
            currentNumber = state.currentNumber + "."
        )
    }


    fun enterOperation(operation: CalculatorOperation) {
        if (state.previousNumber == "0") {
            state = state.copy(
                previousNumber = state.currentNumber,
                currentNumber = "0",
                operation = operation
            )
            return
        }

        equal(resultToCurrentNumber = false)
        state = state.copy(
            operation = operation
        )
    }


    fun equal(resultToCurrentNumber: Boolean) {
        val number1 = state.previousNumber.toBigDecimal()
        val number2 = state.currentNumber.toBigDecimal()

        if (number1 == null || number2 == null) {
            return
        }

        val result = when (state.operation) {
            CalculatorOperation.Add -> (number1 + number2).toPlainString().removeSuffix(".0")
            CalculatorOperation.Subtract -> (number1 - number2).toPlainString().removeSuffix(".0")
            null -> return
        }

        state = state.copy(
            currentNumber = if (resultToCurrentNumber) result else "0",
            previousNumber = if (resultToCurrentNumber) "0" else result,
            operation = null
        )
    }

}