package com.shirobutton.dependency_inversion.driver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    @Inject
    lateinit var presenter: MainPresenter

    lateinit var binding: ActivityMainBinding

    var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.textView.text = number.toString()
        binding.button.setOnClickListener {
            controller.onIncrementButtonClick(number)
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                presenter.numberFlow.collect(::onReceiveNumber)
            }
        }
        setContentView(binding.root)
    }

    private fun onReceiveNumber(number: Int){
        this.number = number
        binding.textView.text = number.toString()
    }
}