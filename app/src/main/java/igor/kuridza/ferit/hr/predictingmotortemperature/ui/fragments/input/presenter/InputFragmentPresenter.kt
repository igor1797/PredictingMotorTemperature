package igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.input.presenter


interface InputFragmentPresenter {

    fun onViewCreated()

    fun checkParameters(
        ambient: String, coolant: String, uD: String,
        uQ: String, motorSpeed: String, iD: String,
        iQ: String, pm: String, statorYoke: String,
        statorTooth: String
    )
}