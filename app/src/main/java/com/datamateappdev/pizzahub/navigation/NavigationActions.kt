package com.datamateappdev.pizzahub.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

object AppRoute {
    const val HOME = "Home"
    const val FAVORITES = "Favorites"
    const val CART = "Cart"
}
data class TopLevelDestinations(
    val route: String,
    val icon: ImageVector,
    val iconTextId: String
)
class NavigationActions(private val navController: NavController) {
    fun navigateTo(destinations: TopLevelDestinations) {
        navController.navigate(destinations.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestinations(
        route = AppRoute.HOME,
        icon = Icons.Rounded.Home,
        iconTextId = "home icon"
    ),
    TopLevelDestinations(
        route = AppRoute.FAVORITES,
        icon = Icons.Rounded.Favorite,
        iconTextId = "favorites icon"
    ),
    TopLevelDestinations(
        route = AppRoute.CART,
        icon = Icons.Rounded.ShoppingCart,
        iconTextId = "shopping cart icon"
    ),
)