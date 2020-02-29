package igor.kuridza.ferit.hr.predictingmotortemperature.di


import igor.kuridza.ferit.hr.predictingmotortemperature.common.BASE_URL
import igor.kuridza.ferit.hr.predictingmotortemperature.networking.MotorApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkingModule = module {

    single {
        GsonConverterFactory.create() as Converter.Factory
    }

    single {
        OkHttpClient.Builder().build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(get())
            .build()
    }

    single {
        get<Retrofit>().create(MotorApiService::class.java)
    }
}

