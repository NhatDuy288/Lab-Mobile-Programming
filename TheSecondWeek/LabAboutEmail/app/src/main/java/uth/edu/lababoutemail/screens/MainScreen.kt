@file:OptIn(ExperimentalMaterial3Api::class)

package uth.edu.lababoutemail.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmailCheckScreen() {
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf<String?>(null) }
    var isError by remember { mutableStateOf(false) }

    fun validate() {
        val e = email.trim()
        when {
            e.isEmpty() -> {
                message = "Email khong hop le"
                isError = true
            }
            !e.contains("@") -> {
                message = "Email khong dung dinh dang"
                isError = true
            }
            else -> {
                message = "Ban da nhap email hop le"
                isError = false
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        // SAI: horizontaAlignment  ->  ĐÚNG: horizontalAlignment
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Thuc hanh 02",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    message = null
                },
                singleLine = true,
                placeholder = { Text("Email") },
                shape = RoundedCornerShape(12.dp),
                isError = isError,
                modifier = Modifier.fillMaxWidth()
            )

            if (message != null) {
                val color = if (isError) Color(0xFFD32F2F) else Color(0xFF2E7D32)
                Text(
                    text = message!!,
                    color = color,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 12.dp)
                        .align(Alignment.Start)
                )
            } else {
                Spacer(Modifier.height(20.dp))
            }

            Button(
                onClick = { validate() },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text("Kiem tra", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
