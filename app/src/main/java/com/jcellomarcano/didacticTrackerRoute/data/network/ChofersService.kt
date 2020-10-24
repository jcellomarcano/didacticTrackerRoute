package com.jcellomarcano.didacticTrackerRoute.data.network

import com.jcellomarcano.didacticTrackerRoute.domain.chofers.model.Fact
import retrofit2.Response
import retrofit2.http.GET


interface ChofersService {
    @GET("/chofer/all")
    suspend fun getAllChofers(): Response<Fact>
}
