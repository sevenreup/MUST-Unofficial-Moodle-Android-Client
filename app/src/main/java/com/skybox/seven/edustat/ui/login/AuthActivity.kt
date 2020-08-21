package com.skybox.seven.edustat.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.skybox.seven.edustat.databinding.ActivityLoginBinding
import com.skybox.seven.edustat.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "AuthActivity"
@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {

    private  val loginViewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    companion object {
        const val REQUESTCODE = 42069
    }
}