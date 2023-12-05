package com.rfid.jobgpt.nav

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Agriculture
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Source
import androidx.compose.ui.graphics.vector.ImageVector
import com.rfid.jobgpt.R

sealed class Fragment(
    val title: String,
    val route: String,
    val icon: ImageVector,
    @StringRes val resourceId: Int
) {
    object Filters: Fragment(
        "Filters",
        "filters",
        Icons.Filled.FilterAlt,
        R.string.bottom_nav_item_filters)

    object Sources: Fragment(
        "Sources",
        "sources",
        Icons.Filled.Source,
        R.string.bottom_nav_item_sources)
}