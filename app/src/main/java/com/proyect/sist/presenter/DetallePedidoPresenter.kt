package com.proyect.sist.presenter

import com.proyect.sist.base.BasePresenter
import com.proyect.sist.views.CarritoCompraView
import com.proyect.sist.views.DetallePedidoView

/**
 * Created by Maximo Rimac on 16/01/2021.
 */
class DetallePedidoPresenter : BasePresenter<DetallePedidoView> {

    private var view:DetallePedidoView?=null

    override fun initView(view: DetallePedidoView) {
        this.view=view
    }

    override fun destroyView() {
        this.view=null
    }

    override fun onResume() {
        TODO("Not yet implemented")
    }
}