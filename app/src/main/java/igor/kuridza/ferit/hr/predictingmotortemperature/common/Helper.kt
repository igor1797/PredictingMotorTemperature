package igor.kuridza.ferit.hr.predictingmotortemperature.common

import igor.kuridza.ferit.hr.predictingmotortemperature.model.MotorAndValue
import igor.kuridza.ferit.hr.predictingmotortemperature.model.Value
import igor.kuridza.ferit.hr.predictingmotortemperature.model.request.Input1
import igor.kuridza.ferit.hr.predictingmotortemperature.model.request.Inputs
import igor.kuridza.ferit.hr.predictingmotortemperature.model.request.Motor

fun toMotorAndValue(predicted: String, actual: String, motor: Motor): MotorAndValue{
    val value = Value(
        predicted = predicted.toDouble(),
        actual = actual.toDouble()
    )
    return MotorAndValue(
        motor = motor,
        value = value
    )
}

fun toRequestModel(motor: Motor): Inputs{
    val input1 =
        Input1(listOf(motor))
    return Inputs(
        input1,
        Object()
    )
}

fun toMotor(
    ambient: String, coolant: String, uD: String, uQ: String,
    motorSpeed: String, iD: String, iQ: String, pm: String,
    statorYoke: String, statorTooth: String
): Motor {
    return Motor(
        ambient = ambient,
        coolant = coolant,
        u_d = uD,
        u_q = uQ,
        motor_speed = motorSpeed,
        i_d = iD,
        i_q = iQ,
        pm = pm,
        stator_yoke = statorYoke,
        stator_tooth = statorTooth
    )
}