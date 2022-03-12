package com.shirobutton.dependency_inversion.application

import kotlinx.coroutines.flow.Flow

interface NumberSubject {
    val flow: Flow<Int>
}