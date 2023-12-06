package com.rfid.jobgpt.ui.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun Filters() {
    val filters = remember { mutableStateListOf(
        "3 years of experience at TCS",
        "SJSU student",
        "Master's in SE",
    ) }

    val checkedStates = remember { mutableStateListOf(
        false,
        false,
        false,
    ) }

    val currentFilter = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Filters",
            style = MaterialTheme.typography.titleLarge,
        )

        Column {
            filters.forEachIndexed { i, filter ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Checkbox(
                        checked = checkedStates[i],
                        onCheckedChange = { checkedStates[i] = it }
                    )

                    Text(
                        modifier = Modifier.weight(1f, true),
                        text = filter,
                    )

                    IconButton(onClick = {
                        filters.removeAt(i)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f, true))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f, true),
                placeholder = {
                    Text(
                        text = "Something about yourself"
                    )
                },
                value = currentFilter.value,
                onValueChange = { currentFilter.value = it },
            )
            IconButton(
                onClick = {
                    if (currentFilter.value.isNotBlank()) {
                        filters.add(currentFilter.value)
                        checkedStates.add(false)
                    }
                    currentFilter.value = ""
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Save,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}