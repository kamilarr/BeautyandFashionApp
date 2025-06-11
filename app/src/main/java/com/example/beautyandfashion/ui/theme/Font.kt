package com.example.beautyandfashion.ui.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont.Provider

val manropeFont = GoogleFont("Manrope")

val fontProvider = Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = com.example.beautyandfashion.R.array.com_google_android_gms_fonts_certs
)

val Manrope = FontFamily(
    Font(googleFont = manropeFont, fontProvider = fontProvider, weight = FontWeight.Normal),
    Font(googleFont = manropeFont, fontProvider = fontProvider, weight = FontWeight.Bold)
)

