package igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.result.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import igor.kuridza.ferit.hr.predictingmotortemperature.R
import igor.kuridza.ferit.hr.predictingmotortemperature.common.KEY_MOTOR
import igor.kuridza.ferit.hr.predictingmotortemperature.common.KEY_PREDICTED_VALUE
import igor.kuridza.ferit.hr.predictingmotortemperature.common.onClick
import igor.kuridza.ferit.hr.predictingmotortemperature.common.showToast
import igor.kuridza.ferit.hr.predictingmotortemperature.model.request.Motor
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.result.SaveListener
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.result.presenter.ResultFragmentDialogPresenter
import kotlinx.android.synthetic.main.fragment_result_fragment_dialog.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class ResultFragmentDialog : DialogFragment(), ResultFragmentDialogView{

    private val presenter: ResultFragmentDialogPresenter by inject { parametersOf(this)}
    private var saveListener: SaveListener? = null
    private lateinit var motor: Motor
    private lateinit var predictedValue: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result_fragment_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun initUi() {
        motor = arguments?.getParcelable(KEY_MOTOR)!!
        predictedValue = arguments?.getString(KEY_PREDICTED_VALUE)!!
        tvStatorWindingTemperature.text = predictedValue
        setSaveResultOnClickListener()
        setCancelOnClickListener()
    }

    override fun cantSaveResults() {
        context?.showToast("Predicted result or actual result can't be empty")
    }

    private fun setSaveResultOnClickListener(){
        tvSave.onClick {
            val actualResult = etActualResult.text.toString()
            presenter.saveResults(predictedValue, actualResult, motor)
            saveListener?.onSaveClicked()
            dismiss()
        }
    }

    private fun setCancelOnClickListener(){
        tvCancel.onClick {
            dismiss()
        }
    }

    fun setSaveListener(saveListener: SaveListener){
        this.saveListener = saveListener
    }

    companion object{
        fun newInstance(motor: Motor, predictedValue: String): ResultFragmentDialog{
            val bundle = Bundle().apply {
                putParcelable(KEY_MOTOR, motor)
                putString(KEY_PREDICTED_VALUE, predictedValue)
            }
            return ResultFragmentDialog().apply { arguments = bundle }
        }
    }
}
