package igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.input.view


import android.os.Bundle
import android.view.View
import igor.kuridza.ferit.hr.predictingmotortemperature.R
import igor.kuridza.ferit.hr.predictingmotortemperature.common.onClick
import igor.kuridza.ferit.hr.predictingmotortemperature.common.showToast
import igor.kuridza.ferit.hr.predictingmotortemperature.model.request.Motor
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.base.BaseFragment
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.input.presenter.InputFragmentPresenter
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.result.SaveListener
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.result.view.ResultFragmentDialog
import kotlinx.android.synthetic.main.fragment_input.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class InputFragment : BaseFragment(), InputFragmentView, SaveListener{

    private val presenter: InputFragmentPresenter by inject { parametersOf(this)}

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_input
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun initUi() {
        setBtnPredictStatorWindingTempOnClickListener()
    }

    private fun setBtnPredictStatorWindingTempOnClickListener() {
        btnPredictStatorWinding.onClick {
            val ambient = etAmbient.text.toString()
            val coolant = etCoolant.text.toString()
            val uD = etU_d.text.toString()
            val uQ = etU_q.text.toString()
            val motorSpeed = etMotorSpeed.text.toString()
            val iD = etI_d.text.toString()
            val iQ = etI_q.text.toString()
            val pm = etPm.text.toString()
            val statorYoke = etStatorYoke.text.toString()
            val statorTooth = etStatorTooth.text.toString()

            presenter.checkParameters(
                ambient, coolant, uD,
                uQ, motorSpeed, iD,
                iQ, pm, statorYoke,
                statorTooth
            )
        }
    }

    override fun emptyInput() {
        context?.showToast("Inputs can't be empty")
    }

    override fun successfulPredicted(motor: Motor, predictedValue: String) {
        showResultDialog(motor, predictedValue)
    }

    override fun onSaveClicked() {
        etAmbient.text.clear()
        etCoolant.text.clear()
        etU_d.text.clear()
        etU_q.text.clear()
        etMotorSpeed.text.clear()
        etI_d.text.clear()
        etI_q.text.clear()
        etPm.text.clear()
        etStatorYoke.text.clear()
        etStatorTooth.text.clear()
    }

    override fun onNoInternetConnection() {
        context?.showToast("Check internet connection")
    }

    override fun onSomethingWentWrong(responseCode: String) {
        context?.showToast("Something went wrong, response code: $responseCode")
    }

    private fun showResultDialog(motor: Motor, predictedValue: String) {
        val fragmentManager = fragmentManager
        val resultFragmentDialog = ResultFragmentDialog.newInstance(motor, predictedValue)
        resultFragmentDialog.setSaveListener(this)
        resultFragmentDialog.show(fragmentManager!!, "")
    }

    companion object{
        fun newInstance(): BaseFragment = InputFragment()
    }
}
