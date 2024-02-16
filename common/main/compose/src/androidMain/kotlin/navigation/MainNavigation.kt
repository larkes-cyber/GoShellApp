package navigation

import home.HomeScreen
import profile.ProfileScreen
import rooms.RoomsScreen
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import tabs.BottomConfiguration
import tabs.HomeTab
import tabs.ProfileTab
import tabs.RoomsTab

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
        tab(RoomsTab()){
            screen(name = NavigationTree.Main.Rooms.name){
                RoomsScreen()
            }
        }
        tab(ProfileTab()){
            screen(name = NavigationTree.Main.Profile.name){
                ProfileScreen()
            }
        }
    }
}