package igor.kuridza.ferit.hr.predictingmotortemperature.persistance

import igor.kuridza.ferit.hr.predictingmotortemperature.App
import igor.kuridza.ferit.hr.predictingmotortemperature.database.DaoProvider
import igor.kuridza.ferit.hr.predictingmotortemperature.database.dao.MotorAndValueDao
import igor.kuridza.ferit.hr.predictingmotortemperature.model.MotorAndValue

class MotorAndValueRepositoryImpl: MotorAndValueRepository {

    private val database: DaoProvider = DaoProvider.getInstance(App.getAppContext())

    private val motorAndValueDao: MotorAndValueDao = database.motorAndValueDao()

    override fun addMotorAndValue(motorAndValue: MotorAndValue) {
        motorAndValueDao.addMotorAndValue(motorAndValue)
    }

    override fun getAllMotorsAndValues(): List<MotorAndValue> {
        return motorAndValueDao.getAllMotorsAndValues()
    }
}