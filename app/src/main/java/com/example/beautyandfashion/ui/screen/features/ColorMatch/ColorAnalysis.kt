package com.example.beautyandfashion.ui.screen.features.ColorMatch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.beautyandfashion.R
import androidx.compose.ui.layout.ContentScale
import com.example.beautyandfashion.ui.component.AppTopBar

@Composable
fun ColorAnalysisScreen(navController: NavController) {
    val backgroundColor = Color(0xFFF9EFE6)
    val titleColor = Color(0xFF6B3F1D)
    val buttonColor = Color(0xFFD2A47D)
    val buttonTextColor = Color.White

    var hasPermission by remember { mutableStateOf(false) }

    // ✅ Gambar background per musim
    val backgrounds = listOf(
        R.drawable.summer,
        R.drawable.spring,
        R.drawable.winter,
        R.drawable.autumn
    )
    val backgroundLabels = listOf("Summer", "Spring", "Winter", "Autumn")
    var currentIndex by remember { mutableIntStateOf(0) }

    RequestCameraPermission(onGranted = { hasPermission = true })

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Personal Color Match",
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
                    .height(470.dp)
                    .clip(RoundedCornerShape(28.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = backgrounds[currentIndex]),
                    contentDescription = backgroundLabels[currentIndex],
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(28.dp))
                )

                if (hasPermission) {
                    CameraPreview(
                        modifier = Modifier
                            .size(160.dp)
                            .clip(CircleShape)
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .size(160.dp)
                            .clip(CircleShape)
                            .background(Color.Black)
                    )
                }

                // ✅ Tombol navigasi kiri-kanan
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {
                            currentIndex = (currentIndex - 1 + backgrounds.size) % backgrounds.size
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBackIos,
                            contentDescription = "Previous",
                            tint = Color.Black
                        )
                    }

                    IconButton(
                        onClick = {
                            currentIndex = (currentIndex + 1) % backgrounds.size
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowForwardIos,
                            contentDescription = "Next",
                            tint = Color.Black
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = backgroundLabels[currentIndex],
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = titleColor
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    navController.navigate("result/${backgroundLabels[currentIndex]}")
                },
                modifier = Modifier
                    .height(48.dp)
                    .width(220.dp),
                colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("See Description", color = buttonTextColor, fontSize = 16.sp)
            }
        }
    }
}