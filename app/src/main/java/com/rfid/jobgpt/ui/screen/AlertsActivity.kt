package com.rfid.jobgpt.ui.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rfid.jobgpt.R
import com.rfid.jobgpt.model.Alert
import com.rfid.jobgpt.ui.theme.JobGPTTheme
import com.rfid.jobgpt.ui.widget.Alert
import com.rfid.jobgpt.ui.widget.AppBar
import com.rfid.jobgpt.ui.widget.Job

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
class AlertsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val alerts = remember {
                mutableStateListOf(
                    Alert(
                        "5 new on LinkedIn",
                        "12/03/2023 15:45"
                    ),
                    Alert(
                        "2 new on CS GitHub",
                        "11/29/2023 11:26"
                    )
                )
            }

            JobGPTTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            AppBar(
                                applicationContext,
                                "Alerts"
                            )
                        }
                    ) {
                        LazyColumn(
                            modifier = Modifier
                                .padding(it)
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                        ) {
                            alerts.forEachIndexed { i, alert ->
                                item {
                                    Alert(
                                        title = alert.title,
                                        timestamp = alert.timestamp,
                                        onClear = {
                                            alerts.removeAt(i)
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}