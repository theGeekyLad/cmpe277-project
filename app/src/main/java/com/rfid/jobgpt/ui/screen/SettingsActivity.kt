package com.rfid.jobgpt.ui.screen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
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
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rfid.hack277.nav.Page
import com.rfid.jobgpt.nav.Fragment
import com.rfid.jobgpt.ui.theme.JobGPTTheme
import com.rfid.jobgpt.ui.widget.JobDescriptionPager
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
class SettingsActivity : ComponentActivity() {

    private val navFragments = listOf(
        Fragment.Filters,
        Fragment.Sources,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val currentBackStackEntry by navController.currentBackStackEntryAsState()
            var pageTitle by remember { mutableStateOf("") }

            JobGPTTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(
                                text = "Settings",
                                style = MaterialTheme.typography.headlineMedium
                            )

                            Text(
                                text = "Last synced: 11/24/2023 15:48",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                        Scaffold(
                            bottomBar = {
                                BottomNavigation(
                                    backgroundColor = MaterialTheme.colorScheme.primary,
                                ) {
                                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                                    val currentDestination = navBackStackEntry?.destination

                                    navFragments.forEach { navFragment ->
                                        BottomNavigationItem(
                                            alwaysShowLabel = false,
                                            icon = {
                                                Icon(
                                                    imageVector = navFragment.icon,
                                                    contentDescription = null,
                                                    tint = Color.White
                                                )
                                            },
                                            label = {
                                                Text(
                                                    text = navFragment.title,
                                                    color = Color.White,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                            },
                                            selected = currentDestination?.hierarchy?.any { it.route == navFragment.route } == true,
                                            onClick = {
                                                pageTitle = navFragment.title

                                                navController.navigate(navFragment.route) {
                                                    popUpTo(navController.graph.findStartDestination().id) {
                                                        saveState = true
                                                    }
                                                    launchSingleTop = true
                                                    restoreState = true
                                                }
                                            }
                                        )
                                    }

                                }
                            }
                        ) { innerPadding ->
                            NavHost(
                                navController = navController,
                                startDestination = Fragment.Filters.route,
                                modifier = Modifier.padding(innerPadding)
                            ) {
                                composable(Fragment.Filters.route) {
                                    Column(
                                        modifier = Modifier.padding(16.dp),
                                    ) {
                                        Text(text = "HelloFilters!")
                                    }
                                }
                                composable(Fragment.Sources.route) {
                                    Column(
                                        modifier = Modifier.padding(16.dp),
                                    ) {
                                        Text(text = "HelloSources!")
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