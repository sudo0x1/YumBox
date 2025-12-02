package sudo.dev.yumbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import sudo.dev.yumbox.navigation.Screen
import sudo.dev.yumbox.navigation.SetUpNavGraph
import sudo.dev.yumbox.ui.theme.YumBoxTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            navHostController = rememberNavController()

            // drawer controller
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

            // coroutine scope for launching async operations (like opening/closing drawer)
            val scope = rememberCoroutineScope()

            // define which items should show the bottom nav bar

            val items = listOf(
                Screen.HomeScreen.route,
                Screen.CategoryScreen.route,
                Screen.OrdersScreen.route,
                Screen.YumScreen.route,
                Screen.ProfileScreen.route
            )

            // current screen in nav stack
            val currentNavStack = navHostController.currentBackStackEntryAsState()
            val currentRoute = currentNavStack.value?.destination?.route
            val showBottomAndTopBar = currentNavStack.value?.destination?.route in items

            // for specifying language support
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {

                YumBoxTheme {

//                    ModalNavigationDrawer(
//                        drawerState = drawerState,
//                        drawerContent = {}
//                    ) {
//                        Scaffold(
//                            modifier = Modifier.fillMaxSize(),
//                            topBar = {},
//                            bottomBar = {}
//                        ) {
//                            Column(
//                                modifier = Modifier.fillMaxSize().padding(it)
//                            ) {
//                                SetUpNavGraph(navHostController)
//                            }
//                        }
//                    }
                    if (currentRoute == Screen.SplashScreen.route) {
                        SetUpNavGraph(navHostController)
                    }
                    else {
                        ModalNavigationDrawer(
                            drawerState = drawerState,
                            drawerContent = {}
                        ) {
                            Scaffold(
                                modifier = Modifier.fillMaxSize(),
                                topBar = {},
                                bottomBar = {}
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize().padding(it)
                                ) {
                                    SetUpNavGraph(navHostController)
                                }
                            }
                        }
                    }

                }
            }

        }
    }
}