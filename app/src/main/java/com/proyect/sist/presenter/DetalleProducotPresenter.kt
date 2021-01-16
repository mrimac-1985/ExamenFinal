package com.proyect.sist.presenter

import com.proyect.sist.base.BasePresenter
import com.proyect.sist.views.DetalleProductoView
import com.proyect.sist.views.ExamenView

/**
 * Created by Maximo Rimac on 10/01/2021.
 */
class DetalleProducotPresenter : BasePresenter<DetalleProductoView> {

    private var view:DetalleProductoView?=null


    override fun initView(view: DetalleProductoView) {
        this.view=view
    }

    override fun destroyView() {
        this.view=null
    }

    override fun onResume() {
        TODO("Not yet implemented")
    }


    fun agregarProductoCarrito() {

        view?.irCarritoCompras()
    }

}