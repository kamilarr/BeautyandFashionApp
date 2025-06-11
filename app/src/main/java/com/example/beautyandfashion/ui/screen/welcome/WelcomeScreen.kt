package com.example.beautyandfashion.ui.screen.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.theme.*

@Composable
fun WelcomeScreen(navController: NavController) {
    val gradient = Brush.verticalGradient(
        colors = listOf(CreamLight, BrownLight),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Holla !",
                fontSize = 36.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = BrownDark
            )

            Text(
                text = "Beauty Smarter,\nStyle Better",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = BrownMedium
            )

            Spacer(modifier = Modifier.height(48.dp))

            Button(
                onClick = { navController.navigate("login") },
                colors = ButtonDefaults.buttonColors(containerColor = BrownDark),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(48.dp)
            ) {
                Text("Login", color = Color.White)
            }

            Button(
                onClick = { navController.navigate("signUp") },
                colors = ButtonDefaults.buttonColors(containerColor = BrownDark),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(48.dp)
            ) {
                Text("Sign Up", color = Color.White)
            }
        }
    }
}
