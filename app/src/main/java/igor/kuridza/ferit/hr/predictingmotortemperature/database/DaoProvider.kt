package igor.kuridza.ferit.hr.predictingmotortemperature.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import igor.kuridza.ferit.hr.predictingmotortemperature.database.dao.MotorAndValueDao
import igor.kuridza.ferit.hr.predictingmotortemperature.model.MotorAndValue

@TypeConverters(Converters::class)
@Database(entities = [MotorAndValue::class], version = 1, exportSchema = false)
abstract class DaoProvider: RoomDatabase() {

    abstract fun motorAndValueDao(): MotorAndValueDao

    companion object {
        private var instance: DaoProvider? = null

        fun getInstance(context: Context): DaoProvider{
            if(instance==null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    DaoProvider::class.java,
                    "MotorAndValueDB"
                ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance as DaoProvider
        }
    }
}