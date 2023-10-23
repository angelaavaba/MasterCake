package com.angelaavalos.mastercake.navigation


sealed class NavRoutes (val route:String)
   {
       //Destinos
    object Home: NavRoutes("homeroute")
    object FavoritesView: NavRoutes("favoritesroute")
    object NotificationsView: NavRoutes("notificationsroute")
    object CartView: NavRoutes("cartroute")

}
