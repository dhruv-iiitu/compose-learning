package com.example.ladybugproject.activityWithGenericNavGraph

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ladybugproject.R


class GenericNavGraphMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_generic_nav_graph_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setOnClicks()
    }
    private fun setOnClicks(){
        findViewById<Button>(R.id.btnFlow1).setOnClickListener {
//            GenericComposeActivity.start(this, FlowOneNavGraphFactory())

            this.startGenericFlowActivity<FlowOneNavGraph>()

        }
        findViewById<Button>(R.id.btnFlow2).setOnClickListener {
//            GenericComposeActivity.start(this, FlowTwoNavGraphFactory())
            this.startGenericFlowActivity<FlowTwoNavGraph>()

        }

    }
}