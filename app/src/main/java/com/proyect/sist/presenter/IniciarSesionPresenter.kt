package com.proyect.sist.presenter

import com.proyect.sist.base.BasePresenter
import com.proyect.sist.database.UsuarioEntidad
import com.proyect.sist.net.ConfiguracionRetrofit
import com.proyect.sist.net.RespuestaBase
import com.proyect.sist.net.UsuarioMetodos
import com.proyect.sist.net.UsuarioResponse
import com.proyect.sist.utilitarios.AdministradorDePreferencias
import com.proyect.sist.views.IniciarSesionView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Created by Maximo Rimac on 10/10/2020.
 */
class IniciarSesionPresenter : BasePresenter<IniciarSesionView> {


    private var view: IniciarSesionView? = null


    fun validateLogin() {

        if (view?.obtenerUsuario().isNullOrBlank()) {
            view?.mostrarUsuarioError("El campo es requerido")
            return
        } else {
            view?.mostrarUsuarioOk()
        }
        if (view?.obtenerContrasena().isNullOrBlank()) {
            view?.mostrarContrasenaError("El campo es requerido")
            return
        }

        validateUser()
    }

    private fun validateUser() {

        val retrofit = ConfiguracionRetrofit.obtenerConfiguracion()?.create(UsuarioMetodos::class.java)
        val call = retrofit?.validarUsuario(view?.obtenerUsuario(), view?.obtenerContrasena())
        call?.enqueue(object : Callback<RespuestaBase<UsuarioResponse>> {
            override fun onResponse(
                call: Call<RespuestaBase<UsuarioResponse>>,
                response: Response<RespuestaBase<UsuarioResponse>>
            ) {
                val respuesta = response.body()
                if (respuesta?.estado == false) {
                    view?.mostrarError("Usuario y/o contraseña no existe")
                } else {
                    val data = respuesta?.data
                    if (data != null) {
                        val dataEntidad = UsuarioEntidad(
                            UUID.randomUUID().toString(),
                            data.nombre,
                            data.apellido,
                            data.usuario,
                            data.email,
                            data.direccion,
                            data.contrasena,
                            data.telefono
                        )
                        guardarSesion(dataEntidad)
                        view?.irInicio()
                    }
                }
            }

            override fun onFailure(call: Call<RespuestaBase<UsuarioResponse>>, t: Throwable) {
                view?.mostrarError("Ocurrio un error en el servicio")
            }

        })


    }

    private fun guardarSesion(entidad: UsuarioEntidad) {
        val contexto = view?.obtenerContexto()
        if (entidad.usuario != null && contexto != null) {
            AdministradorDePreferencias.agregarUsuario(contexto, entidad.usuario)
            AdministradorDePreferencias.agregarCorreo(contexto, entidad.email!!)
            AdministradorDePreferencias.agregarDireccion(contexto, entidad.direccion!!)
            AdministradorDePreferencias.agregarTelefono(contexto, entidad.telefono!!)


        }
    }



    fun register() {
        view?.irRegistro()
    }

    fun olvidecontraseña(){
        view?.irOlvideContraseña()
    }

    override fun initView(view: IniciarSesionView) {
        this.view = view
    }

    override fun destroyView() {
        this.view = null
    }

    override fun onResume() {

    }

}