package com.rfid.jobgpt

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.rfid.jobgpt.ui.screen.AlertsActivity
import com.rfid.jobgpt.ui.screen.JobDescriptionActivity
import com.rfid.jobgpt.ui.screen.JobsActivity
import com.rfid.jobgpt.ui.screen.SettingsActivity
import com.rfid.jobgpt.ui.theme.JobGPTTheme
import com.rfid.jobgpt.ui.widget.Job
import com.rfid.jobgpt.work.ChatGptWorker
import com.rfid.jobgpt.work.JobsWorker

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobGPTTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(text = "HelloWorld! Hope we aren't fucked. :)")
                }
            }
        }

        // workmanager stuff
        val constraints = Constraints
            .Builder()
            .setRequiresCharging(true)
            .build()

        val jobsWorkRequest = OneTimeWorkRequestBuilder<JobsWorker>()
            .setConstraints(constraints)
            .build()

        val chatGptWorkRequest = OneTimeWorkRequestBuilder<ChatGptWorker>().build()

        WorkManager
            .getInstance(applicationContext)
            .enqueue(jobsWorkRequest)

//        WorkManager
//            .getInstance(applicationContext)
//            .enqueue(chatGptWorkRequest)

        startActivity(Intent(applicationContext, JobsActivity::class.java))
    }
}
