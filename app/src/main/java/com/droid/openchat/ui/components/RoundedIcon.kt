package com.droid.openchat.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CircleIconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    desc: String = "",
    onClick: () -> Unit = {},
    enabled: Boolean = false,
    circleColor: Color = Color.Transparent,
    iconColor : Color = Color.Gray
) {
    Box(
        modifier
            .clip(CircleShape)
            .background(circleColor)
            .sizeIn(minWidth = 50.dp, minHeight = 50.dp, maxWidth = 120.dp, maxHeight = 120.dp)
            .clickable(enabled = enabled){
                onClick()
            }
    ){
        Icon(
            imageVector =icon,
            contentDescription = desc,
            tint = iconColor,
            modifier = Modifier
                .align(Alignment.Center)
                .sizeIn(minWidth = 20.dp, minHeight = 20.dp, maxWidth = 70.dp, maxHeight = 70.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RoundedIconPreview(){
    CircleIconButton(
        icon = Icons.Rounded.Settings
    )
}