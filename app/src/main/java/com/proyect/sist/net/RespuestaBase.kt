package com.proyect.sist.net

import com.google.gson.annotations.SerializedName

/**
 * Created by Maximo Rimac on 10/10/2020.
 */
data class RespuestaBase<T> (

    @field:SerializedName("status")
    val estado: Boolean? = null,

    @field:SerializedName("data")
    val data: T? = null,

    @field:SerializedName("message")
    val mensaje: String? = null
    )


