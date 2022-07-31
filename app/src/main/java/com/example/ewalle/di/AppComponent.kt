package com.example.ewalle.di

import android.content.Context
import com.example.ewalle.di.homescreen.HomeComponent
import com.example.ewalle.di.mainscreen.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun mainComponentBuilder(): MainComponent.Builder
    fun homeComponentBuilder(): HomeComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindsApplication(context: Context): Builder

        fun build(): AppComponent
    }
}