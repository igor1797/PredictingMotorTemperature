package igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.home.view

import android.os.Bundle
import android.view.View
import igor.kuridza.ferit.hr.predictingmotortemperature.R
import igor.kuridza.ferit.hr.predictingmotortemperature.common.onClick
import igor.kuridza.ferit.hr.predictingmotortemperature.common.replaceFragment
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.base.BaseFragment
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.home.presenter.HomeFragmentPresenter
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.input.view.InputFragment
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.viewgraph.view.ViewGraphFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class HomeFragment : BaseFragment(), HomeFragmentView{

    private val presenter: HomeFragmentPresenter by inject {parametersOf(this)}
    private val containerId: Int = R.id.fragmentContainer

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_home
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun initUi() {
        setBtnShowInputFragmentOnClickListener()
        setBtnShowViewGraphFragmentOnClickListener()
    }

    private fun setBtnShowInputFragmentOnClickListener(){
        btnShowInputFragment.onClick {
            replaceFragment(containerId, fragmentManager!!, InputFragment.newInstance())
        }
    }

    private fun setBtnShowViewGraphFragmentOnClickListener(){
        btnShowViewGraphFragment.onClick {
            replaceFragment(containerId, fragmentManager!! , ViewGraphFragment.newInstance())
        }
    }

    companion object{
        fun newInstance(): BaseFragment = HomeFragment()
    }
}
