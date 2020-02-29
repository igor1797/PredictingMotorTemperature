package igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.input.presenter

import igor.kuridza.ferit.hr.predictingmotortemperature.common.toMotor
import igor.kuridza.ferit.hr.predictingmotortemperature.common.toRequestModel
import igor.kuridza.ferit.hr.predictingmotortemperature.model.request.Motor
import igor.kuridza.ferit.hr.predictingmotortemperature.model.response.AzureMLApiResponse
import igor.kuridza.ferit.hr.predictingmotortemperature.networking.interactors.MotorInteractor
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.input.view.InputFragmentView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputFragmentPresenterImpl(
    private val view: InputFragmentView,
    private val motorInteractor: MotorInteractor
): InputFragmentPresenter {

    override fun onViewCreated() {
        view.initUi()
    }

    override fun checkParameters(
        ambient: String,
        coolant: String,
        uD: String,
        uQ: String,
        motorSpeed: String,
        iD: String,
        iQ: String,
        pm: String,
        statorYoke: String,
        statorTooth: String
    ) {
        if(
            ambient.isEmpty() || coolant.isEmpty() || uD.isEmpty()
            || uQ.isEmpty() || motorSpeed.isEmpty() || iD.isEmpty()
            || iQ.isEmpty() || pm.isEmpty() || statorYoke.isEmpty()
            || statorTooth.isEmpty()
        ) view.emptyInput()
        else{
            val motor = toMotor(
                ambient, coolant, uD, uQ, motorSpeed, iD, iQ, pm, statorYoke, statorTooth
            )
            val requestModel = toRequestModel(
                motor
            )
            motorInteractor.getMotorInformations(getMotorInformation(motor), requestModel)
        }
    }

    private fun getMotorInformation(motor: Motor): Callback<AzureMLApiResponse> = object :
        Callback<AzureMLApiResponse> {
        override fun onFailure(call: Call<AzureMLApiResponse>, t: Throwable) {
            handleNoInternetConnection()
        }
        override fun onResponse(call: Call<AzureMLApiResponse>, response: Response<AzureMLApiResponse>) {
            if (response.isSuccessful) {
                when (response.code()) {
                    200 -> response.body()?.let {
                        handleSuccessfulResponse(motor, it.response.output.first().stator_winding.toString())
                    }
                }
            } else
                handleSomethingWentWrong(response.code().toString())
        }
    }

    private fun handleNoInternetConnection(){
        view.onNoInternetConnection()
    }

    private fun handleSuccessfulResponse(motor: Motor, predictedValue: String){
        view.successfulPredicted(motor , predictedValue)
    }

    private fun handleSomethingWentWrong(responseCode: String){
        view.onSomethingWentWrong(responseCode)
    }
}