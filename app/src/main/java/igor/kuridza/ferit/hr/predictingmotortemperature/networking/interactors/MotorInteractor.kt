package igor.kuridza.ferit.hr.predictingmotortemperature.networking.interactors

import igor.kuridza.ferit.hr.predictingmotortemperature.model.request.Inputs
import igor.kuridza.ferit.hr.predictingmotortemperature.model.response.AzureMLApiResponse
import retrofit2.Callback

interface MotorInteractor {

    fun getMotorInformations(
        azureMLApiCallback: Callback<AzureMLApiResponse>,
        inputs: Inputs
    )
}