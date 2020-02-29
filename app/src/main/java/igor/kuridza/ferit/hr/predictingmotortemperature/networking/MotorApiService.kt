package igor.kuridza.ferit.hr.predictingmotortemperature.networking

import igor.kuridza.ferit.hr.predictingmotortemperature.model.request.Inputs
import igor.kuridza.ferit.hr.predictingmotortemperature.model.response.AzureMLApiResponse
import retrofit2.Call
import retrofit2.http.*

interface MotorApiService {

    @POST("execute")
    fun getMotorInformation(
        @Query("api-version") apiVersion: String,
        @Query("format") format: String,
        @Header("Content-Type") headerContentType: String,
        @Header("Authorization") authorization: String,
        @Body input: Inputs
    ):Call<AzureMLApiResponse>
}