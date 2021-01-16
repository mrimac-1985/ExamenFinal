package com.proyect.sist.net

import com.google.gson.annotations.SerializedName
import java.text.DecimalFormat

/**
 * Created by Maximo Rimac on 06/01/2021.
 */
data class ProductoResponse (


    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("price")
    val price: Double? = null,

    @field:SerializedName("urlImage")
    val urlImage: String? = null,

    @field:SerializedName("status")
    val status: Boolean? = null
)