package com.droid.openchat.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun UiButton(
    modifier: Modifier = Modifier,
    style: TextStyle,
    text: String,
    backgroundColor: Color = Color.White,
    textColor: Color = Color.Black,
    onButtonClick: () -> Unit,
    shape:Shape = RoundedCornerShape(20.dp)
) {
    Button(
        modifier = modifier,
        onClick = onButtonClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor,
        ),
        shape = shape
    ) {
        Text(
            text,
            style = style,
            color = textColor
        )
    }
}