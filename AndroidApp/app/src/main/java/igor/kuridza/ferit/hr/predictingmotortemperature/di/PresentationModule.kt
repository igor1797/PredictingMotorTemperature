package igor.kuridza.ferit.hr.predictingmotortemperature.di

import igor.kuridza.ferit.hr.predictingmotortemperature.ui.activities.presenter.MainActivityPresenter
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.activities.presenter.MainActivityPresenterImpl
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.activities.view.MainActivityView
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.home.presenter.HomeFragmentPresenter
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.home.presenter.HomeFragmentPresenterImpl
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.home.view.HomeFragmentView
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.input.presenter.InputFragmentPresenter
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.input.presenter.InputFragmentPresenterImpl
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.input.view.InputFragmentView
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.result.presenter.ResultFragmentDialogPresenter
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.result.presenter.ResultFragmentDialogPresenterImpl
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.result.view.ResultFragmentDialogView
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.viewgraph.presenter.ViewGraphFragmentPresenter
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.viewgraph.presenter.ViewGraphFragmentPresenterImpl
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.viewgraph.view.ViewGraphFragmentView
import org.koin.dsl.module

val presentationModule = module {
    factory<MainActivityPresenter> { (view: MainActivityView) ->
        MainActivityPresenterImpl(view)
    }

    factory<HomeFragmentPresenter> { (view: HomeFragmentView) ->
        HomeFragmentPresenterImpl(view)
    }

    factory<InputFragmentPresenter> { (view: InputFragmentView) ->
        InputFragmentPresenterImpl(view, get())
    }

    factory<ResultFragmentDialogPresenter> { (view: ResultFragmentDialogView) ->
        ResultFragmentDialogPresenterImpl(view, get())
    }

    factory<ViewGraphFragmentPresenter> { (view: ViewGraphFragmentView) ->
        ViewGraphFragmentPresenterImpl(view, get())
    }
}