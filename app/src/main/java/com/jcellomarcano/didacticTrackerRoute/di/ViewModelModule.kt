package com.jcellomarcano.didacticTrackerRoute.di

import com.jcellomarcano.didacticTrackerRoute.domain.chofers.usecases.GetCatRandomFact
import com.jcellomarcano.didacticTrackerRoute.presentation.main.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@Module
@InstallIn(ActivityRetainedComponent::class)
class ViewModelModule {

    @Provides
    fun provideMainViewModel(
        getCatRandomFact: GetCatRandomFact
    ): MainViewModel = MainViewModel(getCatRandomFact)
}
