package igor.kuridza.ferit.hr.predictingmotortemperature.persistance

import igor.kuridza.ferit.hr.predictingmotortemperature.model.MotorAndValue

interface MotorAndValueRepository {

    fun addMotorAndValue(motorAndValue: MotorAndValue)

    fun getAllMotorsAndValues(): List<MotorAndValue>
}