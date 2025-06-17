package com.example.beautyandfashion.ui.screen.features.ColorMatch

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.component.AppTopBar

@Composable
fun ResultScreen(seasonType: String, navController: NavController) {
    val backgroundColor = Color(0xFFF9EFE6)
    val titleColor = Color(0xFF6B3F1D)

    val title = when (seasonType) {
        "Summer" -> "Summer"
        "Spring" -> "Spring"
        "Winter" -> "Winter"
        "Autumn" -> "Autumn"
        else -> "Unknown"
    }

    val description = when (seasonType) {
        "Summer" -> "Kamu punya aura yang lembut dan elegan. Warna-warna bernuansa dingin dan kalem sangat cocok untukmu..."
        "Spring" -> "Kamu tampak bersinar dengan warna-warna cerah dan hangat. Palet Spring cocok untuk kesan segar dan youthful..."
        "Winter" -> "Warna-warna kontras dan tegas seperti hitam dan biru tua cocok untukmu. Tipe Winter memberi kesan bold dan classy..."
        "Autumn" -> "Warna bumi seperti cokelat, zaitun, dan oranye membawamu terlihat hangat dan alami..."
        else -> ""
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Personal Color Analysis",
                onBack = { navController.navigateUp() },
                icon = null
            )
        },
        containerColor = backgroundColor
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Result", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = titleColor)

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD2A47D))) {
                Text(text = title, color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = description,
                fontSize = 16.sp,
                color = titleColor,
                textAlign = TextAlign.Justify
            )
        }
    }
}
