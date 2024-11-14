package com.example.ladybugproject.activityWithGenericNavGraph.factoryPattern

import com.example.ladybugproject.activityWithGenericNavGraph.FlowOneNavGraph
import com.example.ladybugproject.activityWithGenericNavGraph.FlowTwoNavGraph
import com.example.ladybugproject.activityWithGenericNavGraph.NavGraphBuilder

interface NavGraphBuilderFactory {
    fun create(): NavGraphBuilder<*>
}
class FlowOneNavGraphFactory : NavGraphBuilderFactory {
    override fun create(): NavGraphBuilder<*> = FlowOneNavGraph()
}

class FlowTwoNavGraphFactory : NavGraphBuilderFactory {
    override fun create(): NavGraphBuilder<*> = FlowTwoNavGraph()
}