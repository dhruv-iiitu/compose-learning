package com.example.ladybugproject.activityWithGenericNavGraph

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
//
class GenericComposeActivity<T : NavGraphBuilder<T>> : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val navGraphBuilderClass = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            intent.getParcelableExtraCompat("key")
//        } else {
//            @Suppress("DEPRECATION")
//            intent.getParcelableExtraCompat("key")
//        }
//
//        if (navGraphBuilderClass == null) {
//            finish() // Exit if the class isn't provided
//            return
//        }
//
        setContent {
//            val navController = rememberNavController()

            // Use reflection to create an instance of the nav graph builder
//            val navGraphBuilder = createNavGraphBuilderInstance(navGraphBuilderClass)
//            navGraphBuilder?.BuildGraph(navController)
        }
    }
//
//    inline fun <reified T : Parcelable> Intent.getParcelableExtraCompat(key: String): T? {
//        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            getParcelableExtra(key, T::class.java)
//        } else {
//            @Suppress("DEPRECATION")
//            getParcelableExtra(key)
//        }
//    }
//
//    private fun createNavGraphBuilderInstance(clazz: Class<T>): T? {
//        return try {
//            clazz.getDeclaredConstructor().newInstance()
//        } catch (e: Exception) {
//            e.printStackTrace()
//            null
//        }
//    }
//
    companion object {
        const val NAV_GRAPH_BUILDER_CLASS_KEY = "navGraphBuilderClass"
    }
}









