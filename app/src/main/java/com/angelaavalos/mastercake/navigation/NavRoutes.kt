package com.angelaavalos.mastercake.navigation


sealed class NavRoutes (val route:String)
   {
       //Destinos
    object Home: NavRoutes("Home")
    object FavoritesView: NavRoutes("FavoritesView")
    object MessagesView: NavRoutes("MessagesView")
    object CartView: NavRoutes("CartView")

}
