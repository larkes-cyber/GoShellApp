package theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class GoShellColors(
    val primaryBackground: Color,
    val primaryAction: Color,
    val primaryTextColor: Color,
    val hintTextColor: Color,
    val highlightTextColor: Color,
    val secondaryTextColor: Color,
    val thirdTextColor: Color,
    val fourthTextColor: Color,
    val fifthTextColor: Color,
    val fieldColor: Color,
    val primaryColor:Color
)

val palette = GoShellColors(
    primaryBackground = Color(0XFFFFFFFF),
    primaryAction = Color(0xFFF4D144),
    primaryTextColor = Color(0xFF101010),
    hintTextColor = Color(0xFF696C75),
    highlightTextColor = Color(0xFF050B18),
    secondaryTextColor = Color(0xFFFFFFFF).copy(alpha = 0.5f),
    thirdTextColor = Color(0xFFEEF2FB).copy(alpha = 0.7f),
    fourthTextColor = Color(0xFFA8ADB7),
    fifthTextColor = Color(0xFF45454D),
    fieldColor = Color(0xFFF8F8F8),
    primaryColor = Color(0xFF101010)
)

val LocalColorProvider = staticCompositionLocalOf<GoShellColors> {
    error("")
}