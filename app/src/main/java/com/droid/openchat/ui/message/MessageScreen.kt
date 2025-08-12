package com.droid.openchat.ui.message

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.droid.openchat.ui.components.CircleIconButton
import com.droid.openchat.util.DeviceConfiguration

@Composable
fun MessageScreen(
    modifier: Modifier = Modifier,
    windowSizeClass: WindowSizeClass
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.statusBars
    ) { innerPadding ->
        val rootModifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.primary)
            .padding(
                horizontal = 16.dp,
                vertical = 30.dp
            )
            .consumeWindowInsets(WindowInsets.navigationBars)

        val deviceConfiguration = DeviceConfiguration.fromWindowSizeClass(windowSizeClass)
        when(deviceConfiguration) {
            DeviceConfiguration.MOBILE_PORTRAIT -> {
                Column(rootModifier){
                    MessageHeader()
                }
            }
            DeviceConfiguration.MOBILE_LANDSCAPE -> {
                Column(rootModifier){
                    MessageHeader()
                }
            }
            DeviceConfiguration.TABLET_PORTRAIT,
            DeviceConfiguration.TABLET_LANDSCAPE,
            DeviceConfiguration.DESKTOP -> {
                Column(rootModifier){
                    MessageHeader()
                }

            }
        }
    }
}

@Composable
private fun MessageHeader(modifier: Modifier = Modifier) {
    Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        CircleIconButton(
            icon = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            circleColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.34f),
            enabled = true,
        )
        Text("Message", style = MaterialTheme.typography.headlineLarge)
        CircleIconButton(
            icon = Icons.Default.MoreHoriz,
            circleColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.34f),
            enabled = true,
        )
    }
}