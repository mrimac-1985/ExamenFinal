package com.proyect.sist.presenter

import com.proyect.sist.base.BasePresenter
import com.proyect.sist.views.ExamenView

/**
 * Created by Maximo Rimac on 08/01/2021.
 */
class ExamenPresenter : BasePresenter<ExamenView> {

    private var view:ExamenView?=null

    override fun initView(view: ExamenView) {
        this.view=view
    }

    override fun destroyView() {
        this.view=null
    }

    override fun onResume() {
        TODO("Not yet implemented")
    }


}