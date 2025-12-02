package sudo.dev.yumbox.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import sudo.dev.yumbox.R
import sudo.dev.yumbox.navigation.Screen
import sudo.dev.yumbox.ui.theme.YumCream
import sudo.dev.yumbox.utils.isOnline

@Composable
fun SplashScreen(
    navHostController: NavHostController
){
    val localContext = LocalContext.current

    if(!localContext.isOnline()){

    }else{
        LaunchedEffect(true) {
            delay(3000)
            navHostController.navigate(Screen.HomeScreen.route) {
                popUpTo(0) {
                    inclusive = true
                }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize().background(YumCream)
    ) {
        Image(
            painter = painterResource(R.drawable.logo_splash),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
        )
    }
}