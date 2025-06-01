@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.beautyandfashion.ui.screen.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.component.BottomBar
import com.example.beautyandfashion.ui.theme.BrownDark

@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BrownDark, titleContentColor = MaterialTheme.colorScheme.onPrimary)
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
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Hello, Jasmine 👋", style = MaterialTheme.typography.titleMedium)

            Divider()

            SettingsItem(title = "Edit Profile")
            SettingsItem(title = "About App")
            SettingsItem(title = "Logout")
        }
    }
}

@Composable
fun SettingsItem(title: String, onClick: () -> Unit = {}) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        style = MaterialTheme.typography.bodyLarge
    )
}
