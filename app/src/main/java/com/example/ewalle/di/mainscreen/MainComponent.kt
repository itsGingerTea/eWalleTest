package com.example.ewalle.di.mainscreen

import android.view.LayoutInflater
import com.example.ewalle.ui.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@MainScope
@Subcomponent
interface MainComponent {

    fun inject(activity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun bindInflater(inflater: LayoutInflater): Builder

        fun build(): MainComponent
    }
}