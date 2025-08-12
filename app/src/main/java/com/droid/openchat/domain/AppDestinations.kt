package com.droid.openchat.domain

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.droid.openchat.R

enum class AppDestinations(
    @StringRes val label: Int,
    val icon: ImageVector,
    @StringRes val contentDescription: Int
) {
    MESSAGE(R.string.message, Icons.AutoMirrored.Filled.Message, R.string.message),
    CALL(R.string.call, Icons.Default.Call, R.string.call),
    PROFILE(R.string.profile, Icons.Default.Person, R.string.profile)
}