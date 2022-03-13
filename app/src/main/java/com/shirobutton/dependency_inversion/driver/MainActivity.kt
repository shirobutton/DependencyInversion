package com.shirobutton.dependency_inversion.driver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.shirobutton.dependency_inversion.adapter.MainController
import com.shirobutton.dependency_inversion.adapter.MainPresenter
import com.shirobutton.dependency_inversion.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var controller: MainController

    private val viewModel: MainViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.textView.text = viewModel.number.toString()
        binding.button.setOnClickListener {
            controller.onIncrementButtonClick(viewModel.number)
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.numberFlow.collect(::onReceiveNumber)
            }
        }
        setContentView(binding.root)
    }

    private fun onReceiveNumber(number: Int){
        binding.textView.text = number.toString()
    }
}