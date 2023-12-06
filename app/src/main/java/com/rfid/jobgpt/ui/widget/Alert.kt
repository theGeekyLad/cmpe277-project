package com.rfid.jobgpt.ui.widget

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rfid.jobgpt.ui.screen.JobDescriptionActivity

@Composable
fun Alert(
    title: String,
    timestamp: String,
    onClear: () -> Unit
) {
    Column {
        OutlinedCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f, true),
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = timestamp,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
                IconButton(onClick = { onClear() }) {
                    Icon(
                        imageVector = Icons.Filled.ClearAll,
                        contentDescription = null,
                    )
                }
            }
        }
    }
}