package com.example.beautyandfashion.ui.screen.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Help
import androidx.compose.material3.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.component.AppTopBar
import com.example.beautyandfashion.ui.theme.BrownDark

@Composable
fun HelpScreen(navController: NavController) {
    Scaffold(
        containerColor = Color(0xFFF9EFE6),
        topBar = {
            AppTopBar(
                title = "Help",
                onBack = { navController.navigateUp() },
                icon = null
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(24.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                "Frequently Asked Questions",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = BrownDark
                )
            )

            HelpItem(
                icon = Icons.Default.Help,
                title = "Bagaimana cara menggunakan fitur Color Match?",
                description = "Buka menu Color Match dan cocokkan kulit wajahmu dengan filter dan analisis warna personalmu."
            )

            HelpItem(
                icon = Icons.Default.Help,
                title = "Apakah saya bisa mengganti foto profil?",
                description = "Ya, klik ikon pensil di atas foto di halaman Settings untuk mengganti dari galeri."
            )

            HelpItem(
                icon = Icons.Default.Help,
                title = "Bagaimana cara meng-upgrade ke Premium?",
                description = "Klik tombol 'Go Premium' di halaman Settings untuk melihat paket berlangganan."
            )

            HelpItem(
                icon = Icons.Default.Help,
                title = "Bagaimana cara menambahkan item ke Wardrobe?",
                description = "Klik tombol '+' di setiap kategori untuk menambahkan item baru."
            )

            HelpItem(
                icon = Icons.Default.Help,
                title = "Data saya disimpan di mana?",
                description = "Data disimpan secara lokal di perangkat Anda dan tidak dibagikan tanpa izin."
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Masih butuh bantuan?",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = BrownDark
                    )
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = BrownDark
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Email kami di support@beautyandfashion.app",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Composable
fun HelpItem(icon: ImageVector, title: String, description: String) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                icon,
                contentDescription = null,
                tint = BrownDark,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall,
            color = Color.DarkGray,
            modifier = Modifier.padding(start = 36.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}
