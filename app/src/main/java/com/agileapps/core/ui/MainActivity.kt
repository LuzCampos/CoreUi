package com.agileapps.core.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import com.agileapps.core.ui.ui.theme.CoreuiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoreuiTheme {
                /*
                OverviewAltScreen(
                    title = "Overview",
                    description = "OverviewScreen",
                    backgroundColor = Color.Cyan.toArgb(),
                    titleAffinityLevel = "Affinity rate",
                    affinityLevel = "99",
                    textButton = "Let's go",
                    contentColorButton = Color.Black,
                ) {

                }*/
                /*
                OverviewScreen(
                    backgroundColorInside = Color.Green.toArgb(),
                    backgroundColorOutside = Color.Black.toArgb(),
                    title = "Overview",
                    description = "Overview Screen",
                    //leftIcon = com.agileapps.core.ui.R.drawable.baseline_monitor_heart_24,
                    //rightIcon = com.agileapps.core.ui.R.drawable.baseline_monitor_heart_24
                ) {

                }
                */
                PresentationScreen(
                    title = "NiceDex",
                    titleColor = Color(0xff494949),
                    description = "Get Started",
                    textButton = "Get Started NiceDex NiceDex NiceDex",
                   // coverImage = R.drawable.pokedexbackgroundscreen,
                    contentColorButton = Color(0xff494949)
                ) {
                 //   Toast.makeText(this,"Button Click", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
