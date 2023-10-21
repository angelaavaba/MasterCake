package com.angelaavalos.mastercake.navigation


sealed class Destinations (val route:String)
   {
       //Destinos
    object HomeView: Destinations("HomeView")
    object FavoritesView: Destinations("FavoritesView")
    object MessagesView: Destinations("MessagesView")
    object CartView: Destinations("CartView")

}