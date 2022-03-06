package com.shirobutton.dependency_inversion.adapter

import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val mainReceiver: MainReceiver
): MainPresenter {
    override fun setNumber(number: Int) {
        mainReceiver.onReceiveNumber(number)
    }
}