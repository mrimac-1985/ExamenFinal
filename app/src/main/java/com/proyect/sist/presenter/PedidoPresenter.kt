package com.proyect.sist.presenter

import com.proyect.sist.base.BasePresenter
import com.proyect.sist.views.ExamenView
import com.proyect.sist.views.PedidoView
import com.proyect.sist.views.ProductoView

/**
 * Created by Maximo Rimac on 16/01/2021.
 */
class PedidoPresenter : BasePresenter<PedidoView> {

    var view: PedidoView? = null

    override fun initView(view: PedidoView) {
        this.view = view
    }

    override fun destroyView() {
        this.view = null
    }

    override fun onResume() {
        TODO("Not yet implemented")
    }



}