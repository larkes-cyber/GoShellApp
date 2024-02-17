package navigation

object NavigationTree {

    enum class Auth{
        AuthFlow, Login, Registration
    }

    enum class Splash{
        SplashScreen
    }

    enum class Main{

       Dashboard, Home, Rooms, RoomDetail, Profile

    }

    enum class Room{
        RoomFlow, Rooms, RoomDetail
    }

}