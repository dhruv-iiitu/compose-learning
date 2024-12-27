package com.example.ladybugproject.typeSafeNavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Composable
fun MainGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = Modifier
    ) {
        composable<HomeRoute> {
            HomeScreenA(
                modifier = Modifier.fillMaxSize(),
                onClick = {
                    navController.navigate(
                        UserRoute(
                            user = User(name = "Dhruv", id = 1),
                        )
                    )
                }
            )
        }
        composable<UserRoute>(
            typeMap = mapOf(
                typeOf<User>() to CustomNavType.UserType,
            )
        ) {
            val arguments = it.toRoute<UserRoute>()
            UserScreen(
                modifier = Modifier.fillMaxSize(),
                user = arguments.user,
            )
        }
    }

}

@Composable
fun HomeScreenA(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick) {
            Text("User screen")
        }
    }
}

@Composable
fun UserScreen(modifier: Modifier = Modifier, user: User) {
    Column(
        modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("userId -> ${user.id}")
        Text("userName -> ${user.name}")
    }
}


@Serializable
object HomeRoute

@Serializable
data class UserRoute(
    val user: User
)