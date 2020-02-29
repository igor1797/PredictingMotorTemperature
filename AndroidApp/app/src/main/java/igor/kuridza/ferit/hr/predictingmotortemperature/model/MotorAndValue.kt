package igor.kuridza.ferit.hr.predictingmotortemperature.model

import androidx.room.*
import igor.kuridza.ferit.hr.predictingmotortemperature.model.request.Motor

@Entity
data class MotorAndValue(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val motor: Motor,
    val value: Value
){
    var isExpanded: Boolean = false
}