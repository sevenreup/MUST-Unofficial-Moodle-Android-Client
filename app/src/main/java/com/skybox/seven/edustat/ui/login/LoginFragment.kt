package com.skybox.seven.edustat.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.databinding.FragmentLoginBinding
import com.skybox.seven.edustat.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding;
    private  val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.viewmodel = loginViewModel

        loginViewModel.loggedIn.observe(viewLifecycleOwner, Observer {
            if (loginViewModel.isDownloadPathSet()) {
                startActivity(Intent(requireActivity(), MainActivity::class.java))
            } else {
                findNavController().navigate(R.id.setPermissions)
            }
        })

        return binding.root
    }

}