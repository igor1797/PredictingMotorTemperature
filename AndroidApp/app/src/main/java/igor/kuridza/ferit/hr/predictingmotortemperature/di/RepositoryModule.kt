package igor.kuridza.ferit.hr.predictingmotortemperature.di

import igor.kuridza.ferit.hr.predictingmotortemperature.persistance.MotorAndValueRepository
import igor.kuridza.ferit.hr.predictingmotortemperature.persistance.MotorAndValueRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory<MotorAndValueRepository> {MotorAndValueRepositoryImpl()}
}