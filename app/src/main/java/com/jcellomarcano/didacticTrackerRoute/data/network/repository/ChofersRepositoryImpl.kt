package com.jcellomarcano.didacticTrackerRoute.data.network.repository

import com.jcellomarcano.didacticTrackerRoute.data.network.ChofersService
import com.jcellomarcano.didacticTrackerRoute.domain.chofers.model.CatFactStates
import com.jcellomarcano.didacticTrackerRoute.domain.chofers.repository.ChofersRepository
import java.io.IOException


class ChofersRepositoryImpl(
    private val chofersService: ChofersService
): ChofersRepository {
    override suspend fun getAllChofers(): CatFactStates {
        return try {
            val response = chofersService.getAllChofers()
            val fact = response.body()
            return if (fact != null) CatFactStates.CatFactData(fact) else CatFactStates.Error(IOException("Data is null"))
        } catch (exception: Exception) {
            CatFactStates.Error(exception)
        }
    }
}
