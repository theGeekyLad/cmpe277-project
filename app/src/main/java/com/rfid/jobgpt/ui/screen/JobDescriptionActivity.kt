package com.rfid.jobgpt.ui.screen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rfid.jobgpt.ui.theme.JobGPTTheme
import com.rfid.jobgpt.ui.widget.JobDescriptionPager
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
class JobDescriptionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JobGPTTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
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
                            val coroutineScope = rememberCoroutineScope()

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
                                    jobDescription = "Lets assume this is a veryyyy long job " +
                                            "description with " +
                                            "more than just two or three paragraphs. Mighty long!",
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
                                item {
                                    OutlinedButton(
                                        contentPadding = ButtonDefaults.TextButtonContentPadding,
                                        onClick = { /*TODO*/ }
                                    ) {
                                        Text(text = "Is it only for returning interns?")
                                    }
                                }

                                item {
                                    OutlinedButton(
                                        contentPadding = ButtonDefaults.TextButtonContentPadding,
                                        onClick = { /*TODO*/ }
                                    ) {
                                        Text(text = "Is it only for returning interns?")
                                    }
                                }
                            }

                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(text = "Ask ChatGPT ...")
                                },
                                value = "",
                                onValueChange = {}
                            )
                        }
                    }
                }
            }
        }
    }
}