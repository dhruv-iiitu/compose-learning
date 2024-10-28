package com.example.ladybugproject.fragmentsBackPressedDispatcher

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.ladybugproject.R

class FragmentContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragment_container)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleOnClickListeners()
    }
    private fun handleOnClickListeners(){
        findViewById<Button>(R.id.btnFgA).setOnClickListener{
            openFragment(FragmentA.newInstance())
        }
        findViewById<Button>(R.id.btnFgB).setOnClickListener{
            openFragment(FragmentB.newInstance())
        }
        findViewById<Button>(R.id.btnFgC).setOnClickListener{
            openFragment(FragmentC.newInstance())
        }
    }

    private fun openFragment(fragment: Fragment){
        val currentFg = supportFragmentManager.findFragmentById(R.id.fgContainer) ?: FragmentA.newInstance()
        val currentFragmentName = currentFg::class.simpleName
        if( currentFragmentName != fragment::class.simpleName ){
            supportFragmentManager.beginTransaction().replace(R.id.fgContainer,fragment).addToBackStack(currentFg::class.simpleName).commit()
        }
    }
}