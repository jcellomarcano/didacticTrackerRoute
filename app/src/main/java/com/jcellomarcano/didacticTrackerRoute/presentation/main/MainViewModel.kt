package com.jcellomarcano.didacticTrackerRoute.presentation.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcellomarcano.didacticTrackerRoute.domain.chofers.model.CatFactStates
import com.jcellomarcano.didacticTrackerRoute.domain.chofers.model.Fact
import com.jcellomarcano.didacticTrackerRoute.domain.chofers.usecases.GetCatRandomFact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel @ViewModelInject constructor(
    private val getCatRandomFact: GetCatRandomFact
): ViewModel() {
    private val mutableCatFact = MutableLiveData<CatFactStates>()
    val catFact: LiveData<CatFactStates>
        get() = mutableCatFact


    fun getCatFact() = viewModelScope.launch {
        val catFactStates = getCatRandomFact()
        withContext(Dispatchers.IO) {
            when (catFactStates) {
                is CatFactStates.Loading -> notifyLoadingState()
                is CatFactStates.CatFactData -> notifyCatFactState(catFactStates.fact)
                is CatFactStates.Error -> notifyErrorState(catFactStates.error)
            }
        }
    }

    private fun notifyLoadingState() {
        mutableCatFact.postValue(CatFactStates.Loading)
    }

    private fun notifyCatFactState(fact: Fact) {
        mutableCatFact.postValue(CatFactStates.CatFactData(fact))
    }

    private fun notifyErrorState(error: Throwable) {
        mutableCatFact.postValue(CatFactStates.Error(error))
    }

}
