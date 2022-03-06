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

    lateinit var binding: ActivityMainBinding

    var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.textView.text = number.toString()
        binding.button.setOnClickListener {
            controller.onIncrementButtonClick(number)
        }
        setContentView(binding.root)
    }

    fun onReceiveNumber(number: Int){
        this.number = number
        binding.textView.text = number.toString()
    }
}