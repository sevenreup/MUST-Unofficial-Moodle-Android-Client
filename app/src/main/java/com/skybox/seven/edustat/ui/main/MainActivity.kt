package com.skybox.seven.edustat.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelStore
import com.skybox.seven.edustat.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.siteData.observe(this, Observer {

            if (it != null) {
                Toast.makeText(applicationContext, it.fullName , Toast.LENGTH_SHORT).show()
            } else Toast.makeText(this, viewModel.getSiteData(), Toast.LENGTH_SHORT).show()
        })
    }
}