package com.shirobutton.dependency_inversion.adapter

import com.shirobutton.dependency_inversion.driver.MainActivity
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val mainActivity: MainActivity
): MainPresenter {
    override fun setNumber(number: Int) {
        mainActivity.onReceiveNumber(number)
    }
}