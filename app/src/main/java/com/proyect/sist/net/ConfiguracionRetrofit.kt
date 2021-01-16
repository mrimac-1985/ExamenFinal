package com.proyect.sist.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Maximo Rimac on 10/10/2020.
 */
class ConfiguracionRetrofit {

    companion object {
        fun obtenerConfiguracion(): Retrofit? {
            return Retrofit.Builder()
//                .baseUrl("http://jcodee.com:8080/CineWS/")
                .baseUrl("http://jcodee.com:8080/MovieWS/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}