package navigation

import home.HomeScreen
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import tabs.BottomConfiguration
import tabs.HomeTab

fun RootComposeBuilder.mainFlow(){
    bottomNavigation(
        name = NavigationTree.Main.Dashboard.name,
        tabsNavModel = BottomConfiguration()
    ){
        tab(HomeTab()){
            screen(name = NavigationTree.Main.Home.name){
                HomeScreen()
            }
        }
    }
}