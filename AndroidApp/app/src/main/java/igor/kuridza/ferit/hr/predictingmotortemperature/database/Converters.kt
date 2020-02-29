package igor.kuridza.ferit.hr.predictingmotortemperature.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import igor.kuridza.ferit.hr.predictingmotortemperature.model.Value
import igor.kuridza.ferit.hr.predictingmotortemperature.model.request.Motor

class Converters {

    companion object{
        private val gson = Gson()

        @TypeConverter
        @JvmStatic
        fun fromMotor(motor: Motor): String{
            return gson.toJson(motor)
        }

        @TypeConverter
        @JvmStatic
        fun toMotor(json: String): Motor{
            return gson.fromJson(json, Motor::class.java)
        }

        @TypeConverter
        @JvmStatic
        fun fromValue(value: Value): String{
            return gson.toJson(value)
        }

        @TypeConverter
        @JvmStatic
        fun toValue(json: String): Value{
            return gson.fromJson(json, Value::class.java)
        }
    }
}