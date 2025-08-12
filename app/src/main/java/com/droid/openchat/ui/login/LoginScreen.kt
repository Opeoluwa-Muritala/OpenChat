package com.droid.openchat.ui.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.droid.openchat.R
import com.droid.openchat.ui.components.UiButton
import com.droid.openchat.util.DeviceConfiguration

@Composable
fun LoginScreen(
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
            .clip(
                RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 15.dp
                )
            )
            .background(MaterialTheme.colorScheme.primary)
            .padding(
                horizontal = 16.dp,
                vertical = 24.dp
            )
            .consumeWindowInsets(WindowInsets.navigationBars)

        val deviceConfiguration = DeviceConfiguration.fromWindowSizeClass(windowSizeClass)
        when(deviceConfiguration) {
            DeviceConfiguration.MOBILE_PORTRAIT -> {

                Column(
                    modifier = rootModifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.weight(0.5f))
                    ScreenHeader()
                    Spacer(Modifier.weight(0.5f))
                    AuthenticationButtons()
                    Spacer(Modifier.weight(0.1f))
                    Footer()
                    Spacer(Modifier.weight(0.5f))
                }
            }
            DeviceConfiguration.MOBILE_LANDSCAPE -> {
                Row(
                    rootModifier.padding(10.dp)
                ) {
                    Column(Modifier.weight(0.5f), verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally){
                        ScreenHeader()
                        Spacer(Modifier.weight(5f))
                    }
                    Column(
                        Modifier.weight(0.5f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(Modifier.weight(1f))
                        AuthenticationButtons()
                        Footer()
                        Spacer(Modifier.weight(1f))
                    }
                }
            }
            DeviceConfiguration.TABLET_PORTRAIT,
            DeviceConfiguration.TABLET_LANDSCAPE,
            DeviceConfiguration.DESKTOP -> {
                Row(
                    rootModifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Spacer(Modifier.weight(1f))
                    Column(
                        modifier = Modifier.fillMaxSize(0.5f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(Modifier.weight(1f))
                        ScreenHeader()
                        AuthenticationButtons()
                        Footer()
                    }
                    Spacer(Modifier.weight(1f))
                }
            }
        }
    }
}


@Composable
private fun ScreenHeader(modifier: Modifier = Modifier){
    Column(modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {  Image(
        painter = painterResource(R.drawable.header_icon),
        contentDescription = "Header Icon",
        modifier = Modifier.sizeIn(maxWidth = 900.dp, maxHeight = 900.dp)
    )
    }

}

@Composable
private fun AuthenticationButtons(modifier: Modifier= Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UiButton(
            onButtonClick = {},
            text = "Continue with Google",
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
                .heightIn(min = 60.dp, max = 120.dp),
            backgroundColor = MaterialTheme.colorScheme.onSurface,
            textColor = MaterialTheme.colorScheme.background,
            style = MaterialTheme.typography.labelLarge,
            shape = RoundedCornerShape(50.dp),
        )
        Text("Already a Member?", style = MaterialTheme.typography.bodySmall)
        UiButton(
            onButtonClick = {},
            text = "Log In",
            textColor = MaterialTheme.colorScheme.onSurface,
            backgroundColor = MaterialTheme.colorScheme.background,
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
                .heightIn(min = 60.dp, max = 120.dp),
            style = MaterialTheme.typography.labelLarge,
            shape = RoundedCornerShape(50.dp),
        )
    }
}

@Composable
private fun Footer(modifier: Modifier = Modifier){
    Row(modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)) {
        Text(
            "By Signing up, you accept OpenChat Terms of Service and acknowledge that you" +
                    " have read Privacy and Cookie Take a look at Your Privacy at a Glance",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

