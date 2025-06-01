@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.beautyandfashion.ui.screen.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.component.BottomBar
import com.example.beautyandfashion.ui.theme.BrownDark

@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BrownDark,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
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

            SettingsItem(title = "Account", icon = Icons.Filled.AccountCircle)
            SettingsItem(title = "Notification", icon = Icons.Filled.Notifications)
            SettingsItem(title = "Privacy", icon = Icons.Filled.Lock)
            SettingsItem(title = "Help", icon = Icons.Filled.Warning)
            SettingsItem(title = "About App", icon = Icons.Filled.Info)
            SettingsItem(title = "History", icon = Icons.Filled.Refresh)
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
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
