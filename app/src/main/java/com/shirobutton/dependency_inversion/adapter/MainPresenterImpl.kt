package com.shirobutton.dependency_inversion.adapter

import com.shirobutton.dependency_inversion.application.NumberSubject
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val numberSubject: NumberSubject
): MainPresenter {
    override val numberFlow get() = numberSubject.flow
}