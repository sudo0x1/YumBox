package sudo.dev.yumbox.navigation

sealed class Screen(val route: String) {

    data object SplashScreen : Screen("Splash_Screen")
    data object HomeScreen : Screen("Home_Screen")
    data object LoginScreen : Screen("Login_Screen")
    data object OrdersScreen : Screen("Orders_Screen")
    data object ProfileScreen : Screen("Profile_Screen")
    data object CategoryScreen : Screen("Category_Screen")
    data object ProductDetailScreen : Screen("ProductDetail_Screen")
    data object ProfileInfoScreen : Screen("ProfileInfo_Screen")
    data object CommentAndReplies : Screen("CommentAndReplies_Screen")
    data object YumScreen : Screen("Yum_Screen")
    data object FavScreen : Screen("Fav_Screen")
    object DetailsScreen : Screen("details/{itemId}") {
        fun createRoute(itemId: String) = "details/$itemId"
    }

}