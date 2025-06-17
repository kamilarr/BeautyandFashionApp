@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.beautyandfashion.ui.screen.settings

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import com.example.beautyandfashion.R
import com.example.beautyandfashion.ui.component.AppTopBar
import com.example.beautyandfashion.ui.component.BottomBar
import com.example.beautyandfashion.ui.theme.Manrope
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun SettingsScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    // 1. State untuk URI gambar profil
    var selectedImageUri by rememberSaveable { mutableStateOf<Uri?>(null) }

    // 2. Launcher untuk membuka galeri
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Profile",
                onBack = null,
                icon = null
            )
        },
        bottomBar = {
            BottomBar(navController, "settings")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
                .fillMaxSize()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.size(100.dp)) {
                // 3. Gambar profil: tampilkan dari URI jika ada, jika tidak tampilkan default
                Image(
                    painter = if (selectedImageUri != null)
                        rememberAsyncImagePainter(selectedImageUri)
                    else
                        painterResource(R.drawable.kucing),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFDDBEA9)),
                    contentScale = ContentScale.Crop
                )

                // 4. Icon edit
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Profile Picture",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(24.dp)
                        .background(Color.White, CircleShape)
                        .padding(4.dp)
                        .clickable {
                            launcher.launch("image/*") // buka galeri
                        }
                )
            }

            Text(
                text = "Jasmine",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = Manrope,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )

            Button(
                onClick = { navController.navigate("premium") },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB4845C),
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Text("Go Premium")
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.Outlined.KeyboardArrowRight, contentDescription = null)
            }

            Spacer(modifier = Modifier.height(12.dp))

            SettingsItem("My Information", Icons.Outlined.AccountCircle)
            SettingsItem("History Recommendation", Icons.Filled.Refresh)
            SettingsItem("Terms of Service", Icons.Outlined.Settings)
            SettingsItem("Privacy Policy", Icons.Filled.Lock)
            SettingsItem("Help", Icons.Filled.Warning)
            SettingsItem("About Us", Icons.Filled.Info)
            SettingsItem("Sign Out", Icons.Filled.ExitToApp)
        }
    }
}

@Composable
fun SettingsItem(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowRight,
            contentDescription = "Next",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
    }
}
