package navigation

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.adeo.kviewmodel.odyssey.setupWithViewModels
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.configuration.DefaultModalConfiguration
import ru.alexgladkov.odyssey.core.configuration.DisplayType
import theme.AppTheme
import theme.Theme

fun ComponentActivity.setupThemedNavigation(){

    val rootController = RootComposeBuilder().apply { generateGraph() }.build()
    rootController.setupWithViewModels()

    setContent {
        AppTheme {
            val background = Theme.colors.primaryBackground
            rootController.backgroundColor = background
            CompositionLocalProvider(
                LocalRootController provides rootController
            ) {
                ModalNavigator(configuration = DefaultModalConfiguration(backgroundColor = background, displayType = DisplayType.FullScreen)) {
                    Navigator(startScreen = NavigationTree.Splash.SplashScreen.name)
                }
            }
        }
    }

}