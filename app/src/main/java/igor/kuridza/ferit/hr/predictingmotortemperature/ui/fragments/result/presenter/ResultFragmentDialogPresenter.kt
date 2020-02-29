package igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.result.presenter

import igor.kuridza.ferit.hr.predictingmotortemperature.model.request.Motor

interface ResultFragmentDialogPresenter {

    fun onViewCreated()

    fun saveResults(predictedResult: String, actualResult: String, motor: Motor)
}