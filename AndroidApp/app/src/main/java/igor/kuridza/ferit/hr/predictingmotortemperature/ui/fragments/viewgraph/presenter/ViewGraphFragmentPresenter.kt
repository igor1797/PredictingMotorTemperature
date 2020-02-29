package igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.viewgraph.presenter

interface ViewGraphFragmentPresenter {

    fun onViewCreated()

    fun getAdapterData()

    fun getLineChartData()
}