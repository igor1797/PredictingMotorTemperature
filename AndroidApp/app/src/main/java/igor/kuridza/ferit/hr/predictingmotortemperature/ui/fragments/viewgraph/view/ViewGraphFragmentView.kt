package igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.viewgraph.view

import com.github.mikephil.charting.data.LineData
import igor.kuridza.ferit.hr.predictingmotortemperature.model.MotorAndValue

interface ViewGraphFragmentView {

    fun initUi()

    fun setAdapterData(data: List<MotorAndValue>)

    fun setLineChart(data: LineData)
}