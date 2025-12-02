package sudo.dev.yumbox.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import sudo.dev.yumbox.screens.HomeScreen
import sudo.dev.yumbox.screens.SplashScreen

@Composable
fun SetUpNavGraph(navHostController: NavHostController){

    NavHost(
        navController = navHostController,
        startDestination = Screen.SplashScreen.route
    ){

        composable(Screen.SplashScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            SplashScreen(navHostController)
        }
        composable(Screen.HomeScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut(animationSpec = tween(700)) }
        ) {
            HomeScreen(navHostController)
        }
        composable(Screen.OrdersScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut(animationSpec = tween(700)) }
        ) {
            HomeScreen(navHostController)
        }
    }
}