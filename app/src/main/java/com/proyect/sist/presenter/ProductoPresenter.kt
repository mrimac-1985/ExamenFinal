package com.proyect.sist.presenter

import android.util.Log
import com.proyect.sist.base.BasePresenter
import com.proyect.sist.net.ConfiguracionRetrofit
import com.proyect.sist.net.ProductoMetodos
import com.proyect.sist.net.ProductoResponse
import com.proyect.sist.net.RespuestaBase
import com.proyect.sist.views.ProductoView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Maximo Rimac on 06/01/2021.
 */
class ProductoPresenter : BasePresenter<ProductoView> {

    var view: ProductoView? = null

    override fun initView(view: ProductoView) {
        this.view = view
    }

    override fun destroyView() {
        this.view = null
    }

    override fun onResume() {
    }


    fun traerProductos() {
        //view?.mostrarCargando()
        val metodos = ConfiguracionRetrofit.obtenerConfiguracion()
            ?.create(ProductoMetodos::class.java)
        val call = metodos?.obtenerProductos()
        call?.enqueue(object : Callback<RespuestaBase<List<ProductoResponse>?>> {
            override fun onFailure(
                call: Call<RespuestaBase<List<ProductoResponse>?>>,
                t: Throwable
            ) {
                Log.d("error-ws", t.message)
                view?.ocultarCargando()
            }

            override fun onResponse(
                call: Call<RespuestaBase<List<ProductoResponse>?>>,
                response: Response<RespuestaBase<List<ProductoResponse>?>>
            ) {
                val respuesta = response.body()
                if (respuesta?.estado == true &&
                    !respuesta.data.isNullOrEmpty()
                ) {
                    view?.cargarProducto(respuesta.data)
                    //view?.ocultarCargando()
                } else {
                    view?.mostrarMensajeError("No hay productos disponibles")
                    //view?.ocultarCargando()
                }
            }

        })
    }


}