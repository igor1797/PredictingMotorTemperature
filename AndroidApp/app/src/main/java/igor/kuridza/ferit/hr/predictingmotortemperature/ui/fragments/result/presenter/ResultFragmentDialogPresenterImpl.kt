package igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.result.presenter

import igor.kuridza.ferit.hr.predictingmotortemperature.common.toMotorAndValue
import igor.kuridza.ferit.hr.predictingmotortemperature.model.request.Motor
import igor.kuridza.ferit.hr.predictingmotortemperature.persistance.MotorAndValueRepository
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.result.view.ResultFragmentDialogView

class ResultFragmentDialogPresenterImpl(
    private val view: ResultFragmentDialogView,
    private val motorAndValueRepository: MotorAndValueRepository
): ResultFragmentDialogPresenter {

    override fun onViewCreated() {
        view.initUi()
    }

    override fun saveResults(predictedResult: String, actualResult: String, motor: Motor) {
        if(predictedResult.isEmpty() || actualResult.isEmpty())
            view.cantSaveResults()
        else
            saveResultsToRoom(predictedResult, actualResult, motor)
    }

    private fun saveResultsToRoom(predictedResult: String, actualResult: String, motor: Motor){
        val motorAndValue = toMotorAndValue(predictedResult,actualResult,motor)
        motorAndValueRepository.addMotorAndValue(motorAndValue)
    }
}