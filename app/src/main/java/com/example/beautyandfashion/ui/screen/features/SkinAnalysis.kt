package com.example.beautyandfashion.ui.screen.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.beautyandfashion.R
import com.example.beautyandfashion.ui.theme.BrownDark
import com.example.beautyandfashion.ui.component.AppTopBar
import com.example.beautyandfashion.ui.screen.homeScreen
import com.example.beautyandfashion.ui.theme.SkinType

@Composable
fun SkinAnalysisScreen(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Skin Type Analysis",
                onBack = { navController.navigate("home") },
                icon = null
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                "Sentuh kulit muka kita yuk\nWhat do you feel?",
                fontSize = 18.sp,
                color = BrownDark,
                modifier = Modifier.padding(bottom = 24.dp),
                lineHeight = 24.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            val options = listOf(
                "Kulit terasa lembut, halus, tidak ada yang mengelupas, dan tidak terlalu berminyak",
                "Kulit terasa kering, tertarik, terlihat kering dan kusam",
                "Kulit berminyak, licin, dan mengkilap",
                "Kulit kombinasi, terasa berminyak di T-Zone, kering di bagian lain"
            )

            options.forEach { text ->
                Button(
                    onClick = { navController.navigate("skinStep2") },
                    colors = ButtonDefaults.buttonColors(containerColor = BrownDark.copy(alpha = 0.4f)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .padding(vertical = 4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = text,
                            color = Color.White,
                            fontSize = 14.sp,
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 2
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SkinAnalysisStep2(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Skin Type Analysis",
                onBack = { navController.navigateUp() },
                icon = null
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                "Nah udah hampir waktu makan siang\nYuk cek kondisi kulit muka kita!",
                fontSize = 18.sp,
                color = BrownDark,
                modifier = Modifier.padding(bottom = 24.dp),
                lineHeight = 24.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            val options = listOf(
                "Terlihat lembap, segar, dan bersih",
                "Berkilau di beberapa bagian, dan terasa berminyak serta lengket",
                "Terasa kasar dan terlihat kemerahan",
                "Bersinar di bagian T-Zone"
            )

            options.forEach { text ->
                Button(
                    onClick = { navController.navigate("skinStep3") },
                    colors = ButtonDefaults.buttonColors(containerColor = BrownDark.copy(alpha = 0.4f)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .padding(vertical = 4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = text,
                            color = Color.White,
                            fontSize = 14.sp,
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 2
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(containerColor = BrownDark),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .align(Alignment.Start)
                    .height(48.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sebelumnya", color = Color.White)
            }
        }
    }
}

@Composable
fun SkinAnalysisStep3(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Skin Type Analysis",
                onBack = { navController.navigateUp() },
                icon = null
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                "Jerawat dan Blackhead sering\ndatang ke wajah kita?",
                fontSize = 18.sp,
                color = BrownDark,
                modifier = Modifier.padding(bottom = 24.dp),
                lineHeight = 24.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            val options = listOf(
                "Jarang banget!",
                "Setiap kali deh",
                "Kalo lagi mau menstruasi aja",
                "Sesekali sih biasanya"
            )

            options.forEach { text ->
                Button(
                    onClick = { navController.navigate("skinStep4") },
                    colors = ButtonDefaults.buttonColors(containerColor = BrownDark.copy(alpha = 0.4f)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .padding(vertical = 4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = text,
                            color = Color.White,
                            fontSize = 14.sp,
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 2
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(containerColor = BrownDark),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .align(Alignment.Start)
                    .height(48.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sebelumnya", color = Color.White)
            }
        }
    }
}

@Composable
fun SkinAnalysisStep4(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Skin Type Analysis",
                onBack = { navController.navigateUp() },
                icon = null
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                "Produk apa sih yang biasanya\ndipakai sepanjang hari?",
                fontSize = 18.sp,
                color = BrownDark,
                modifier = Modifier.padding(bottom = 24.dp),
                lineHeight = 24.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            val options = listOf(
                "Nggak ada, soalnya kulitnya ga bermasalah",
                "Powder, biar nggak kelihatan terlalu berminyak",
                "Moisturaizer atau face mist biar muka kelihatan tetap lembap",
                "Cukup kertas mintak buat ngejaga biar beberapa area nggak terlihat berminyak"
            )

            options.forEach { text ->
                Button(
                    onClick = { navController.navigate("skinStep5") },
                    colors = ButtonDefaults.buttonColors(containerColor = BrownDark.copy(alpha = 0.4f)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .padding(vertical = 4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = text,
                            color = Color.White,
                            fontSize = 14.sp,
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 2
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(containerColor = BrownDark),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .align(Alignment.Start)
                    .height(48.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sebelumnya", color = Color.White)
            }
        }
    }
}

@Composable
fun SkinAnalysisStep5(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Skin Type Analysis",
                onBack = { navController.navigateUp() },
                icon = null
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                "Biasanya kalau berjerawat tuh\nkarena apa sih?",
                fontSize = 18.sp,
                color = BrownDark,
                modifier = Modifier.padding(bottom = 24.dp),
                lineHeight = 24.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            val options = listOf(
                "Nggak pernah berjerawat nih",
                "Biasanya kalau nggak cuci muka pakai cleanser",
                "Sebulan sekali sih jerawatnya, tapi nggak tentu areanya",
                "Di area T-Zone aja sih biasanya"
            )

            options.forEach { text ->
                Button(
                    onClick = { navController.navigate("skinStep6") },
                    colors = ButtonDefaults.buttonColors(containerColor = BrownDark.copy(alpha = 0.4f)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .padding(vertical = 4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = text,
                            color = Color.White,
                            fontSize = 14.sp,
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 2
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(containerColor = BrownDark),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .align(Alignment.Start)
                    .height(48.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sebelumnya", color = Color.White)
            }
        }
    }
}

@Composable
fun SkinAnalysisStep6(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Skin Type Analysis",
                onBack = { navController.navigateUp() },
                icon = null
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                "Nah sekarang ngomongin pori\nGimana kelihatannya pori-pori di wajah?",
                fontSize = 18.sp,
                color = BrownDark,
                modifier = Modifier.padding(bottom = 24.dp),
                lineHeight = 24.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            val options = listOf(
                "Terlihat berukuran normal, hampir tidak terlihat",
                "Sangat terlihat dan terbuka",
                "Tidak telihat sih",
                "Terlihat, tapi biasa aja ukurannya"
            )

            options.forEach { text ->
                Button(
                    onClick = { navController.navigate("skinStep7") },
                    colors = ButtonDefaults.buttonColors(containerColor = BrownDark.copy(alpha = 0.4f)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .padding(vertical = 4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = text,
                            color = Color.White,
                            fontSize = 14.sp,
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 2
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(containerColor = BrownDark),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .align(Alignment.Start)
                    .height(48.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sebelumnya", color = Color.White)
            }
        }
    }
}

@Composable
fun SkinAnalysisStep7(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Skin Type Analysis",
                onBack = { navController.navigateUp() },
                icon = null
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                "Moisturaizer seperti apa sih yang kamu cari?",
                fontSize = 18.sp,
                color = BrownDark,
                modifier = Modifier.padding(bottom = 24.dp),
                lineHeight = 24.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            val options = listOf(
                "Moisturaizer yang bikin kulit terasa halus dan kenyal",
                "Yang cepat meresap dan tidak menghambat pori-pori",
                "Moisturaizer yang terksturnya kaya dan merawat kulit secara intensif",
                "Yang bikin kulit terlihat matte sekaligus melembabkan di area tertentu"
            )

            options.forEach { text ->
                Button(
                    onClick = {
                        navController.navigate("skinResult/NORMAL")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = BrownDark.copy(alpha = 0.4f)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .padding(vertical = 4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = text,
                            color = Color.White,
                            fontSize = 14.sp,
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 2
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(containerColor = BrownDark),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .align(Alignment.Start)
                    .height(48.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sebelumnya", color = Color.White)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkinAnalysisScreen(navController: NavController, skinType: SkinType){
    val (imageRes, title, description) = when (skinType) {
        SkinType.NORMAL -> Triple(
            R.drawable.normal,
            "Normal",
            "Kamu punya kulit normal! Tipe kulitmu paling mudah dirawat. Kulit normal ga terlalu kering ataupun berminyak. Kalaupun sesekali berminyak dan kering, gampang banget buat ngatasinnya.\n\nCiri khas kulit normal adalah pori-pori kecil dan gak terlalu kelihatan. Kulit tampak halus dan merata, ga mengkilap seperti kulit berminyak, Kulitmu juga ga pecah-pecah atau bersisik macam kulit kering."
        )
        SkinType.DRY -> Triple(
            R.drawable.kering,
            "Kering",
            "Tipe kulitmu adalah kulit kering! Biasanya, terasa kencang setelah mencuci wajah, lalu, kadang terlihat bersisik, kasar, dan kemerahan. Kadar minyak pada kulit tergolong rendah, jadi rentan terkena iritasi, inflamasi, dan jerawat.\n\nUntuk kulit kering, lebih disarankan menggunakan produk krim, karena krim memberikan hidrasi lebih dan membantu menjaga kelembapan kulit."
        )
        SkinType.OILY -> Triple(
            R.drawable.berminyak,
            "Berminyak",
            "Berminyak adalah tipe kulitmu! Wajahmu memproduksi lebih banyak sebum dari biasanya. Produksi minyak berlebih menyebabkan pori-pori tampak lebih besar dan komedo muncul.\n\nCiri paling umum adalah kulit tampak mengilap dan berkilau. Perlu perawatan rutin dengan produk ringan agar tetap sehat dan terkontrol sepanjang hari."
        )
        SkinType.COMBINATION -> Triple(
            R.drawable.kombinasi,
            "Kombinasi",
            "Kulitmu termasuk kulit kombinasi! Biasanya, area T-Zone lebih berminyak dan terlihat mengilap, sementara area pipi dan yang lain terasa kering dan kasar.\n\nUntuk merawat kulit kombinasi ini, butuh perawatan yang seimbang, jangan terlalu bikin kering, juga tidak menambah minyak berlebih."
        )
    }

    Scaffold(
        topBar = {
            AppTopBar(title = "Skin Type Analysis", onBack = null, icon = null)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Kamu punya tipe kulit:",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = BrownDark,
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Gambar $title",
                modifier = Modifier.size(200.dp)
            )

            Text(
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = BrownDark
            )

            Text(
                text = description,
                fontSize = 16.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Justify,
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = { navController.navigate("home") },
                colors = ButtonDefaults.buttonColors(containerColor = BrownDark),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Kembali ke Beranda", color = Color.White)
            }
        }
    }
}