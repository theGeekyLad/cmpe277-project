package com.rfid.jobgpt.ui.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun JobDescriptionPager(
    onClickLeft: () -> Unit,
    onClickRight: () -> Unit,
    jobDescription: String? = null,
    insights: String? = null,
    chatGptResults: String? = null,
    pageNumber: Number,
) {
    Column(
        modifier = Modifier.fillMaxHeight(),
    ) {
        // Our page content
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = onClickLeft) {
                Icon(
                    imageVector = Icons.Filled.ChevronLeft,
                    contentDescription = null,
                )
            }
            when(pageNumber) {
                0 ->
                    Text(
                        modifier = Modifier
                            .weight(1f, true),
                        text = "Job Description",
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                    )
                1 ->
                    Text(
                        modifier = Modifier.weight(1f, true),
                        text = "Insights",
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                    )
                2 ->
                    Text(
                        modifier = Modifier.weight(1f, true),
                        text = "ChatGPT",
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                    )
            }
            IconButton(onClick = onClickRight) {
                Icon(
                    imageVector = Icons.Filled.ChevronRight,
                    contentDescription = null,
                )
            }
        }

        when(pageNumber) {
            0 ->
                Text(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    text = jobDescription ?: ""
                )
            1 ->
                Text(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    text = insights ?: ""
                )
            2 -> {
                Column(
                    modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    if (chatGptResults.isNullOrEmpty())
                        CircularProgressIndicator(
                            modifier = Modifier.width(64.dp),
                            color = MaterialTheme.colorScheme.secondary,
                            trackColor = MaterialTheme.colorScheme.surfaceVariant,
                        )
                    else
                        Text(text = chatGptResults)
                }
            }
        }
    }
}