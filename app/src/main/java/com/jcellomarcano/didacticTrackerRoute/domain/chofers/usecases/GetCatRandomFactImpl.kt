package com.jcellomarcano.didacticTrackerRoute.domain.chofers.usecases

import com.jcellomarcano.didacticTrackerRoute.domain.chofers.model.CatFactStates
import com.jcellomarcano.didacticTrackerRoute.domain.chofers.repository.ChofersRepository


class GetCatRandomFactImpl(
    private val chofersRepository: ChofersRepository
): GetCatRandomFact {
    override suspend fun invoke(): CatFactStates = chofersRepository.getAllChofers()
}
