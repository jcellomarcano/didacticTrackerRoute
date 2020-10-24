package com.jcellomarcano.didacticTrackerRoute.di

import com.jcellomarcano.didacticTrackerRoute.data.network.ChofersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideCatFactsApi(): ChofersService {
        return Retrofit.Builder()
            .baseUrl("https://cat-fact.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChofersService::class.java)
    }

    companion object {
        const val BASE_URL = "https://cat-fact.herokuapp.com"
    }
}
