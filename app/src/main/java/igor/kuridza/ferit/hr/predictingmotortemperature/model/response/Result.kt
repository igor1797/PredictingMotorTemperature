package igor.kuridza.ferit.hr.predictingmotortemperature.model.response

import com.google.gson.annotations.SerializedName

data class Result (
    @SerializedName("Scored Labels")
    val stator_winding: Double
)