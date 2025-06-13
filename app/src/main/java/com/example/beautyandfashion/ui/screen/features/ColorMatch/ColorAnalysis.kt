@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.beautyandfashion.ui.screen.features.ColorMatch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.component.AppTopBar

@Composable
fun ColorAnalysisScreen(navController: NavController) {
    val backgroundColor = Color(0xFFF9EFE6)
    val titleColor = Color(0xFF6B3F1D)
    val boxColor = Color.White
    val buttonColor = Color(0xFFD2A47D)
    val buttonTextColor = Color.White

    var hasPermission by remember { mutableStateOf(false) }

    // Launch permission request when Composable first loads
    RequestCameraPermission(onGranted = { hasPermission = true })

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
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Color Match",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = titleColor
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Choose your true color!",
                fontSize = 16.sp,
                color = titleColor,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(color = boxColor, shape = RoundedCornerShape(28.dp)),
                contentAlignment = Alignment.Center
            ) {
                if (hasPermission) {
                    CameraPreview(
                        modifier = Modifier
                            .size(140.dp)
                            .clip(CircleShape)
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .size(140.dp)
                            .clip(CircleShape)
                            .background(Color.Black)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    // TODO: Navigasi ke halaman rekomendasi
                },
                modifier = Modifier
                    .height(48.dp)
                    .width(220.dp),
                colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("See Recommendation", color = buttonTextColor, fontSize = 16.sp)
            }
        }
    }
}
