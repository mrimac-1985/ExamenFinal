package com.proyect.sist.presenter

import com.proyect.sist.base.BasePresenter
import com.proyect.sist.utilitarios.AdministradorDePreferencias
import com.proyect.sist.views.PantallaInicioView

/**
 * Created by Maximo Rimac on 10/10/2020.
 */
class PantallaInicioPresenter : BasePresenter<PantallaInicioView> {

    private var view: PantallaInicioView? = null

    override fun initView(view: PantallaInicioView) {
        this.view = view
    }

    override fun destroyView() {
        this.view = null
    }

    override fun onResume() {
        TODO("Not yet implemented")
    }

    fun irInicioSesion() {
        view?.irInicioSesion()
    }


    fun validarSesion() {

        val usuario = AdministradorDePreferencias.obtenerUsuario(view?.obtenerContexto()!!)
        if (usuario.isNullOrBlank()) {
            irInicioSesion()
        } else {
            irPantallaInicio()
        }


    }

    private fun irPantallaInicio() {
        view?.irPantallaInicio()
    }


}