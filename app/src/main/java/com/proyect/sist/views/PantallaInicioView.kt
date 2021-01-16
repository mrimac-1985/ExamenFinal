package com.proyect.sist.views

import android.content.Context
import com.proyect.sist.base.BaseView

/**
 * Created by Maximo Rimac on 10/10/2020.
 */

interface PantallaInicioView: BaseView {

    fun irInicioSesion()
    fun obtenerContexto(): Context
    fun irPantallaInicio()

}