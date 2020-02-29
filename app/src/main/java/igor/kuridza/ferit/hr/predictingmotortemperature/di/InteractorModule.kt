package igor.kuridza.ferit.hr.predictingmotortemperature.di

import igor.kuridza.ferit.hr.predictingmotortemperature.networking.interactors.MotorInteractor
import igor.kuridza.ferit.hr.predictingmotortemperature.networking.interactors.MotorInteractorImpl
import org.koin.dsl.module

val interactorModule = module {

    factory<MotorInteractor> { MotorInteractorImpl(get()) }
}