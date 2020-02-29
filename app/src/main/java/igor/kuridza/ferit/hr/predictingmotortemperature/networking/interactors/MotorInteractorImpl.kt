package igor.kuridza.ferit.hr.predictingmotortemperature.networking.interactors


import igor.kuridza.ferit.hr.predictingmotortemperature.common.API_KEY_AUTH
import igor.kuridza.ferit.hr.predictingmotortemperature.common.API_VERSION
import igor.kuridza.ferit.hr.predictingmotortemperature.common.FORMAT
import igor.kuridza.ferit.hr.predictingmotortemperature.common.HEADER_CONTENT_TYPE
import igor.kuridza.ferit.hr.predictingmotortemperature.model.request.Inputs
import igor.kuridza.ferit.hr.predictingmotortemperature.model.response.AzureMLApiResponse
import igor.kuridza.ferit.hr.predictingmotortemperature.networking.MotorApiService
import retrofit2.Callback

class MotorInteractorImpl(private val motorApiService: MotorApiService): MotorInteractor {

    override fun getMotorInformations(azureMLApiCallback: Callback<AzureMLApiResponse>, inputs: Inputs) {
        motorApiService.getMotorInformation(
            API_VERSION,
            FORMAT,
            HEADER_CONTENT_TYPE,
            API_KEY_AUTH,
            inputs
        ).enqueue(azureMLApiCallback)
    }
}