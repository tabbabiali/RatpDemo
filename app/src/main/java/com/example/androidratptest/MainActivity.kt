package com.example.androidratptest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidratptest.ui.theme.AndroidRatpTestTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidratptest.screens.FormScreen
import com.example.androidratptest.screens.ListScreen
import com.example.androidratptest.screens.Screens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appViewModel by viewModels<AppViewModel>()
            val navController = rememberNavController()
            val backStackEntry = navController.currentBackStackEntryAsState()
            AndroidRatpTestTheme {
                Scaffold(topBar = {
                    TopAppBar(
                        title = { Text(text = backStackEntry.value?.destination?.route ?: "") },
                        navigationIcon = {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(Icons.Filled.ArrowBack, "dd")
                            }
                        }
                    )
                }) {
                    AppNavHost(navController, appViewModel)
                }
            }
        }
    }

    @Composable
    private fun AppNavHost(
        navController: NavHostController,
        appViewModel: AppViewModel
    ) {
        NavHost(
            navController = navController,
            startDestination = Screens.FORM_SCREEN.name
        ) {
            composable(Screens.FORM_SCREEN.name) {
                FormScreen(appViewModel, navController)
            }
            composable(Screens.LIST_SCREEN.name) {
                ListScreen(appViewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidRatpTestTheme {
        //FormScreen()
    }
}