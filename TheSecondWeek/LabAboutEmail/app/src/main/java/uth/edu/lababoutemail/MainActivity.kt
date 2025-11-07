package uth.edu.lababoutemail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uth.edu.lababoutemail.ui.theme.LabAboutEmailTheme
import uth.edu.lababoutemail.screens.EmailCheckScreen   // <-- import màn hình

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabAboutEmailTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EmailCheckScreenModifier(innerPadding = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

/**
 * Bọc EmailCheckScreen để áp dụng innerPadding từ Scaffold (tránh đè status/navigation bar)
 */
@Composable
private fun EmailCheckScreenModifier(innerPadding: Modifier = Modifier) {
    EmailCheckScreen() // UI chính của bài
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewEmailCheck() {
    LabAboutEmailTheme {
        EmailCheckScreen()
    }
}
