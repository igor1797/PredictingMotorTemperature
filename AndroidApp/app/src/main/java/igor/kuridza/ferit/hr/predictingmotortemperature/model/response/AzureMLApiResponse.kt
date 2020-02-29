package igor.kuridza.ferit.hr.predictingmotortemperature.model.response

import com.google.gson.annotations.SerializedName

data class AzureMLApiResponse (
    @SerializedName("Results")
    val response: Output
)