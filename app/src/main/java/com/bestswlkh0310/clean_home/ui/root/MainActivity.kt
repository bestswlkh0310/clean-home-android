package com.bestswlkh0310.clean_home.ui.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.bestswlkh0310.clean_home.application.CleanHomeApplication
import com.bestswlkh0310.clean_home.application.PreferenceManager
import com.bestswlkh0310.clean_home.ui.theme.CleanhomeTheme
import java.util.UUID

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            handlePrefs()
            handleUUID()

            val navController = rememberNavController()

            CleanhomeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationGraph(navController = navController)
                }
            }
        }
    }

    fun handlePrefs() {
        CleanHomeApplication.prefs = PreferenceManager(applicationContext)
    }

    fun handleUUID() {
        if (CleanHomeApplication.prefs.id.isEmpty()) {
            CleanHomeApplication.prefs.id = UUID.randomUUID().toString()
        }
    }
}
