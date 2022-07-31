package com.example.ewalle.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ewalle.di.mainscreen.MainScope
import com.example.ewalle.domain.DataInteractor
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class HomeViewModelFactory @AssistedInject constructor(
    private val interactor: DataInteractor
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == HomeViewModel::class.java)
        return HomeViewModel(interactor) as T
    }

    @AssistedFactory
    @MainScope
    interface Factory {
        fun create(): HomeViewModelFactory
    }
}