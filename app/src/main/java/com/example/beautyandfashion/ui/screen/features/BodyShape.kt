@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
package com.example.beautyandfashion.ui.screen.features

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.component.AppTopBar
import com.example.beautyandfashion.ui.theme.BrownDark
import com.example.beautyandfashion.ui.theme.BrownLight
import com.example.beautyandfashion.ui.theme.BrownMedium
import kotlin.math.abs

enum class BodyType(val displayName: String, val description: String) {
    APPLE("Apple", "Broader shoulders and bust, narrower hips"),
    PEAR("Pear", "Narrower shoulders, wider hips"),
    HOURGLASS("Hourglass", "Balanced shoulders and hips with defined waist"),
    RECTANGLE("Rectangle", "Similar measurements throughout"),
    INVERTED_TRIANGLE("Inverted Triangle", "Broad shoulders, narrow hips")
}

@Composable
fun BodyShapeScreen(
    navController: NavController,
    viewModel: BodyShapeViewModel = viewModel()
) {
    val measurements by viewModel.measurements.collectAsStateWithLifecycle()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val inputErrors by viewModel.inputErrors.collectAsStateWithLifecycle()

    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    // Auto scroll to result when calculation is done
    LaunchedEffect(uiState) {
        if (uiState is BodyShapeUiState.Success) {
            scrollState.animateScrollTo(scrollState.maxValue)
        }
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Body Shape Calculator",
                onBack = null,
                icon = null
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp)
                .verticalScroll(scrollState)
                .imePadding(), // Handle keyboard padding
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Header Card
            HeaderCard()

            // Input Fields
            MeasurementInputField(
                label = "Bust Size",
                value = measurements.bustSize,
                onValueChange = viewModel::updateBustSize,
                placeholder = "e.g., 90",
                error = inputErrors["bust"],
                imeAction = ImeAction.Next,
                onImeAction = { focusManager.moveFocus(FocusDirection.Down) }
            )

            MeasurementInputField(
                label = "Waist Size",
                value = measurements.waistSize,
                onValueChange = viewModel::updateWaistSize,
                placeholder = "e.g., 70",
                error = inputErrors["waist"],
                imeAction = ImeAction.Next,
                onImeAction = { focusManager.moveFocus(FocusDirection.Down) }
            )

            MeasurementInputField(
                label = "High Hip Size",
                value = measurements.highHipSize,
                onValueChange = viewModel::updateHighHipSize,
                placeholder = "e.g., 85",
                error = inputErrors["highHip"],
                imeAction = ImeAction.Next,
                onImeAction = { focusManager.moveFocus(FocusDirection.Down) }
            )

            MeasurementInputField(
                label = "Hip Size",
                value = measurements.hipSize,
                onValueChange = viewModel::updateHipSize,
                placeholder = "e.g., 95",
                error = inputErrors["hip"],
                imeAction = ImeAction.Done,
                onImeAction = {
                    keyboardController?.hide()
                    viewModel.calculateBodyShape()
                }
            )

            // Calculate Button
            Button(
                onClick = {
                    keyboardController?.hide()
                    viewModel.calculateBodyShape()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BrownMedium),
                shape = RoundedCornerShape(12.dp),
                enabled = measurements.isAllFieldsFilled() && inputErrors.isEmpty()
            ) {
                Text(
                    text = "Calculate Body Shape",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }

            // Result Section
            when (uiState) {
                is BodyShapeUiState.Loading -> {
                    LoadingCard()
                }
                is BodyShapeUiState.Success -> {
                    BodyTypeResultCard(
                        result = (uiState as BodyShapeUiState.Success).result,
                        detailedAnalysis = viewModel.getDetailedAnalysis((uiState as BodyShapeUiState.Success).result)
                    )
                }
                is BodyShapeUiState.Error -> {
                    ErrorCard(message = (uiState as BodyShapeUiState.Error).message)
                }
                is BodyShapeUiState.Initial -> {
                }
            }

            // Add some bottom padding for better scroll experience
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun HeaderCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = BrownLight)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Know Your Body Shape",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Enter your measurements in centimeters to discover your body type and get personalized styling tips!",
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.9f),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun MeasurementInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    error: String? = null,
    imeAction: ImeAction = ImeAction.Next,
    onImeAction: () -> Unit = {}
) {
    val bringIntoViewRequester = remember { BringIntoViewRequester() }
    var isFocused by remember { mutableStateOf(false) }

    // LaunchedEffect yang dipicu saat fokus berubah ke true
    LaunchedEffect(isFocused) {
        if (isFocused) {
            bringIntoViewRequester.bringIntoView()
        }
    }

    Column(
        modifier = Modifier
            .bringIntoViewRequester(bringIntoViewRequester)
            .onFocusEvent { event ->
                isFocused = event.isFocused
            },
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = BrownDark
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder) },
            suffix = { Text("cm", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = imeAction
            ),
            keyboardActions = KeyboardActions(
                onNext = { onImeAction() },
                onDone = { onImeAction() }
            ),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (error != null) MaterialTheme.colorScheme.error else BrownMedium,
                unfocusedBorderColor = if (error != null) MaterialTheme.colorScheme.error else Color.Gray,
                focusedLabelColor = BrownMedium
            ),
            isError = error != null,
            supportingText = if (error != null) {
                { Text(text = error, color = MaterialTheme.colorScheme.error) }
            } else null
        )
    }
}



@Composable
fun LoadingCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = BrownLight)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CircularProgressIndicator(color = Color.White)
            Text(
                text = "Calculating your body shape...",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ErrorCard(message: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "⚠️ Error",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onErrorContainer
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = message,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onErrorContainer,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun BodyTypeResultCard(result: BodyShapeResult, detailedAnalysis: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = BrownMedium)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Main Result
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Your Body Type",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = result.bodyType.displayName,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = result.bodyType.description,
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.9f),
                    textAlign = TextAlign.Center
                )
            }

            Divider(color = Color.White.copy(alpha = 0.3f))

            // Detailed Analysis
            Text(
                text = detailedAnalysis,
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.9f),
                lineHeight = 20.sp
            )

            Divider(color = Color.White.copy(alpha = 0.3f))

            // Style Tips
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "💡 Style Tips for You:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = getStyleTips(result.bodyType),
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.9f),
                    textAlign = TextAlign.Start,
                    lineHeight = 20.sp
                )
            }
        }
    }
}

fun getStyleTips(bodyType: BodyType): String {
    return when (bodyType) {
        BodyType.APPLE -> "• Highlight your legs with A-line skirts and dresses\n• Choose tops that flow away from your midsection\n• Create a defined waistline with belts\n• V-necks and scoop necks are flattering"

        BodyType.PEAR -> "• Balance your silhouette with statement tops\n• Add structure to your shoulders with blazers\n• Dark bottoms with bright or patterned tops work great\n• A-line and straight-leg pants are perfect"

        BodyType.HOURGLASS -> "• Embrace your natural curves with fitted clothing\n• Follow your waistline - avoid shapeless clothes\n• Wrap dresses and tops are your best friends\n• High-waisted bottoms enhance your silhouette"

        BodyType.RECTANGLE -> "• Create curves with belted dresses and tops\n• Layering adds dimension to your silhouette\n• Textured fabrics and patterns work well\n• Peplum tops and flared skirts add shape"

        BodyType.INVERTED_TRIANGLE -> "• Balance broad shoulders with wider leg pants\n• Choose A-line skirts and bootcut jeans\n• Avoid shoulder pads and detailed necklines\n• Draw attention to your lower half with patterns"
    }
}