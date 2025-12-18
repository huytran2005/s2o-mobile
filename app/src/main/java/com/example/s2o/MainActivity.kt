package com.example.s2o

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.s2o.navigation.SetupNavGraph
import com.example.s2o.ui.onboarding.OnBoardingScreenFirst
import com.example.s2o.ui.onboarding.OnBoardingScreenThird
import com.example.s2o.ui.theme.S2oTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S2oTheme {
               val navController = rememberNavController()
                SetupNavGraph(navController = navController)

            }
        }
    }
}
