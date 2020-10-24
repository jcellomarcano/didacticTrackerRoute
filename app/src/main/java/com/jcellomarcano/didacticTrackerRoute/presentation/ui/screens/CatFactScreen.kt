package com.jcellomarcano.didacticTrackerRoute.presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import com.jcellomarcano.didacticTrackerRoute.domain.chofers.model.CatFactStates
import com.jcellomarcano.didacticTrackerRoute.presentation.ui.composables.CatFactCard
import com.jcellomarcano.didacticTrackerRoute.presentation.ui.composables.CatFactText


@Composable
fun CatFactScreen(
    catFact: LiveData<CatFactStates>,
    onClick: () -> Unit
) {
    val catFact: CatFactStates by catFact.observeAsState(initial = CatFactStates.Loading)

    when (catFact) {
        is CatFactStates.Loading -> CatFactCard(text = "Click to Get a Cat Fact!", onClick = onClick)
        is CatFactStates.CatFactData -> CatFactCard(text = (catFact as CatFactStates.CatFactData).fact.text, onClick = onClick)
        else -> CatFactText(text = "Nothing to show")
    }
}
