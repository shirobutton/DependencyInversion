package com.shirobutton.dependency_inversion.driver

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shirobutton.dependency_inversion.adapter.MainPresenter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(presenter: MainPresenter): ViewModel() {
    val numberFlow = presenter.numberFlow.stateIn(viewModelScope, SharingStarted.Lazily, 0)
    val number get() = numberFlow.value
}