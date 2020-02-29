package igor.kuridza.ferit.hr.predictingmotortemperature.model.request

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity
data class Motor (
    @PrimaryKey(autoGenerate = true)
    val motorId: Long? = null,
    val ambient: String,
    val coolant: String,
    val u_d: String,
    val u_q: String,
    val motor_speed: String,
    val i_d: String,
    val i_q: String,
    val pm: String,
    val stator_yoke: String,
    val stator_tooth: String,
    val stator_winding: String = "0"
): Parcelable