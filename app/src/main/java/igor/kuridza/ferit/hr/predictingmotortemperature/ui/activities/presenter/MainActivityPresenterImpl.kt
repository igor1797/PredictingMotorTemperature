package igor.kuridza.ferit.hr.predictingmotortemperature.ui.activities.presenter

import igor.kuridza.ferit.hr.predictingmotortemperature.ui.activities.view.MainActivityView

class MainActivityPresenterImpl(private val view: MainActivityView): MainActivityPresenter {

    override fun onCreate() {
        view.initUi()
    }

}