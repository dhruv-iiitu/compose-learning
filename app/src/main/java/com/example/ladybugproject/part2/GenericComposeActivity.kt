package com.example.ladybugproject.part2

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

class GenericComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Retrieve the GraphFlow from the intent
        val graphFlow = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.extras?.getParcelable(GRAPH_FLOW_KEY, GraphFlow::class.java)
                ?: throw IllegalArgumentException("GraphFlow not provided")
        } else {
            intent.extras?.getParcelable(GRAPH_FLOW_KEY)
                ?: throw IllegalArgumentException("GraphFlow not provided")
        }

        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = graphFlow.startDestination
            ) {
                graphFlow.buildNavGraph(this, navController)
            }
        }
    }

    companion object {
        const val GRAPH_FLOW_KEY = "GRAPH_FLOW_KEY"
    }
}




