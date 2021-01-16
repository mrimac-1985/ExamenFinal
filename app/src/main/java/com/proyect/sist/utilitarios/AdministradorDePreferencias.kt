package com.proyect.sist.utilitarios

import android.content.Context

/**
 * Created by Maximo Rimac on 10/10/2020.
 */
class AdministradorDePreferencias {
    companion object {
        const val SHARED_PREFERENCE_NAME = "mitocine"
        const val KEY_USUARIO = "usuario"
        const val KEY_TELEFONO = "telefono"
        const val KEY_DIRECCION = "direccion"
        const val KEY_FOTO = "foto"
        const val KEY_CORREO= "correo"

        fun agregarUsuario(context: Context, usuario: String) {
            val editor = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit()
            editor.putString(KEY_USUARIO, usuario)
            editor.apply()
        }

        fun agregarTelefono(context: Context, telefono: String) {
            val editor = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit()
            editor.putString(KEY_TELEFONO, telefono)
            editor.apply()
        }

        fun agregarDireccion(context: Context, direccion: String) {
            val editor = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit()
            editor.putString(KEY_DIRECCION, direccion)
            editor.apply()
        }

        fun agregarFoto(context: Context, foto: String) {
            val editor = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit()
            editor.putString(KEY_FOTO, foto)
            editor.apply()
        }

        fun agregarCorreo(context: Context, correo: String) {
            val editor = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit()
            editor.putString(KEY_CORREO, correo)
            editor.apply()
        }


        fun obtenerFoto(context: Context): String? {
            val preference = context.getSharedPreferences(SHARED_PREFERENCE_NAME,
                Context.MODE_PRIVATE
            )
            if (preference.contains(KEY_FOTO)) {
                return preference.getString(KEY_FOTO, "")
            }
            return ""
        }

        fun obtenerUsuario(context: Context): String? {
            val preference = context.getSharedPreferences(SHARED_PREFERENCE_NAME,
                Context.MODE_PRIVATE
            )
            if (preference.contains(KEY_USUARIO)) {
                return preference.getString(KEY_USUARIO, "")
            }
            return ""
        }


        fun obtenerCorreo(context: Context): String? {
            val preference = context.getSharedPreferences(SHARED_PREFERENCE_NAME,
                Context.MODE_PRIVATE
            )
            if (preference.contains(KEY_CORREO)) {
                return preference.getString(KEY_CORREO, "")
            }
            return ""
        }
        fun obtenerTelefono(context: Context): String? {
            val preference = context.getSharedPreferences(SHARED_PREFERENCE_NAME,
                Context.MODE_PRIVATE
            )
            if (preference.contains(KEY_TELEFONO)) {
                return preference.getString(KEY_TELEFONO, "")
            }
            return ""
        }

        fun obtenerDireccion(context: Context): String? {
            val preference = context.getSharedPreferences(SHARED_PREFERENCE_NAME,
                Context.MODE_PRIVATE
            )
            if (preference.contains(KEY_DIRECCION)) {
                return preference.getString(KEY_DIRECCION, "")
            }
            return ""
        }

        fun eliminarSesion(context: Context) {
            val editor = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit()
            editor.clear()
            editor.apply()
        }

    }

}