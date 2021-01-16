package com.proyect.sist.views

import android.content.Context
import com.proyect.sist.base.BaseView

/**
 * Created by Maximo Rimac on 12/12/2020.
 */
interface RegistrarUsuarioView  : BaseView {


    fun obtenerContexto(): Context

    fun mostrarError(mensaje: String)

    fun irLogin();

    fun obtenerUsuario(): String
    fun obtenerNombre(): String
    fun obtenerApellido(): String
    fun obtenerDireccion(): String
    fun obtenerCorreo(): String
    fun obtenerContraseña(): String
    fun obtenerRepContraseña(): String
    fun obtenerTelefono(): String

    fun MostrarErrorUsuario(mensaje: String)
    fun MostrarErrorNombre(mensaje: String)
    fun MostrarErrorApellido(mensaje: String)
    fun MostrarErrorDireccion(mensaje: String)
    fun MostrarErrorCorreo(mensaje: String)
    fun MostrarErrorContraseña(mensaje: String)
    fun MostrarErrorRepContraseña(mensaje: String)
    fun MostrarErrorTelefono(mensaje: String)


    fun MostrarUsuarioOk()
    fun MostraNombreOK()
    fun MostrarApellidoOK()
    fun MostrarDireccionOK()
    fun MostrarCorreoOK()
    fun MostrarContraseñaOK()
    fun MostrarRepContraseñaOK()
    fun MostrarTelefonoOK()

}