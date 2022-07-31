package com.example.ewalle.di.homescreen

import android.view.LayoutInflater
import com.example.ewalle.ui.home.HomeFragment
import dagger.BindsInstance
import dagger.Subcomponent

@HomeScope
@Subcomponent
interface HomeComponent {

    fun inject(fragment: HomeFragment)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun bindsInflater(inflater: LayoutInflater): Builder

        fun build(): HomeComponent
    }
}