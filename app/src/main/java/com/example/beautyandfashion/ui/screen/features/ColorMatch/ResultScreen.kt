package com.example.beautyandfashion.ui.screen.features.ColorMatch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
    // Warna sesuai desain mockup
    val backgroundColor = Color(0xFFF9EFE6)
    val containerBackground = Color(0xFFF2D2B2)
    val cardBackground = Color(0xFFF6EEDF)
    val titleColor = Color(0xFF6B3F1D)

    // Judul dan deskripsi per season
    val title = seasonType
    val description = when (seasonType) {
        "Spring" -> "Kamu punya pesona yang cerah, hangat, dan penuh energi. Warna-warna bernuansa segar dan terang sangat cocok untukmu.\n\n" +
                "Palet Spring terdiri dari warna-warna hangat seperti coral, peach, golden yellow, dan turquoise yang membuat penampilanmu terlihat lebih hidup.\n\n" +
                "Tipe Spring mencerminkan kesan ceria, youthful, dan penuh semangat."
        "Summer" -> "Kamu punya aura yang lembut dan elegan. Warna-warna bernuansa dingin dan kalem sangat cocok untukmu.\n\n" +
                "Palet Summer terdiri dari warna-warna sejuk seperti dusty blue, soft lavender, plum, dan rose mauve yang membuat kulitmu terlihat lebih cerah alami.\n\n" +
                "Tipe Summer mencerminkan kesan classy, tenang, dan effortless beauty."
        "Autumn" -> "Kamu memiliki karakter yang hangat, kuat, dan memikat. Warna-warna bernuansa earthy dan golden sangat cocok untukmu.\n\n" +
                "Palet Autumn terdiri dari warna-warna hangat dan kuat seperti terracotta, mustard, olive, dan burnt orange yang memberikan kesan hangat alami pada kulitmu.\n\n" +
                "Tipe Autumn mencerminkan kesan kalem, dewasa, tapi tetap stylish."
        "Winter" -> "Kamu memiliki aura yang tegas, elegan, dan memikat. Warna-warna bernuansa dingin dan kontras tinggi sangat cocok untukmu.\n\n" +
                "Palet Winter terdiri dari warna-warna bold seperti royal blue, fuchsia, deep, serta nuansa gelap seperti charcoal, dan emerald yang membuat penampilanmu terlihat lebih tajam dan berkelas.\n\n" +
                "Tipe Winter mencerminkan kesan kuat, modern, dan sophisticated."
        else -> ""
    }

    // Warna palet per musim
    val colorPalettes = when (seasonType) {
        "Spring" -> listOf(
            Color(0xFFFF6F61), Color(0xFFFF8C42), Color(0xFFFFD700), Color(0xFFFFFF33),
            Color(0xFF00FA9A), Color(0xFF00FFFF), Color(0xFF9B59B6), Color(0xFFFF66CC)
        )
        "Summer" -> listOf(
            Color(0xFF60A3BC), Color(0xFF3B5998), Color(0xFF3F51B5), Color(0xFF5D6D7E),
            Color(0xFF6C5B7B), Color(0xFF9B59B6), Color(0xFF6E2C00), Color(0xFFD98880)
        )
        "Autumn" -> listOf(
            Color(0xFF8B4000), Color(0xFF756A34), Color(0xFF567D46), Color(0xFF2C6E49),
            Color(0xFF3E885B), Color(0xFF1B4D3E), Color(0xFF4B0082), Color(0xFF6C3483)
        )
        "Winter" -> listOf(
            Color(0xFF00BFFF), Color(0xFF007BFF), Color(0xFF8000FF), Color(0xFFFF00FF),
            Color(0xFF8B0000), Color(0xFF2F4F4F), Color(0xFF004B49), Color(0xFF000000)
        )
        else -> emptyList()
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

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = title,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = titleColor
                )

                Spacer(modifier = Modifier.height(4.dp))

                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(3.dp)
                        .background(titleColor)
                )
            }


            Spacer(modifier = Modifier.height(30.dp))

            // Main Container
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(containerBackground, shape = RoundedCornerShape(32.dp))
                    .padding(20.dp)
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                // Color Palette Box
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(cardBackground, shape = RoundedCornerShape(16.dp))
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Your Color Type",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = titleColor
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    for (row in 0 until 2) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            for (col in 0 until 4) {
                                val colorIndex = row * 4 + col
                                if (colorIndex < colorPalettes.size) {
                                    Box(
                                        modifier = Modifier
                                            .size(70.dp)
                                            .padding(4.dp)
                                            .background(
                                                colorPalettes[colorIndex],
                                                shape = RoundedCornerShape(12.dp) // sudut lebih halus juga
                                            )
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Description
                Text(
                    text = description,
                    fontSize = 16.sp,
                    color = titleColor,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Justify
                )

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}