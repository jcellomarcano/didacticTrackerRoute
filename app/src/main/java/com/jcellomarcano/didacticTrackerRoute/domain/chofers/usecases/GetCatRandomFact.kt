package com.jcellomarcano.didacticTrackerRoute.domain.chofers.usecases

import com.jcellomarcano.didacticTrackerRoute.domain.chofers.model.CatFactStates


interface GetCatRandomFact {
    suspend operator fun invoke(): CatFactStates
}
