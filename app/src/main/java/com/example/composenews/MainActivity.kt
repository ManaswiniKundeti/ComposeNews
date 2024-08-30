package com.example.composenews

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.example.composenews.domain.usecases.AppEntryUsecases
import com.example.composenews.presentation.onboarding.OnboardingScreen
import com.example.composenews.presentation.onboarding.OnboardingViewModel
import com.example.composenews.ui.theme.ComposeNewsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appEntryUsecases: AppEntryUsecases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()

        lifecycleScope.launch {
            appEntryUsecases.readAppEntry().collect{
                Log.d("text", it.toString())
            }
        }
        setContent {
            ComposeNewsTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    Log.d("text", "before creating vm instance in MA")
                    val viewModel: OnboardingViewModel = hiltViewModel()
                    Log.d("text", "created vm instance in MA")
                    OnboardingScreen(
                        event = viewModel::onEvent
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeNewsTheme {
        Greeting("Android")
    }
}