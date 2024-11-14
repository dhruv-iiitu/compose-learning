package com.example.ladybugproject.activityWithGenericNavGraph

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.ladybugproject.activityWithGenericNavGraph.factoryPattern.NavGraphBuilderFactory

class GenericComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            // Use the factory to create and set up the appropriate NavGraphBuilder
            val navGraphBuilder = factory?.create()
            navGraphBuilder?.BuildGraph(navController)
        }
    }

    companion object {
        // Holds the current factory instance to be set before starting the activity
        var factory: NavGraphBuilderFactory? = null

        fun start(context: Context, navGraphBuilderFactory: NavGraphBuilderFactory) {
            factory = navGraphBuilderFactory
            val intent = Intent(context, GenericComposeActivity::class.java)
            context.startActivity(intent)
        }
    }
}




