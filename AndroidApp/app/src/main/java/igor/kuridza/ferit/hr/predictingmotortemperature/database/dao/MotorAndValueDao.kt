package igor.kuridza.ferit.hr.predictingmotortemperature.database.dao

import androidx.room.*
import igor.kuridza.ferit.hr.predictingmotortemperature.model.MotorAndValue

@Dao
interface MotorAndValueDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addMotorAndValue(motorAndValue: MotorAndValue)

    @Query("Select* FROM MotorAndValue")
    fun getAllMotorsAndValues(): List<MotorAndValue>
}