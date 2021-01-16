package com.proyect.sist.views

import android.content.Context
import com.proyect.sist.base.BaseView

/**
 * Created by Maximo Rimac on 10/10/2020.
 */
interface IniciarSesionView : BaseView {
    fun irInicio()
    fun irRegistro()
    fun obtenerUsuario(): String
    fun obtenerContrasena(): String
    fun mostrarUsuarioError(message: String)
    fun mostrarContrasenaError(message: String)
    fun mostrarUsuarioOk()
    fun mostrarError(mensaje: String)
    fun obtenerContexto(): Context
    fun irOlvideContraseña()
}