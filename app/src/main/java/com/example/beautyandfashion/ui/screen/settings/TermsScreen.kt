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
fun TermsOfServiceScreen(navController: NavController) {
    Scaffold(
        containerColor = Color(0xFFF9EFE6),
        topBar = {
            AppTopBar(
                title = "Terms of Service",
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
                "Syarat dan Ketentuan",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = BrownDark
                )
            )

            Text(
                "Dengan menggunakan aplikasi Beauty & Fashion Assistant, Anda menyetujui syarat dan ketentuan berikut:",
                style = MaterialTheme.typography.bodyMedium
            )

            Text("1. Penggunaan Aplikasi", fontWeight = FontWeight.SemiBold)
            Text("Aplikasi ini hanya untuk penggunaan pribadi dan tidak boleh digunakan untuk tujuan komersial tanpa izin tertulis dari pengembang.")

            Text("2. Hak Cipta", fontWeight = FontWeight.SemiBold)
            Text("Semua konten, desain, dan fitur dalam aplikasi ini adalah milik pengembang dan dilindungi oleh hukum hak cipta.")

            Text("3. Privasi", fontWeight = FontWeight.SemiBold)
            Text("Kami menghargai privasi Anda dan tidak membagikan data pribadi Anda kepada pihak ketiga tanpa persetujuan Anda.")

            Text("4. Tanggung Jawab Pengguna", fontWeight = FontWeight.SemiBold)
            Text("Pengguna bertanggung jawab penuh atas data yang mereka masukkan dan konten yang mereka unggah dalam aplikasi.")

            Text("5. Perubahan Layanan", fontWeight = FontWeight.SemiBold)
            Text("Kami berhak untuk mengubah fitur atau menghentikan layanan kapan saja dengan atau tanpa pemberitahuan.")

            Text("6. Batasan Tanggung Jawab", fontWeight = FontWeight.SemiBold)
            Text("Kami tidak bertanggung jawab atas kerugian atau kerusakan akibat penggunaan aplikasi ini.")

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                "Jika Anda memiliki pertanyaan terkait syarat dan ketentuan, silakan hubungi kami di support@beautyandfashion.app",
                style = MaterialTheme.typography.bodySmall,
                color = Color.DarkGray
            )
        }
    }
}
