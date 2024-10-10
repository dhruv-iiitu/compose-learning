package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val navHostController = rememberNavController()
                val startDestination = "mainScreen2/2"  // Correctly format the startDestination
                AppNavigation(navController = navHostController, startDestination = startDestination)
            }
        }
    }

    @Composable
    fun AppNavigation(modifier: Modifier = Modifier, navController: NavHostController, startDestination: String) {
        Log.e("TAG",startDestination)
        NavHost(navController = navController, startDestination = startDestination) {
            composable("mainScreen/{groupItemId}",
                arguments = listOf(navArgument("groupItemId") { type = NavType.IntType })
            ){backStackEntry->
                val groupItemId = backStackEntry.arguments?.getInt("groupItemId")
                MainScreen1(groupItemId = groupItemId!!)
            }
            composable("mainScreen2/{groupItemId}",
                arguments = listOf(navArgument("groupItemId") { type = NavType.IntType })
            ){backStackEntry->
                val groupItemId = backStackEntry.arguments?.getInt("groupItemId")
                MainScreen2(groupItemId = groupItemId!!)
            }
        }
    }
}

