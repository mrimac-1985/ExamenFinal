package com.proyect.sist.net

import com.google.gson.annotations.SerializedName

/**
 * Created by Maximo Rimac on 10/10/2020.
 */
data class UsuarioResponse (

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val nombre: String? = null,

    @field:SerializedName("lastName")
    val apellido: String? = null,

    @field:SerializedName("user")
    val usuario: String? = null,

    @field:SerializedName("password")
    val contrasena: String? = null,

    @field:SerializedName("email")
    val email: String? = null ,

    @field:SerializedName("address")
    val direccion: String? = null,

    @field:SerializedName("phone")
    val telefono: String? = null


)
