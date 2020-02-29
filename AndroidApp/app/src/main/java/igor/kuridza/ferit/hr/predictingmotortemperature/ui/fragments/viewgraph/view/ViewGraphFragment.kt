package igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.viewgraph.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.data.LineData
import igor.kuridza.ferit.hr.predictingmotortemperature.R
import igor.kuridza.ferit.hr.predictingmotortemperature.model.MotorAndValue
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.adapters.MotorAndValueAdapter
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.base.BaseFragment
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.viewgraph.presenter.ViewGraphFragmentPresenter
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.viewgraph.presenter.ViewGraphFragmentPresenterImpl
import kotlinx.android.synthetic.main.fragment_view_graph.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ViewGraphFragment : BaseFragment(), ViewGraphFragmentView {

    private val presenter: ViewGraphFragmentPresenter by inject { parametersOf(this)}

    private val motorAndValueAdapter by lazy {
        MotorAndValueAdapter()
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_view_graph
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun initUi() {
        recyclerView.apply {
            adapter = motorAndValueAdapter
            layoutManager = LinearLayoutManager(context)
        }

        presenter.apply {
            getAdapterData()
            getLineChartData()
        }

    }

    override fun setLineChart(data: LineData) {
        lineChart.data = data
        lineChart.invalidate()
    }

    override fun setAdapterData(data: List<MotorAndValue>) {
        motorAndValueAdapter.setAdapterData(data)
    }

    companion object{
        fun newInstance(): BaseFragment = ViewGraphFragment()
    }
}
