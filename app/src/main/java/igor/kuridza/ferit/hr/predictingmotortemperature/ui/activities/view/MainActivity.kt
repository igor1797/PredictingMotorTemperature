package igor.kuridza.ferit.hr.predictingmotortemperature.ui.activities.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import igor.kuridza.ferit.hr.predictingmotortemperature.R
import igor.kuridza.ferit.hr.predictingmotortemperature.common.showFragment
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.activities.presenter.MainActivityPresenter
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.home.view.HomeFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), MainActivityView {

    private val presenter: MainActivityPresenter by inject { parametersOf(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onCreate()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        showHomeFragment()
    }

    override fun initUi() {
        showHomeFragment()
    }

    private fun showHomeFragment(){
        showFragment(R.id.fragmentContainer, HomeFragment.newInstance(),true)
    }
}
