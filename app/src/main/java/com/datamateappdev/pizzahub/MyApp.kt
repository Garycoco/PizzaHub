package com.datamateappdev.pizzahub

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.datamateappdev.pizzahub.data.PizzaItem
import com.datamateappdev.pizzahub.navigation.AppRoute
import com.datamateappdev.pizzahub.navigation.NavigationActions
import com.datamateappdev.pizzahub.navigation.TOP_LEVEL_DESTINATIONS
import com.datamateappdev.pizzahub.screens.cart.MyCart
import com.datamateappdev.pizzahub.screens.favorites.MyFavorites
import com.datamateappdev.pizzahub.screens.home.HomeScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MyApp(items: List<PizzaItem>) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()
    val navigationActions = remember(navController) {
        NavigationActions(navController)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedDestination =
        navBackStackEntry?.destination?.route ?: AppRoute.HOME

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(modifier = Modifier.padding(vertical = 30.dp, horizontal = 10.dp)) {
                    TOP_LEVEL_DESTINATIONS.forEach { destination ->
                        val selected = selectedDestination == destination.route
                        NavigationDrawerItem(
                            icon = {
                                Icon(
                                    imageVector = destination.icon,
                                    contentDescription = destination.iconTextId
                                )
                            },
                            label = {
                                Text(
                                    text = destination.route,
                                    style = MaterialTheme.typography.labelLarge
                                )
                            },
                            selected = selected,
                            onClick = { navigationActions.navigateTo(destination) })
                    }
                }
            }
        },
        drawerState = drawerState,
    ) {
        NavHost(navController = navController, startDestination = AppRoute.HOME) {
            composable(AppRoute.HOME) {
                PizzaHubWrapper(
                    items = items,
                    scope = scope,
                    drawerState = drawerState
                )
            }
            composable(AppRoute.FAVORITES) {
                MyFavorites()
            }
            composable(AppRoute.CART) {
                MyCart()
            }
        }
    }
}

@Composable
fun PizzaHubWrapper(
    items: List<PizzaItem>,
    scope: CoroutineScope,
    drawerState: DrawerState,
) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        HomeScreen(items = items, onMenuClicked = {
            scope.launch {
                drawerState.apply {
                    if (isClosed) open() else close()
                }
            }
        })
    }
}