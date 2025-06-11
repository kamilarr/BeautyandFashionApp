package com.example.beautyandfashion.ui.component

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.beautyandfashion.R
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.beautyandfashion.ui.theme.BrownDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    onBack: (() -> Unit)? = null,
    icon: ImageVector?
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )
        },
        navigationIcon = {
            if (onBack != null) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
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
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BrownDark
        )
    )
}

