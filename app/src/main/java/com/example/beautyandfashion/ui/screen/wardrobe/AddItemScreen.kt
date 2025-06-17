@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.beautyandfashion.ui.screen.wardrobe

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.beautyandfashion.R
import com.example.beautyandfashion.ui.theme.BrownDark

@Composable
fun AddItemScreen(navController: NavController, category: String) {
    val title = "List of Item"

    // Ganti dengan gambar nyata yang kamu simpan di drawable
    val items = when (category) {
        "upper_body" -> listOf(
            R.drawable.zjacket to "Jacket",
            R.drawable.zblouse to "Blouse",
            R.drawable.zcardigan to "Cardigan",
            R.drawable.zdress to "Dress",
            R.drawable.ztshirt to "Black t-shirt",
            R.drawable.ztshirt2 to "Brown t-shirt",
            R.drawable.zkaos to "Green Shirt",
            R.drawable.zblus to "Pink Blouse"
        )
        "lower_body" -> listOf(
            R.drawable.xjeans to "High Waist Jeans",
            R.drawable.xpants to "Short Panyts",
            R.drawable.xminiskirt to "Mini Skirt",
            R.drawable.xlongskirt to "Long Skirt",
            R.drawable.xtrousers to "Trousers",
            R.drawable.xhotpants to "Hot Pants",
            R.drawable.xtraining to "Training Pants",
            R.drawable.xmidiskirt to "Long Grey Skirt"
        )
        "shoes" -> listOf(
            R.drawable.yheels to "Black High Heels",
            R.drawable.ywedges to "White Wedges",
            R.drawable.yflatshoes to "Flatshoes",
            R.drawable.ysneakers to "White Sneakers",
            R.drawable.ysandals to "Sandals",
            R.drawable.yboots to "Boots",
            R.drawable.ycrocs to "Crocks",
            R.drawable.ysandall to "Trpoical Sandals"
        )
        else -> emptyList()
    }

    Scaffold(
        containerColor = Color(0xFFF9EFE6),
        topBar = {
            TopAppBar(
                title = { Text(title, color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    Icon(
                        painter = painterResource(id = R.drawable.glammuse),
                        contentDescription = "Logo",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(30.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BrownDark)
            )
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items) { item ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = item.first),
                        contentDescription = "Item Image",
                        modifier = Modifier.size(140.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = item.second,
                        style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                        color = Color.Black
                    )
                }
            }
        }
    }
}
