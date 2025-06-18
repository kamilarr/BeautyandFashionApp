package com.example.beautyandfashion.ui.screen.settings

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
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
fun PremiumPlanScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Choose Your Plan",
                onBack = { navController.navigateUp() },
                icon = null
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            // Bintang
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(5) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFF744B28),
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Testimoni
            Text(
                text = "Glammuse really helps me understand my skin and style better. The tips feel personal, and the design is so clean and modern. Love it!",
                color = Color(0xFF3C2B20),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Card Plan
            val plans = listOf(
                Triple("Rookie Plan", "12 weeks Rp 169.000", "Rp140833.3 / week"),
                Triple("Welcome Plan", "12 months Rp 349.000", "Rp6647.61 / week"),
                Triple("Pro Plan", "24 months Rp 619.000", "Rp5936.60 / week")
            )

            plans.forEachIndexed { index, plan ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, Color(0xFF744B28)),
                    colors = CardDefaults.cardColors(
                        containerColor = if (index == 0) Color(0xFFB4845C) else Color(0xFFE8D7C2)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(plan.first, fontWeight = FontWeight.Bold)
                            Text(plan.second)
                        }
                        Text(plan.third)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Tombol
            Button(
                onClick = {
                    // Aksi mulai langganan
                },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB4845C),
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("START NEW JOURNEY")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Promo code
            Text(
                "I HAVE PROMO CODE",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3C2B20)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Recurring billing. Cancel Anytime",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
