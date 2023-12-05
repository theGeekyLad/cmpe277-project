package com.rfid.jobgpt.ui.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rfid.jobgpt.R
import com.rfid.jobgpt.ui.theme.JobGPTTheme
import com.rfid.jobgpt.ui.widget.Job

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
class JobsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobGPTTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        item {
                            Text(
                                text = "Jobs",
                                style = MaterialTheme.typography.headlineMedium,
                            )
                        }
                        item {
                            Job(
                                context = applicationContext,
                                crawlDate = "11/25/2023",
                                company = "Google",
                                role = "2024 Android Engineer",
                            )
                        }
                        item {
                            Job(
                                context = applicationContext,
                                crawlDate = "11/25/2023",
                                company = "Google",
                                role = "2024 Android Engineer",
                            )
                        }
                        item {
                            Job(
                                context = applicationContext,
                                crawlDate = "11/25/2023",
                                company = "Google",
                                role = "2024 Android Engineer",
                            )
                        }
                        item {
                            Job(
                                context = applicationContext,
                                crawlDate = "11/25/2023",
                                company = "Google",
                                role = "2024 Android Engineer",
                            )
                        }
                        item {
                            Job(
                                context = applicationContext,
                                crawlDate = "11/25/2023",
                                company = "Google",
                                role = "2024 Android Engineer",
                            )
                        }
                        item {
                            Job(
                                context = applicationContext,
                                crawlDate = "11/25/2023",
                                company = "Google",
                                role = "2024 Android Engineer",
                            )
                        }
                        item {
                            Job(
                                context = applicationContext,
                                crawlDate = "11/25/2023",
                                company = "Google",
                                role = "2024 Android Engineer",
                            )
                        }
                        item {
                            Job(
                                context = applicationContext,
                                crawlDate = "11/25/2023",
                                company = "Google",
                                role = "2024 Android Engineer",
                            )
                        }
                        item {
                            Job(
                                context = applicationContext,
                                crawlDate = "11/25/2023",
                                company = "Google",
                                role = "2024 Android Engineer",
                            )
                        }
                        item {
                            Job(
                                context = applicationContext,
                                crawlDate = "11/25/2023",
                                company = "Google",
                                role = "2024 Android Engineer",
                            )
                        }
                    }
                }
            }
        }
    }
}