package igor.kuridza.ferit.hr.predictingmotortemperature.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Value(
    @PrimaryKey(autoGenerate = true)
    val valueId: Long? = null,
    val predicted: Double,
    val actual: Double
)