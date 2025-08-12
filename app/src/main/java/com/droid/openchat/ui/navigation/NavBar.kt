package com.droid.openchat.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRailItemColors
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItemColors
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.droid.openchat.domain.AppDestinations
import com.droid.openchat.ui.components.CircleIconButton
import com.droid.openchat.ui.message.MessageScreen

@Composable
fun NavBar(modifier: Modifier = Modifier, windowSizeClass: WindowSizeClass) {
    val color = MaterialTheme.colorScheme.onSurface
    val color2 = MaterialTheme.colorScheme.primary
    val drawerItemColors = NavigationDrawerItemDefaults.colors(
        selectedContainerColor = Color.Transparent,
        unselectedContainerColor = Color.Transparent,
        selectedIconColor = color,
        unselectedIconColor = color2,
        selectedTextColor = color,
        unselectedTextColor = color2,
    )
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.MESSAGE) }

    NavigationSuiteScaffold(
        modifier = modifier,
        navigationSuiteColors = NavigationSuiteDefaults.colors(
            navigationBarContainerColor = Color.Transparent,
            navigationRailContainerColor = Color.Transparent,
        ),
        containerColor = MaterialTheme.colorScheme.primary,
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            "",
                            modifier = Modifier
                                .sizeIn(minWidth = 30.dp, minHeight = 20.dp, maxWidth = 70.dp, maxHeight = 70.dp)
                        )
                    },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it },
                    colors = NavigationSuiteItemColors(
                        navigationBarItemColors = NavigationBarItemColors(
                            selectedIndicatorColor = color2,
                            unselectedIconColor = color2,
                            selectedIconColor = color,
                            disabledIconColor = color2,
                            disabledTextColor = Color.Transparent,
                            selectedTextColor = color,
                            unselectedTextColor = color2,
                        ),
                        navigationRailItemColors = NavigationRailItemColors(
                            selectedIndicatorColor = color2,
                            unselectedIconColor = color2,
                            selectedIconColor = color,
                            disabledIconColor = Color.Transparent,
                            disabledTextColor = Color.Transparent,
                            selectedTextColor = color,
                            unselectedTextColor = color2,
                        ),
                        navigationDrawerItemColors = drawerItemColors
                        ),

                )
            }
        },
    ) {
        MessageScreen(modifier = modifier.padding(25.dp), windowSizeClass = windowSizeClass)
    }
}