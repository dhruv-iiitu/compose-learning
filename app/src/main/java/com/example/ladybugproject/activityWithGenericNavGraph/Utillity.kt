package com.example.ladybugproject.activityWithGenericNavGraph

import android.content.Context
import android.content.Intent

inline fun <reified T : NavGraphBuilder<T>> Context.startGenericFlowActivity() {
    val intent = Intent(this, GenericComposeActivity::class.java).apply {
        putExtra(GenericComposeActivity.NAV_GRAPH_BUILDER_CLASS_KEY, T::class.java)
    }
    startActivity(intent)
}

