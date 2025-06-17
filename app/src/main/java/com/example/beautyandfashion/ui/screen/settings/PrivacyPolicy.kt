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
import com.example.beautyandfashion.ui.component.AppTopBar

@Composable
fun PrivacyPolicyScreen(navController: NavController) {
    Scaffold(
        containerColor = Color(0xFFF9EFE6),
        topBar = {
            AppTopBar(
                title = "Privacy Policy",
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
                "Kebijakan Privasi",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = BrownDark
                )
            )

            Text(
                "Aplikasi Beauty & Fashion Assistant menghargai dan melindungi privasi pengguna. Berikut adalah kebijakan privasi kami:",
                style = MaterialTheme.typography.bodyMedium
            )

            Text("1. Pengumpulan Data", fontWeight = FontWeight.SemiBold)
            Text("Kami dapat mengumpulkan data seperti nama, email, dan preferensi fashion yang Anda berikan untuk meningkatkan layanan kami.")

            Text("2. Penggunaan Data", fontWeight = FontWeight.SemiBold)
            Text("Data digunakan hanya untuk keperluan internal aplikasi seperti personalisasi rekomendasi dan analisis penggunaan.")

            Text("3. Keamanan Data", fontWeight = FontWeight.SemiBold)
            Text("Kami menggunakan metode keamanan terbaik untuk menjaga data Anda agar tidak diakses oleh pihak yang tidak berwenang.")

            Text("4. Pembagian Informasi", fontWeight = FontWeight.SemiBold)
            Text("Kami tidak membagikan data pribadi Anda kepada pihak ketiga tanpa izin tertulis dari Anda.")

            Text("5. Hak Pengguna", fontWeight = FontWeight.SemiBold)
            Text("Anda memiliki hak untuk mengakses, memperbarui, dan menghapus data pribadi Anda kapan saja.")

            Text("6. Perubahan Kebijakan", fontWeight = FontWeight.SemiBold)
            Text("Kami dapat memperbarui kebijakan privasi ini dan akan memberi tahu Anda melalui aplikasi jika ada perubahan signifikan.")

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                "Jika Anda memiliki pertanyaan atau masukan terkait kebijakan privasi, silakan hubungi kami di support@beautyandfashion.app",
                style = MaterialTheme.typography.bodySmall,
                color = Color.DarkGray
            )
        }
    }
}
