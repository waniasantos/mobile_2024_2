package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CounterApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CounterApp() {
    var result by remember { mutableDoubleStateOf(0.0) }
    var input by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Resultado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(colorResource(R.color.blue_paws_desaturated))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.result_text, result),
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.black_desatureted)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de entrada
        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            label = {
                Text(text = stringResource(R.string.input_hint))
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(R.color.blue_paws),
                unfocusedBorderColor = colorResource(R.color.blue_paws),
                focusedLabelColor = colorResource(R.color.blue_paws),
                unfocusedLabelColor = colorResource(R.color.black_desatureted),
                cursorColor = colorResource(R.color.blue_paws)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botões de operação
        @Composable
        fun StyledButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
            Button(
                onClick = onClick,
                modifier = modifier,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.blue_paws),
                    contentColor = colorResource(R.color.white)
                )
            ) {
                Text(text)
            }
        }

        @Composable
        fun StyledButtonClear(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
            Button(
                onClick = onClick,
                modifier = modifier,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.clear),
                    contentColor = colorResource(R.color.white)
                )
            ) {
                Text(text)
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            StyledButton(
                text = stringResource(R.string.increment),
                onClick = { result += 1.0 },
                modifier = Modifier.weight(1f)
            )

            StyledButton(
                text = stringResource(R.string.decrement),
                onClick = { result -= 1.0 },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            StyledButton(
                text = stringResource(R.string.add),
                onClick = {
                    result += input.toDoubleOrNull() ?: 0.0
                    input = ""
                },
                modifier = Modifier.weight(1f)
            )

            StyledButton(
                text = stringResource(R.string.subtract),
                onClick = {
                    result -= input.toDoubleOrNull() ?: 0.0
                    input = ""
                },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            StyledButton(
                text = stringResource(R.string.multiply),
                onClick = {
                    result *= input.toDoubleOrNull() ?: 1.0
                    input = ""
                },
                modifier = Modifier.weight(1f)
            )

            StyledButton(
                text = stringResource(R.string.divide),
                onClick = {
                    val value = input.toDoubleOrNull() ?: 1.0
                    if (value != 0.0) {
                        result /= value
                    }
                    input = ""
                },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            StyledButton(
                text = stringResource(R.string.power),
                onClick = {
                    val value = input.toDoubleOrNull() ?: 0.0
                    result = result.pow(value)
                    input = ""
                },
                modifier = Modifier.weight(1f)
            )

            StyledButton(
                text = stringResource(R.string.sqrt),
                onClick = {
                    if (result >= 0) {
                        result = sqrt(result)
                    }
                },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Botão "Módulo"
        StyledButton(
            text = stringResource(R.string.modulo),
            onClick = {
                val value = input.toDoubleOrNull() ?: 1.0
                result %= value
                input = ""
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        // Botão "Limpar"
        StyledButtonClear(
            text = stringResource(R.string.clear),
            onClick = {
                result = 0.0
                input = ""
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp)
        )
    }
}
