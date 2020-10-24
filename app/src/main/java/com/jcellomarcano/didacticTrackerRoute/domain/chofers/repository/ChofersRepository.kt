package com.jcellomarcano.didacticTrackerRoute.domain.chofers.repository

import com.jcellomarcano.didacticTrackerRoute.domain.chofers.model.CatFactStates


interface ChofersRepository {
    suspend fun getAllChofers(): CatFactStates
}
