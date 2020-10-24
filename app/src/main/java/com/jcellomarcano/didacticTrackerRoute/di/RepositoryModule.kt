package com.jcellomarcano.didacticTrackerRoute.di

import com.jcellomarcano.didacticTrackerRoute.data.network.ChofersService
import com.jcellomarcano.didacticTrackerRoute.data.network.repository.ChofersRepositoryImpl
import com.jcellomarcano.didacticTrackerRoute.domain.chofers.repository.ChofersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCatFactRepository(
        chofersService: ChofersService
    ): ChofersRepository = ChofersRepositoryImpl(chofersService)
}
