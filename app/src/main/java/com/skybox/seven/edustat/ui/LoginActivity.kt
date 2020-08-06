package com.skybox.seven.edustat.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.skybox.seven.edustat.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}