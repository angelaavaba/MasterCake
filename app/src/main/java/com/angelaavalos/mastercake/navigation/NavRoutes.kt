package com.angelaavalos.mastercake.navigation


sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("homeroute")
    object FavoritesView : NavRoutes("favoritesroute")
    object CartView : NavRoutes("cartroute")
    object Register : NavRoutes("register")
    object Onboarding : NavRoutes("onboarding")
    object LoginView : NavRoutes("loginview")
    object LoginRegisterView : NavRoutes("loginregisterview")
    object UsersView : NavRoutes("userroute")
    object SplashView: NavRoutes("SplashView")
    object AboutView: NavRoutes("AboutView")







}
