package com.example.beautyandfashion.ui.screen.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.theme.BrownDark
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.beautyandfashion.ui.component.AppTopBar

@Composable
fun AboutUsScreen(navController: NavController) {
    Scaffold(
        containerColor = Color(0xFFF9EFE6),
        topBar = {
            AppTopBar(
                title = "About Us",
                onBack = { navController.navigateUp() },
                icon = null
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "Tentang Kami",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = BrownDark,
                    fontSize = 24.sp
                )
            )

            Text(
                "Beauty & Fashion Assistant adalah aplikasi cerdas yang dirancang untuk membantu Anda memahami, merawat, dan mengekspresikan diri melalui gaya pribadi dan kecantikan. Kami percaya bahwa setiap individu memiliki keunikan yang patut dirayakan. Dengan fitur analisis jenis kulit, rekomendasi pakaian, serta personalisasi berdasarkan preferensi Anda, aplikasi ini hadir sebagai teman setia dalam perjalanan kecantikan dan fashion Anda. Kami berkomitmen untuk memberikan pengalaman yang menyenangkan, inklusif, dan informatif agar Anda bisa tampil percaya diri setiap hari.",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 18.sp,
                    textAlign = TextAlign.Justify,
                    lineHeight = 26.sp
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                "Untuk pertanyaan atau masukan, hubungi kami di support@beautyandfashion.app",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Justify,
                    lineHeight = 22.sp
                )
            )
        }
    }
}
