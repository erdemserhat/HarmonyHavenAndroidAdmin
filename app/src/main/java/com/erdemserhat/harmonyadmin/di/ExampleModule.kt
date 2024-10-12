package com.erdemserhat.harmonyadmin.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

class ExampleDependency(val name:String)

@Module
@InstallIn(SingletonComponent::class)
object ExampleModule {

    @Provides
    @Singleton
    fun provideExampleDependency(): ExampleDependency {
        return ExampleDependency("Example Dependency Instantiated")
    }
}