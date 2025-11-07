package uth.edu.lab02.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


@Composable
fun NumberScreen() {
    var input by remember { mutableStateOf("") }
    var numbers by remember { mutableStateOf<List<Int>>(emptyList()) }
    var isError by remember { mutableStateOf(false) }

    fun onGenerate() {
        val n = input.toIntOrNull()
        if (n != null && n > 0) {
            numbers = (1..n).toList()
            isError = false
        } else {
            numbers = emptyList()
            isError = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,              // ← căn giữa theo trục dọc
        horizontalAlignment = Alignment.CenterHorizontally     // ← căn giữa theo trục ngang
    ) {
        Text(
            text = "Thực hành 02",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                placeholder = { Text("Nhập vào số lượng") },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp)
            )

            Spacer(Modifier.width(12.dp))

            Button(
                onClick = { onGenerate() },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.height(52.dp)
            ) { Text("Tạo") }
        }

        AnimatedVisibility(visible = isError) {
            Text(
                text = "Dữ liệu bạn nhập không hợp lệ",
                color = Color(0xFFD32F2F),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }

        Spacer(Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(numbers) { num ->
                NumberPill(number = num)
            }
        }
    }
}

@Composable
private fun NumberPill(number: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .background(color = Color(0xFFE53935), shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number.toString(),
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NumberScreenPreview() {
    NumberScreen()
}
