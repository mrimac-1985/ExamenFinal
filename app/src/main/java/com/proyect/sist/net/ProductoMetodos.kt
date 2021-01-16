package com.proyect.sist.net

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Maximo Rimac on 06/01/2021.
 */
interface ProductoMetodos {


    @GET(ApiConstant.REGISTRAR_PRODUCTO)
    fun obtenerProductos(): Call<RespuestaBase<List<ProductoResponse>?>>
}