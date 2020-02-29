package igor.kuridza.ferit.hr.predictingmotortemperature.model.request

import com.google.gson.annotations.SerializedName

data class Input1 (
    @SerializedName("Input1")
    val motors: List<Motor>
)