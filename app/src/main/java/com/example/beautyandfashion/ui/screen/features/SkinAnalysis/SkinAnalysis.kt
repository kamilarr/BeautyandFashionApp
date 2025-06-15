package com.example.beautyandfashion.ui.screen.features.SkinAnalysis

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import org.json.JSONArray


// Data model

data class Question(val text: String, val options: List<String>)
data class SkinResult(val imageRes: Int, val title: String, val description: String)

val questionList = listOf(
    Question(
        "Sentuh kulit muka kita yuk\nWhat do you feel?",
        listOf(
            "Kulit terasa lembut, halus, tidak ada yang mengelupas, dan tidak terlalu berminyak",
            "Kulit terasa kering, tertarik, terlihat kering, dan kusam",
            "Kulit berminyak, licin, dan mengkilap",
            "Mengkilap di T-Zone, kering di area lainnya"
        )
    ),
    Question(
        "Apa masalah kulit yang paling sering kamu alami 1 bulan terakhir?",
        listOf(
            "Kulit cukup stabil, tidak ada masalah yang berarti",
            "Kulit sering terasa kering dan ketarik, kadang juga mengelupas",
            "Sering muncul jerawat di area-area wajah",
            "Kulit sering kemerahan dan berjerawat di waktu bersamaan"
        )
    ),
    Question(
        "Mana yang paling mendeskripsikan tampilan pori-pori di wajahmu?",
        listOf(
            "Pori-pori terlihat kecil hingga sedang, cukup merata",
            "Pori-pori sangat kecil, bahkan hampir tidak kelihatan",
            "Pori-pori besar dan terlihat jelas di hampir seluruh wajah",
            "Pori-pori besar hanya di T-zone, tapi kecil di bagian lain"
        )
    ),
    Question(
        "Kapan biasanya kulit wajahmu muncul kemerahan?",
        listOf(
            "Hanya saat terpapar sinar matahari",
            "Setiap kali mencuci muka atau saat tidak menggunakan pelembap",
            "Setiap ada jerawat atau masalah hormonal",
            "Saat tidak cocok menggunakan produk skincare baru"
        )
    ),
    Question(
        "Seberapa mengkilap wajahmu di sore hari?",
        listOf(
            "Tidak terlalu mengkilap, tapi juga tidak tampak kusam",
            "Kulit lebih terlihat kusam dan kadang terasa perih",
            "Wajah sangat mengkilap dan berminyak di semua bagian",
            "Hanya T-zone yang mengkilap, area lain tetap normal"
        )
    ),
    Question(
        "Jika kamu hanya punya 1 produk untuk touch up, apa produk yang kamu pilih?",
        listOf(
            "Face mist untuk menyegarkan dan melembapkan kulit",
            "Moisturizer karena kulitku mudah kering saat siang",
            "Blotting paper buat menyerap minyak tanpa hapus makeup",
            "Loose powder supaya wajah tetap kelihatan matte"
        )
    ),
    Question(
        "Apa makeup finish yang kamu suka?",
        listOf(
            "Semi-matte, natural tapi nggak terlalu mengkilap",
            "Dewy, bikin kulit kelihatan sehat dan glowing",
            "Matte, biar wajah kelihatan halus dan nggak berminyak",
            "Satin-matte, sedikit glowing tapi tetap elegan"
        )
    )
)

@Composable
fun SkinAnalysisScreen(navController: NavController) {
    val context = LocalContext.current
    var index by remember { mutableStateOf(0) }
    val answers = remember { mutableStateListOf<String?>().apply { repeat(7) { add(null) } } }
    val current = questionList[index]

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
                text = current.text,
                fontSize = 18.sp,
                color = BrownDark,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            current.options.forEachIndexed { i, option ->
                Button(
                    onClick = {
                        answers[index] = ('A' + i).toString()
                        if (index < questionList.lastIndex) {
                            index++
                        } else if (answers.none { it == null }) {
                            val result = matchSkinType(context, answers.filterNotNull())
                            navController.navigate("skinResult/$result")
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = BrownDark.copy(alpha = 0.4f)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .padding(vertical = 4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    Text(
                        text = option,
                        color = Color.White,
                        fontSize = 14.sp,
                        maxLines = 2
                    )
                }
            }
        }
    }
}

@Composable
fun SkinResultScreen(navController: NavController, skinType: String) {
    val result = when (skinType) {
        "Normal" -> SkinResult(
            R.drawable.normal,
            "Normal",
            "Kamu punya kulit normal! Tipe kulitmu paling mudah dirawat. Kulit normal ga terlalu kering ataupun berminyak. Kalaupun sesekali berminyak dan kering, gampang banget buat ngatasinnya.\n\nCiri khas kulit normal adalah pori-pori kecil dan gak terlalu kelihatan. Kulit tampak halus dan merata, ga mengkilap seperti kulit berminyak, Kulitmu juga ga pecah-pecah atau bersisik macam kulit kering."
        )
        "Kering" -> SkinResult(
            R.drawable.kering,
            "Kering",
            "Tipe kulitmu adalah kulit kering! Biasanya, terasa kencang setelah mencuci wajah, lalu, kadang terlihat bersisik, kasar, dan kemerahan. Kadar minyak pada kulit tergolong rendah, jadi rentan terkena iritasi, inflamasi, dan alergi. \n\nUntuk kulit kering, lebih disarankan menggunakan produk krim, karena krim memberikan hidrasi lebih dan membantu menjaga kelembapan kulit. Kamu butuh skincare yang kandungan hidrasi tinggi untuk menjaga kulit tetap lembap, lembut, dan kenyal!"
        )
        "Berminyak" -> SkinResult(
            R.drawable.berminyak,
            "Berminyak",
            "Berminyak adalah tipe kulitmu! Wajahmu memproduksi lebih banyak sebum dari biasanya. Produksi minyak berlebih menyebabkan pori-pori tampak lebih besar. Ketika minyak bercampur dengan kotoran atau sel kulit mati, pori-pori bisa tersumbat. Ini menyebabkan kulit berminyak lebih rentan terhadap jerawat dan komedo.\n\nCiri paling umum adalah kulit tampak mengilap dan berkilau. Perlu perawatan rutin dengan produk ringan agar tetap sehat dan terkontrol sepanjang hari."
        )
        "Kombinasi" -> SkinResult(
            R.drawable.kombinasi,
            "Kombinasi",
            "Kulitmu termasuk kulit kombinasi! Biasanya, area T-Zone lebih berminyak dan terlihat mengilap, sementara area pipi dan yang lain terasa kering dan kasar.\n\nUntuk merawat kulit kombinasi ini, butuh perawatan yang seimbang, jangan terlalu bikin kering, juga tidak menambah minyak berlebih. Ketika kamu menemukan perawatan yang tepat, kulitmu bisa semakin optimal dan sehat!"
        )
        else -> SkinResult(
            R.drawable.normal,
            "Normal",
            "(Fallback) Kamu punya kulit normal."
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
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Gambar dalam kotak
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
                    .background(color = Color(0xFFE8D7C2), shape = RoundedCornerShape(24.dp))
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = result.imageRes),
                    contentDescription = "Gambar ${result.title}",
                    modifier = Modifier.size(240.dp)
                )
            }

            // Hasil dan deskripsi dalam kotak
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFFE8D7C2), shape = RoundedCornerShape(24.dp))
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .background(BrownDark, shape = RoundedCornerShape(50))
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = result.title,
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = result.description,
                    fontSize = 16.sp,
                    color = BrownDark,
                    textAlign = TextAlign.Justify
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

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

fun matchSkinType(context: Context, userAnswers: List<String>): String {
    return try {
        // Buka file dari folder assets
        val inputStream = context.assets.open("skin_dataset.json")
        val json = inputStream.bufferedReader().use { it.readText() }
        val jsonArray = JSONArray(json)

        // Loop seluruh entri di JSON
        for (i in 0 until jsonArray.length()) {
            val obj = jsonArray.getJSONObject(i)

            // Ambil jawaban dari Q1 hingga Q7
            val datasetAnswers = (1..7).map { questionIndex ->
                obj.getString("Q$questionIndex").trim().uppercase()
            }

            // Bandingkan dengan jawaban user (abaikan kapitalisasi dan spasi)
            val userFormatted = userAnswers.map { it.trim().uppercase() }

            if (datasetAnswers == userFormatted) {
                return obj.getString("Rumus Akhir")
            }
        }

        // Tidak cocok = fallback
        "Normal"
    } catch (e: Exception) {
        Log.e("SkinType", "Error matching skin type", e)
        "Normal"
    }
}

