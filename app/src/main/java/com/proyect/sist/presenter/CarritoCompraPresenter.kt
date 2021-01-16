package com.proyect.sist.presenter

import com.proyect.sist.base.BasePresenter
import com.proyect.sist.views.CarritoCompraView
import com.proyect.sist.views.DetalleProductoView

/**
 * Created by Maximo Rimac on 10/01/2021.
 */
class CarritoCompraPresenter : BasePresenter<CarritoCompraView> {

    private var view:CarritoCompraView?=null

    override fun initView(view: CarritoCompraView) {
        this.view=view
    }

    override fun destroyView() {
        this.view=null
    }

    override fun onResume() {
        TODO("Not yet implemented")
    }

    fun realizarpeidod() {
        view?.realizarpedido()

    }

    fun regresarlistaproducto() {
        view?.irlistaproducto()
    }


}