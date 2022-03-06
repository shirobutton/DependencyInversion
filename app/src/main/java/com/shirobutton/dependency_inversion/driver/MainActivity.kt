package com.shirobutton.dependency_inversion.driver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shirobutton.dependency_inversion.adapter.MainController
import com.shirobutton.dependency_inversion.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var controller: MainController

    private var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.textView.text = number.toString()
        binding.button.setOnClickListener {
            number = controller.onIncrementButtonClick(number)
            binding.textView.text = number.toString()
        }
        setContentView(binding.root)
    }
}