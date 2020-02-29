package igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.input.view

import igor.kuridza.ferit.hr.predictingmotortemperature.model.request.Motor

interface InputFragmentView {

    fun initUi()

    fun emptyInput()

    fun successfulPredicted(motor: Motor, predictedValue: String)

    fun onNoInternetConnection()

    fun onSomethingWentWrong(responseCode: String)
}