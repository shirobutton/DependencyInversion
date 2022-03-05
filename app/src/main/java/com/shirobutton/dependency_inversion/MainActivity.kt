package com.shirobutton.dependency_inversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shirobutton.dependency_inversion.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.textView.text = number.toString()
        binding.button.setOnClickListener {
            // TODO
        }
        setContentView(binding.root)
    }
}