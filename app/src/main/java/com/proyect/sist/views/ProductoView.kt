package com.proyect.sist.views

import com.proyect.sist.base.BaseView
import com.proyect.sist.net.ProductoResponse

/**
 * Created by Maximo Rimac on 06/01/2021.
 */
interface ProductoView : BaseView {

    fun cargarProducto(data: List<ProductoResponse>)
    fun mostrarMensajeError(s: String)

}