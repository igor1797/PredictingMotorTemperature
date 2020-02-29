package igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.viewgraph.presenter

import android.graphics.Color
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import igor.kuridza.ferit.hr.predictingmotortemperature.persistance.MotorAndValueRepository
import igor.kuridza.ferit.hr.predictingmotortemperature.persistance.MotorAndValueRepositoryImpl
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.viewgraph.view.ViewGraphFragmentView

class ViewGraphFragmentPresenterImpl(
    private val view: ViewGraphFragmentView,
    private val repository: MotorAndValueRepository = MotorAndValueRepositoryImpl()
): ViewGraphFragmentPresenter {

    override fun onViewCreated() {
        view.initUi()
    }

    override fun getAdapterData() {
        view.setAdapterData(repository.getAllMotorsAndValues())
    }

    override fun getLineChartData() {
        val motorsAndValues = repository.getAllMotorsAndValues()

        val dataValues1 = ArrayList<Entry>()
        for ((br, motorAndValue) in motorsAndValues.withIndex()){
            val entry = Entry(br.toFloat(), motorAndValue.value.predicted.toFloat())
            dataValues1.add(entry)
        }

        val lineDataSet1 = LineDataSet(dataValues1, "Predicted values")
        lineDataSet1.color = Color.RED
        lineDataSet1.valueTextSize = 10F

        val dataValues2 = ArrayList<Entry>()
        for ((br, motorAndValue) in motorsAndValues.withIndex()){
            val entry = Entry(br.toFloat(), motorAndValue.value.actual.toFloat())
            dataValues2.add(entry)
        }

        val lineDataSet2 = LineDataSet(dataValues2, "Actual values")
        lineDataSet2.color = Color.GREEN
        lineDataSet2.valueTextSize = 10F

        val dataSet = arrayListOf<ILineDataSet>(lineDataSet1,lineDataSet2)
        val data = LineData(dataSet)
        view.setLineChart(data)
    }
}