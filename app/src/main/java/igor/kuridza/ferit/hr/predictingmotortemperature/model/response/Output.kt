package igor.kuridza.ferit.hr.predictingmotortemperature.model.response

import com.google.gson.annotations.SerializedName

data class Output (
    @SerializedName("output1")
    val output: List<Result>
)
