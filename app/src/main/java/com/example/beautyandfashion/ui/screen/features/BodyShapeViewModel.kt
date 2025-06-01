package com.example.beautyandfashion.ui.screen.features

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.math.abs

data class BodyMeasurements(
    val bustSize: String = "",
    val waistSize: String = "",
    val highHipSize: String = "",
    val hipSize: String = ""
) {
    fun isValid(): Boolean {
        return bustSize.isNotEmpty() && waistSize.isNotEmpty() &&
                highHipSize.isNotEmpty() && hipSize.isNotEmpty() &&
                bustSize.toDoubleOrNull() != null && waistSize.toDoubleOrNull() != null &&
                highHipSize.toDoubleOrNull() != null && hipSize.toDoubleOrNull() != null
    }

    fun isAllFieldsFilled(): Boolean {
        return bustSize.isNotEmpty() && waistSize.isNotEmpty() &&
                highHipSize.isNotEmpty() && hipSize.isNotEmpty()
    }
}

data class BodyShapeResult(
    val bodyType: BodyType,
    val measurements: BodyMeasurements,
    val ratios: BodyRatios
)

data class BodyRatios(
    val bustToWaist: Double,
    val hipToWaist: Double,
    val bustToHip: Double,
    val waistToHip: Double
)

sealed class BodyShapeUiState {
     data object Initial : BodyShapeUiState()
    data object Loading : BodyShapeUiState()
    data class Success(val result: BodyShapeResult) : BodyShapeUiState()
    data class Error(val message: String) : BodyShapeUiState()
}

class BodyShapeViewModel : ViewModel() {

    private val _measurements = MutableStateFlow(BodyMeasurements())
    val measurements: StateFlow<BodyMeasurements> = _measurements.asStateFlow()

    private val _uiState = MutableStateFlow<BodyShapeUiState>(BodyShapeUiState.Initial)
    val uiState: StateFlow<BodyShapeUiState> = _uiState.asStateFlow()

    private val _inputErrors = MutableStateFlow<Map<String, String>>(emptyMap())
    val inputErrors: StateFlow<Map<String, String>> = _inputErrors.asStateFlow()

    fun updateBustSize(value: String) {
        val filteredValue = filterNumericInput(value)
        _measurements.value = _measurements.value.copy(bustSize = filteredValue)
        validateInput("bust", filteredValue)
    }

    fun updateWaistSize(value: String) {
        val filteredValue = filterNumericInput(value)
        _measurements.value = _measurements.value.copy(waistSize = filteredValue)
        validateInput("waist", filteredValue)
    }

    fun updateHighHipSize(value: String) {
        val filteredValue = filterNumericInput(value)
        _measurements.value = _measurements.value.copy(highHipSize = filteredValue)
        validateInput("highHip", filteredValue)
    }

    fun updateHipSize(value: String) {
        val filteredValue = filterNumericInput(value)
        _measurements.value = _measurements.value.copy(hipSize = filteredValue)
        validateInput("hip", filteredValue)
    }

    private fun filterNumericInput(value: String): String {
        return value.filter { it.isDigit() || it == '.' }
            .let { filtered ->
                if (filtered.count { it == '.' } > 1) {
                    filtered.substringBefore('.') + "." + filtered.substringAfter('.').replace(".", "")
                } else filtered
            }
    }

    private fun validateInput(field: String, value: String) {
        val errors = _inputErrors.value.toMutableMap()

        when {
            value.isEmpty() -> {
                errors.remove(field)
            }
            value.toDoubleOrNull() == null -> {
                errors[field] = "Please enter a valid number"
            }
            value.toDoubleOrNull()!! <= 0 -> {
                errors[field] = "Value must be greater than 0"
            }
            value.toDoubleOrNull()!! > 300 -> {
                errors[field] = "Value seems too large"
            }
            else -> {
                errors.remove(field)
            }
        }

        _inputErrors.value = errors
    }

    fun calculateBodyShape() {
        val currentMeasurements = _measurements.value

        if (!currentMeasurements.isValid()) {
            _uiState.value = BodyShapeUiState.Error("Please fill all measurements with valid numbers")
            return
        }

        if (_inputErrors.value.isNotEmpty()) {
            _uiState.value = BodyShapeUiState.Error("Please fix input errors before calculating")
            return
        }

        _uiState.value = BodyShapeUiState.Loading

        try {
            val bust = currentMeasurements.bustSize.toDouble()
            val waist = currentMeasurements.waistSize.toDouble()
            val highHip = currentMeasurements.highHipSize.toDouble()
            val hip = currentMeasurements.hipSize.toDouble()

            val bodyType = calculateBodyType(bust, waist, highHip, hip)
            val ratios = BodyRatios(
                bustToWaist = bust / waist,
                hipToWaist = hip / waist,
                bustToHip = bust / hip,
                waistToHip = waist / hip
            )

            val result = BodyShapeResult(
                bodyType = bodyType,
                measurements = currentMeasurements,
                ratios = ratios
            )

            _uiState.value = BodyShapeUiState.Success(result)

        } catch (e: Exception) {
            _uiState.value = BodyShapeUiState.Error("Error calculating body shape: ${e.message}")
        }
    }

    private fun calculateBodyType(bust: Double, waist: Double, highHip: Double, hip: Double): BodyType {
        val bustWaistDiff = bust - waist
        val hipWaistDiff = hip - waist
        val bustHipDiff = abs(bust - hip)

        return when {
            // Hourglass: Bust and hips are similar, waist is significantly smaller
            bustHipDiff <= 2.5 && bustWaistDiff >= 22.5 && hipWaistDiff >= 22.5 -> BodyType.HOURGLASS

            // Pear: Hips are larger than bust
            hip - bust >= 9.0 && bustWaistDiff < 22.5 -> BodyType.PEAR

            // Apple: Bust is larger than hips, less defined waist
            bust - hip >= 9.0 && bustWaistDiff < 22.5 -> BodyType.APPLE

            // Inverted Triangle: Bust significantly larger than hips
            bust - hip >= 9.0 && bustWaistDiff >= 22.5 -> BodyType.INVERTED_TRIANGLE

            // Rectangle: Similar measurements throughout
            else -> BodyType.RECTANGLE
        }
    }

    fun resetCalculation() {
        _measurements.value = BodyMeasurements()
        _uiState.value = BodyShapeUiState.Initial
        _inputErrors.value = emptyMap()
    }

    @SuppressLint("DefaultLocale")
    fun getDetailedAnalysis(result: BodyShapeResult): String {
        val ratios = result.ratios
        return buildString {
            appendLine("📊 Detailed Analysis:")
            appendLine("• Bust to Waist Ratio: ${String.format("%.2f", ratios.bustToWaist)}")
            appendLine("• Hip to Waist Ratio: ${String.format("%.2f", ratios.hipToWaist)}")
            appendLine("• Bust to Hip Ratio: ${String.format("%.2f", ratios.bustToHip)}")
            appendLine("")
            appendLine("Your measurements indicate a ${result.bodyType.displayName} body shape.")
        }
    }
}