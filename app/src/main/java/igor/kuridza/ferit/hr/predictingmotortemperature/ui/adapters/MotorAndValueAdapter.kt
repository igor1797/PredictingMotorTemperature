package igor.kuridza.ferit.hr.predictingmotortemperature.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import igor.kuridza.ferit.hr.predictingmotortemperature.R
import igor.kuridza.ferit.hr.predictingmotortemperature.common.gone
import igor.kuridza.ferit.hr.predictingmotortemperature.common.onClick
import igor.kuridza.ferit.hr.predictingmotortemperature.common.visible
import igor.kuridza.ferit.hr.predictingmotortemperature.model.MotorAndValue
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.motor_and_value_item.*

class MotorAndValueAdapter: RecyclerView.Adapter<MotorAndValueAdapter.MotorAndValueHolder>(){

    private var data = mutableListOf<MotorAndValue>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotorAndValueHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.motor_and_value_item, parent, false)
        return MotorAndValueHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MotorAndValueHolder, position: Int) {
        holder.bindItem(position+1, data[position])
    }

    fun setAdapterData(data: List<MotorAndValue>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class MotorAndValueHolder(
        override val containerView: View
    ): RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindItem(point: Int ,motorAndValue: MotorAndValue){
            tvAmbient.text = "Ambient temp: " + motorAndValue.motor.ambient
            tvCoolant.text = "Coolant temp: ${motorAndValue.motor.coolant}"
            tvU_d.text = "Voltage d-component: ${motorAndValue.motor.u_d}"
            tvU_q.text = "Voltage q-component: ${motorAndValue.motor.u_q}"
            tvI_d.text = "Current d-component: ${motorAndValue.motor.i_d}"
            tvI_q.text = "Current q-component: ${motorAndValue.motor.i_q}"
            tvMotorSpeed.text = "Motor speed: ${motorAndValue.motor.motor_speed}"
            tvPm.text = "PM surface temp: ${motorAndValue.motor.pm}"
            tvStatorTooth.text = "Stator tooth temp: ${motorAndValue.motor.stator_tooth}"
            tvStatorYoke.text = "Stator yoke temp: ${motorAndValue.motor.stator_yoke}"
            tvPredicted.text = "Predicted sw temp: ${motorAndValue.value.predicted}"
            tvActual.text = "Actual sw temp: ${motorAndValue.value.actual}"
            tvPoint.text = "$point. Point"
            containerView.onClick {
                onItemClicked(motorAndValue)
            }

            if(motorAndValue.isExpanded){
                tvAmbient.visible()
                tvCoolant.visible()
                tvU_d.visible()
                tvU_q.visible()
                tvI_d.visible()
                tvI_q.visible()
                tvMotorSpeed.visible()
                tvPm.visible()
                tvStatorTooth.visible()
                tvStatorYoke.visible()
                tvPredicted.visible()
                tvActual.visible()
            }
            else{
                tvAmbient.gone()
                tvCoolant.gone()
                tvI_d.gone()
                tvI_q.gone()
                tvU_q.gone()
                tvU_d.gone()
                tvMotorSpeed.gone()
                tvPm.gone()
                tvStatorTooth.gone()
                tvStatorYoke.gone()
                tvPredicted.gone()
                tvActual.gone()
            }
        }

        private fun onItemClicked(item: MotorAndValue) {
            item.isExpanded = !item.isExpanded
            notifyItemChanged(adapterPosition)
        }
    }
}