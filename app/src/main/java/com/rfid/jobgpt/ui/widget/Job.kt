package com.rfid.jobgpt.ui.widget

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.rfid.jobgpt.ui.screen.JobDescriptionActivity
import com.rfid.jobgpt.ui.theme.JobGPTTheme

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun Job(
    context: Context,
    role: String,
    company: String,
    crawlDate: String,
) {
    Column {
        Card(
            modifier = Modifier.fillMaxWidth().clickable {
                // TODO supply job description data here
                context.startActivity(Intent(context, JobDescriptionActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                })
            }
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = role,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = company,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = "Crawled: $crawlDate",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}