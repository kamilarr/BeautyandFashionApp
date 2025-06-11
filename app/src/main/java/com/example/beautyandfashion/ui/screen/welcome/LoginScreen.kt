package com.example.beautyandfashion.ui.screen.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.beautyandfashion.R
import com.example.beautyandfashion.ui.theme.BrownDark
import com.example.beautyandfashion.ui.theme.BrownLight
import com.example.beautyandfashion.ui.theme.CreamLight

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val gradient = Brush.verticalGradient(
        colors = listOf(CreamLight, BrownLight)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.glammuse),
                contentDescription = "Logo",
                tint = BrownDark,
                modifier = Modifier.size(64.dp)
            )

            Text(
                text = "Welcome!",
                fontSize = 28.sp,
                fontStyle = FontStyle.Italic,
                color = BrownDark,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = "to Glammuse",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = BrownDark
            )

            // Email Field
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.85f)
            )

            // Password Field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                leadingIcon = {
                    Icon(Icons.Default.Visibility, contentDescription = null)
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.85f)
            )

            // Login Button
            Button(
                onClick = {
                    // Navigasi ke Home saat login berhasil
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = BrownDark),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text("Login", color = Color.White)
            }

            // Or Divider
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Divider(modifier = Modifier.weight(1f))
                Text(
                    "  Or  ",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = BrownDark
                )
                Divider(modifier = Modifier.weight(1f))
            }

            // Alternative login icons (placeholder)
            Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.glammuse),
                    contentDescription = "Face Login",
                    tint = BrownDark,
                    modifier = Modifier.size(32.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.glammuse),
                    contentDescription = "Ring Login",
                    tint = BrownDark,
                    modifier = Modifier.size(32.dp)
                )
            }

            // Register Now
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Don't have an account?",
                    color = Color(0xFF5D3A00)
                )
                Spacer(modifier = Modifier.width(4.dp))
                TextButton(onClick = { navController.navigate("signup") }) {
                    Text(
                        text = "Register Now",
                        color = Color(0xFFCC8866),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}