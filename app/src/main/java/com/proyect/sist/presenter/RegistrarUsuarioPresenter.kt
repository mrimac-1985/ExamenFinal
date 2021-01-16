package com.proyect.sist.presenter

import com.proyect.sist.base.BasePresenter
import com.proyect.sist.database.UsuarioEntidad
import com.proyect.sist.net.ConfiguracionRetrofit
import com.proyect.sist.net.RespuestaBase
import com.proyect.sist.net.UsuarioMetodos
import com.proyect.sist.net.UsuarioResponse
import com.proyect.sist.views.IniciarSesionView
import com.proyect.sist.views.RegistrarUsuarioView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Field
import java.util.*

/**
 * Created by Maximo Rimac on 12/12/2020.
 */
class RegistrarUsuarioPresenter  : BasePresenter<RegistrarUsuarioView> {


    private var view: RegistrarUsuarioView? = null

    fun registrarUsuarioValida(){

        if (view?.obtenerUsuario().isNullOrBlank()) {
            view?.MostrarErrorNombre("El campo es requerido")
            return
        } else {
            view?.MostraNombreOK()
        }

        if (view?.obtenerNombre().isNullOrBlank()) {
            view?.MostrarErrorNombre("El campo es requerido")
            return
        } else {
            view?.MostraNombreOK()
        }


        this.registrarUsuario()
    }


    fun registrarUsuario(){

        val retrofit = ConfiguracionRetrofit.obtenerConfiguracion()?.create(UsuarioMetodos::class.java)
        val call = retrofit?.registrarUsuario(view?.obtenerNombre() ,view?.obtenerApellido(),view?.obtenerUsuario(), view?.obtenerContraseña(), view?.obtenerCorreo(), view?.obtenerDireccion(), view?.obtenerTelefono())
        call?.enqueue(object : Callback<RespuestaBase<UsuarioResponse>> {
            override fun onResponse(
                call: Call<RespuestaBase<UsuarioResponse>>,
                response: Response<RespuestaBase<UsuarioResponse>>
            ) {
                val respuesta = response.body()
                if (respuesta?.estado == false) {
                    view?.mostrarError("Usuario y/o contraseña no existe")
                } else {
                    view?.mostrarError("Usuario Registrado correctamente")
//                    val data = respuesta?.data
//                    if (data != null) {
//                        val dataEntidad = UsuarioEntidad(
//                            UUID.randomUUID().toString(),
//                            data.nombre,
//                            data.apellido,
//                            data.usuario,
//                            data.email,
//                            data.direccion,
//                            data.contrasena,
//                            data.telefono
//                        )
//                        view?.irLogin()
//                    }
                    view?.irLogin()
                }
            }

            override fun onFailure(call: Call<RespuestaBase<UsuarioResponse>>, t: Throwable) {
                view?.mostrarError("Ocurrio un error en el servicio")
            }

        })


    }

    override fun initView(view: RegistrarUsuarioView) {
        this.view = view
    }

    override fun destroyView() {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        TODO("Not yet implemented")
    }



}