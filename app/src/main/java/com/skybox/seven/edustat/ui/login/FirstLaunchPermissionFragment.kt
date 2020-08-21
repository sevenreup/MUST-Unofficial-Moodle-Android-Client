package com.skybox.seven.edustat.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.skybox.seven.edustat.databinding.FragmentFirstLaunchPermissionBinding
import com.skybox.seven.edustat.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "FirstLaunchPermissionFr"
@AndroidEntryPoint
class FirstLaunchPermissionFragment : Fragment() {
    private lateinit var binding: FragmentFirstLaunchPermissionBinding;
    private  val loginViewModel: LoginViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel.savePreps.observe(this, Observer {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstLaunchPermissionBinding.inflate(inflater, container, false)
        binding.saveLocation.setOnClickListener {
                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
                startActivityForResult(Intent.createChooser(intent, "Choose directory"), AuthActivity.REQUESTCODE)
        }
        return binding.root
    }
    override fun onActivityResult(
        requestCode: Int, resultCode: Int, resultData: Intent?) {
        super.onActivityResult(requestCode, resultCode, resultData)
        if (requestCode == AuthActivity.REQUESTCODE
            && resultCode == Activity.RESULT_OK) {
            resultData?.data?.also { uri ->
                Log.e(TAG, "onActivityResult: $uri")
                loginViewModel.saveDir(uri.toString())
            }
        }
    }
}