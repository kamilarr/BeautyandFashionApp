package com.example.beautyandfashion.ui.screen.features.Beautypedia

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.component.AppTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailScreen(articleId: Int, navController: NavController) {
    val article = getDummyArticleById(articleId)

    Scaffold(
        containerColor = Color(0xFFF9EFE6),
        topBar = {
            AppTopBar(
                title = "BEAUTYPEDIA",
                onBack = { navController.popBackStack() },
                icon = null
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = article.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = article.title,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${article.category} | ${article.author} | ${article.date}",
                style = MaterialTheme.typography.labelMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            val content = when (article.id) {
                1 -> """
                    Getting clear skin quickly is a goal many people share, but it requires the right combination of care, products, and lifestyle habits. The first step is to cleanse your face twice daily using a gentle, non-comedogenic cleanser to remove dirt, oil, and impurities that clog pores.

                    Next, incorporate a lightweight moisturizer and a salicylic acid or benzoyl peroxide treatment to target breakouts. Avoid picking at pimples, as this can lead to scarring and prolonged healing time. Consistency is key—don’t expect overnight results, but stick to your routine.

                    Hydration and diet also play major roles. Drink plenty of water and eat foods rich in antioxidants, like leafy greens and berries, to support your skin from the inside out. Lastly, ensure you get enough sleep and minimize stress, as both have a direct impact on skin clarity.
                """.trimIndent()

                2 -> """
                    Starting a skincare routine doesn’t have to be overwhelming. For beginners, the goal should be to build a solid foundation with just three steps: cleanse, moisturize, and protect. Begin with a gentle facial cleanser that suits your skin type—this will help remove excess oil and impurities without stripping your skin.

                    After cleansing, apply a moisturizer to keep your skin hydrated and to strengthen its barrier. For daytime use, it’s essential to follow up with a broad-spectrum sunscreen of SPF 30 or higher. This step is often overlooked but is crucial in preventing premature aging and sun damage.

                    As you become more comfortable, you can slowly introduce targeted treatments like serums or exfoliants. But remember, less is more when you're starting out. A consistent and gentle routine will help your skin adapt and improve over time without irritation.
                """.trimIndent()

                3 -> """
                    Skin cycling is an emerging skincare trend that emphasizes alternating your skincare products in a structured routine to maximize benefits and minimize irritation. Instead of using active ingredients daily, skin cycling gives your skin time to recover and rebuild.

                    A typical skin cycling routine includes exfoliation on the first night, a retinoid on the second, and recovery-focused skincare—like hydrating serums and moisturizers—on the third and fourth nights. This cycle repeats, giving your skin a balance between treatment and restoration.

                    Dermatologists have supported this method for its simplicity and effectiveness. It reduces the risk of over-exfoliation and makes your products work better together. It's also ideal for people with sensitive skin who need a more gentle approach to actives.

                    As with any routine, consistency is key. Always listen to your skin and adjust the cycle as needed. Skin cycling may be a smarter and more sustainable way to build long-term skin health.
                """.trimIndent()

                else -> "Default content."
            }

            val paragraphs = content.split("\n\n")

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                paragraphs.forEach { paragraph ->
                    Text(
                        text = paragraph.trim(),
                        textAlign = TextAlign.Justify,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            lineHeight = 22.sp
                        )
                    )
                }
            }
        }
    }
}
