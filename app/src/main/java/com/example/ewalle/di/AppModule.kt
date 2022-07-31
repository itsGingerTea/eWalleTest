package com.example.ewalle.di

import android.content.Context
import com.example.ewalle.data.DataRepository
import com.example.ewalle.data.SimpleDataSource
import com.example.ewalle.domain.DataInteractor
import com.example.ewalle.domain.DataRepoImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideSimpleDataSource(): SimpleDataSource {
        return SimpleDataSource()
    }

    @Singleton
    @Provides
    fun provideDataRepository(dataSource: SimpleDataSource): DataRepository {
        return DataRepoImpl(dataSource)
    }

    @Singleton
    @Provides
    fun provideInteractor(dataRepoImpl: DataRepository): DataInteractor {
        return DataInteractor(dataRepoImpl)
    }
}