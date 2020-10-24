package com.jcellomarcano.didacticTrackerRoute.di

import com.jcellomarcano.didacticTrackerRoute.domain.chofers.repository.ChofersRepository
import com.jcellomarcano.didacticTrackerRoute.domain.chofers.usecases.GetCatRandomFact
import com.jcellomarcano.didacticTrackerRoute.domain.chofers.usecases.GetCatRandomFactImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@Module
@InstallIn(ActivityRetainedComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetCatRandomFact(
        chofersRepository: ChofersRepository
    ): GetCatRandomFact = GetCatRandomFactImpl(chofersRepository)
}
