package igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.home.presenter

import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.home.view.HomeFragmentView


class HomeFragmentPresenterImpl(private val view: HomeFragmentView): HomeFragmentPresenter {

    override fun onViewCreated() {
        view.initUi()
    }

}