package igor.kuridza.ferit.hr.predictingmotortemperature

import android.app.Application
import android.content.Context
import igor.kuridza.ferit.hr.predictingmotortemperature.di.interactorModule
import igor.kuridza.ferit.hr.predictingmotortemperature.di.networkingModule
import igor.kuridza.ferit.hr.predictingmotortemperature.di.presentationModule
import igor.kuridza.ferit.hr.predictingmotortemperature.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application(){

    companion object {
        lateinit var instance: App
            private set

        fun getAppContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidContext(this@App)
            modules(listOf(presentationModule, repositoryModule, networkingModule, interactorModule))
        }
    }
}