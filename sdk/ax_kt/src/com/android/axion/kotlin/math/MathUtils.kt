package com.android.axion.kotlin.math

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val Number.sldp: Dp
    @Composable get() = (this.toFloat() * LocalContext.current.scaleRatioLocked).dp

val Number.sdp: Dp
    @Composable get() = (this.toFloat() * LocalContext.current.scaleRatio).dp

fun lerp(start: Float, stop: Float, fraction: Float): Float {
    return start + fraction * (stop - start)
}

val Context.scaleRatioLocked: Float
    get() {
        val displayMetrics = resources.displayMetrics
        val sw = minOf(displayMetrics.widthPixels, displayMetrics.heightPixels) / displayMetrics.density
        val ratio = sw / 420f
        return ratio
    }

val Context.scaleRatio: Float
    get() {
        val displayMetrics = resources.displayMetrics
        val sw = minOf(displayMetrics.widthPixels, displayMetrics.heightPixels) / displayMetrics.density
        val ratio = if (sw > 620f) 1f else sw / 420f
        return ratio
    }

fun Context.sldp(value: Number): Float {
    return value.toFloat() * scaleRatioLocked
}

fun Context.sdp(value: Number): Float {
    return value.toFloat() * scaleRatio
}

fun Context.dpToPx(dp: Int): Int =
    (dp * resources.displayMetrics.density).toInt()

fun Context.dpToPx(dp: Float): Int =
    (dp * resources.displayMetrics.density).toInt()

fun Context.dpToPxF(dp: Int): Float =
    dp * resources.displayMetrics.density

fun Context.dpToPxF(dp: Float): Float =
    dp * resources.displayMetrics.density

fun dpToPx(dp: Int, densityDpi: Int): Int =
    (dp * (densityDpi / 160f)).roundToInt()

