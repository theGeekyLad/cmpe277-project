package com.rfid.jobgpt.ui.screen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rfid.jobgpt.ui.theme.JobGPTTheme
import com.rfid.jobgpt.ui.widget.AppBar
import com.rfid.jobgpt.ui.widget.JobDescriptionPager
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
class JobDescriptionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val promptText = remember { mutableStateOf("") }
            val coroutineScope = rememberCoroutineScope()
            val quickQuestionTexts = remember {
                mutableStateListOf(
                    "Is it only for returning interns?",
                    "When do I join?",
                    "Is sponsorship offered?",
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
                            AppBar(applicationContext, "Job Details")
                        }
                    ) { it ->
                        Column(
                            modifier = Modifier.padding(it).padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Column {
                                Text(
                                    text = "2024 Android Engineer University Graduate",
                                    style = MaterialTheme.typography.headlineMedium
                                )
                                Text(
                                    text = "Google",
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }

                            Column {
                                Text(
                                    text = "Posted: 10/29/2023",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = "Crawled: 11/09/2023",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }

                            val pagerState = rememberPagerState(pageCount = {
                                3
                            })

                            Column(
                                modifier = Modifier.weight(1f, true)
                            ) {

                                HorizontalPager(state = pagerState) { page ->
                                    Log.e("page", page.toString())
                                    JobDescriptionPager(
                                        onClickLeft = {
                                            coroutineScope.launch {
                                                if (page != 0)
                                                    pagerState.animateScrollToPage(page - 1)
                                            }
                                        },
                                        onClickRight = {
                                            coroutineScope.launch {
                                                if (page != 2)
                                                    pagerState.animateScrollToPage(page + 1)
                                            }
                                        },
                                        pageNumber = page,
                                        jobDescription = "Google's software engineers develop the next-generation technologies that change how billions of users connect, explore, and interact with information and one another. Our products need to handle information at massive scale, and extend well beyond web search. We're looking for engineers who bring fresh ideas from all areas, including information retrieval, distributed computing, large-scale system design, networking and data storage, security, artificial intelligence, natural language processing, UI design and mobile; the list goes on and is growing every day. As a software engineer, you will work on a specific project critical to Google’s needs with opportunities to switch teams and projects as you and our fast-paced business grow and evolve. We need our engineers to be versatile, display leadership qualities and be enthusiastic to take on new problems across the full-stack as we continue to push technology forward.\n" +
                                                "\n" +
                                                "With your technical expertise you will manage project priorities, deadlines, and deliverables. You will design, develop, test, deploy, maintain, and enhance software solutions.\n" +
                                                "\n" +
                                                "The Google Pixel team focuses on designing and delivering the world's most helpful mobile experience. The team works on shaping the future of Pixel devices and services through some of the most advanced designs, techniques, products, and experiences in consumer electronics. This includes bringing together the best of Google’s artificial intelligence, software, and hardware to build global smartphones and create transformative experiences for users across the world.\n" +
                                                "\n" +
                                                "The US base salary range for this full-time position is \$133,000-\$194,000 + bonus + equity + benefits. Our salary ranges are determined by role, level, and location. The range displayed on each job posting reflects the minimum and maximum target for new hire salaries for the position across all US locations. Within the range, individual pay is determined by work location and additional factors, including job-related skills, experience, and relevant education or training. Your recruiter can share more about the specific salary range for your preferred location during the hiring process.\n" +
                                                "\n" +
                                                "Please note that the compensation details listed in US role postings reflect the base salary only, and do not include bonus, equity, or benefits. Learn more about benefits at Google .\n",
                                        insights = "This one's going to be super succinct."
                                    )
                                }
                            }

                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                LazyRow(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    quickQuestionTexts.forEach { question ->
                                        item {
                                            OutlinedButton(
                                                contentPadding = ButtonDefaults.TextButtonContentPadding,
                                                onClick = {
                                                    coroutineScope.launch {
                                                        pagerState.animateScrollToPage(2)
                                                    }
                                                }
                                            ) {
                                                Text(text = question)
                                            }
                                        }
                                    }
                                }

                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    OutlinedTextField(
                                        modifier = Modifier.weight(1f, true),
                                        placeholder = {
                                            Text(text = "Ask ChatGPT ...")
                                        },
                                        value = promptText.value,
                                        onValueChange = { promptText.value = it },
                                    )
                                    IconButton(
                                        onClick = {
                                            if (promptText.value.isNotBlank())
                                                coroutineScope.launch {
                                                    pagerState.animateScrollToPage(2)
                                                }
                                            promptText.value = ""
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.Send,
                                            contentDescription = null,
                                            tint = MaterialTheme.colorScheme.primary
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
}