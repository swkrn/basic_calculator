package com.gittes.basiccalculator.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gittes.basiccalculator.CalculatorOperation
import com.gittes.basiccalculator.CalculatorViewModel

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {

            Text(
                text = viewModel.state.screenNumber,
                textAlign = TextAlign.End,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )

            Box(modifier = Modifier
                .border(BorderStroke(2.dp, Color.DarkGray))
                .background(Color.White)
            ) {
                Column {
                    Row {
                        CalculatorButton(
                            text = "7",
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f),
                            onClick = { viewModel.enterNumber(7) }
                        )
                        CalculatorButton(
                            text = "8",
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f),
                            onClick = { viewModel.enterNumber(8) }
                        )
                        CalculatorButton(
                            text = "9",
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f),
                            onClick = { viewModel.enterNumber(9) }
                        )
                        CalculatorButton(
                            text = "+",
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f),
                            selected = viewModel.state.operation == CalculatorOperation.Add,
                            onClick = { viewModel.enterOperation(CalculatorOperation.Add) }
                        )
                    }

                    Row {
                        CalculatorButton(
                            text = "4",
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f),
                            onClick = { viewModel.enterNumber(4) }
                        )
                        CalculatorButton(
                            text = "5",
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f),
                            onClick = { viewModel.enterNumber(5) }
                        )
                        CalculatorButton(
                            text = "6",
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f),
                            onClick = { viewModel.enterNumber(6) }
                        )
                        CalculatorButton(
                            text = "-",
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f),
                            selected = viewModel.state.operation == CalculatorOperation.Subtract,
                            onClick = { viewModel.enterOperation(CalculatorOperation.Subtract) }
                        )
                    }

                    Row {
                        Column(
                            modifier = Modifier.weight(2f)
                        ) {
                            Row {
                                CalculatorButton(
                                    text = "1",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.enterNumber(1) }
                                )
                                CalculatorButton(
                                    text = "2",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.enterNumber(2) }
                                )
                            }
                            Row {
                                CalculatorButton(
                                    text = "0",
                                    modifier = Modifier
                                        .aspectRatio(2f),
                                    onClick = { viewModel.enterNumber(0) }
                                )
                            }
                        }
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Row {
                                CalculatorButton(
                                    text = "3",
                                    modifier = Modifier
                                        .aspectRatio(1f),
                                    onClick = { viewModel.enterNumber(3) }
                                )
                            }
                            Row {
                                CalculatorButton(
                                    text = ".",
                                    modifier = Modifier
                                        .aspectRatio(1f),
                                    onClick = { viewModel.enterDecimal() }
                                )
                            }
                        }
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Row {
                                CalculatorButton(
                                    text = "=",
                                    modifier = Modifier
                                        .aspectRatio(0.5f),
                                    onClick = { viewModel.equal(resultToCurrentNumber = true) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun CalculatorScreenPreview() {
    CalculatorScreen()
}