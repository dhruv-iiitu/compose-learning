package com.example.ladybugproject.part2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ladybugproject.R
import com.example.ladybugproject.activityWithGenericNavGraph.FlowOneNavGraph
import com.example.ladybugproject.activityWithGenericNavGraph.FlowTwoNavGraph
import com.example.ladybugproject.activityWithGenericNavGraph.startGenericFlowActivity

class Part2LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_part2_launcher)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setOnClicks()
    }
    private fun setOnClicks(){
        findViewById<Button>(R.id.btnFlow1).setOnClickListener {

            this.startGenericComposeActivity(FirstGraphFlow())

        }
        findViewById<Button>(R.id.btnFlow2).setOnClickListener {
            this.startGenericComposeActivity(SecondGraphFlow())
        }

    }
}


fun Context.startGenericComposeActivity(graphFlow: GraphFlow) {
    val intent = Intent(this, GenericComposeActivity::class.java).apply {
        putExtra(GenericComposeActivity.GRAPH_FLOW_KEY, graphFlow)
    }
    startActivity(intent)
}