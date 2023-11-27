package com.angelaavalos.mastercake.navigation


sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("homeroute")
    object FavoritesView : NavRoutes("favoritesroute")
    object NotificationsView : NavRoutes("notificationsroute")
    object CartView : NavRoutes("cartroute")
    object Register : NavRoutes("register")
    object Onboarding : NavRoutes("onboarding")
    object LoginView : NavRoutes("loginview")
    object LoginRegisterView : NavRoutes("loginregisterview")




}
