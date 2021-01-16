package com.proyect.sist.net

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Maximo Rimac on 10/10/2020.
 */
interface UsuarioMetodos {

    @POST(ApiConstant.REGISTRAR_USUARIO)
    @FormUrlEncoded
    fun registrarUsuario(
        @Field("name") nombre: String?,
        @Field("last_name") apellido: String?,
        @Field("username") usuario: String?,
        @Field("password") contrasena: String?,
        @Field("email") email: String?,
        @Field("address") direccion: String?,
        @Field("phone") telefono: String?
    ): Call<RespuestaBase<UsuarioResponse>>


    @POST(ApiConstant.VALIDAR_USUARIO)
    @FormUrlEncoded
    fun validarUsuario(
        @Field("username") usuario: String?,
        @Field("password") contrasena: String?
    ): Call<RespuestaBase<UsuarioResponse>>


}