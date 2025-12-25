package com.example.s2o

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.s2o.core.network.ApiClient
import com.example.s2o.data.remote.auth.AuthApi
import com.example.s2o.data.repository.AuthRepository
import com.example.s2o.navigation.RootNavGraph
import com.example.s2o.ui.auth.AuthViewModel
import com.example.s2o.ui.auth.AuthViewModelFactory
import com.example.s2o.ui.theme.S2oTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // bật edge-to-edge
        enableEdgeToEdge()

        // 🔥 ẨN SYSTEM NAVIGATION BAR (gesture bar)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).apply {
            hide(WindowInsetsCompat.Type.navigationBars())
            systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        setContent {
            S2oTheme {

                val navController = rememberNavController()

                // Auth ViewModel (như bạn đang dùng)
                val authApi = ApiClient.create(AuthApi::class.java)
                val authRepository = AuthRepository(authApi)
                val authViewModel: AuthViewModel = viewModel(
                    factory = AuthViewModelFactory(authRepository)
                )

                RootNavGraph(
                    navController = navController,
                    authViewModel = authViewModel
                )
            }
        }
    }
}
