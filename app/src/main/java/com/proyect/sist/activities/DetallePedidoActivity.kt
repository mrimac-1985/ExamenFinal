package com.proyect.sist.activities

import android.os.AsyncTask

import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager

import com.proyect.sist.AndroidApplication
import com.proyect.sist.adapters.DetallePedidoAdapter
import com.proyect.sist.base.BaseActivity
import com.proyect.sist.database.CarritoCompraEntidad
import com.proyect.sist.databinding.ActivityDetallePedidoBinding
import com.proyect.sist.models.PedidoModelo
import com.proyect.sist.models.ProductoModelo
import com.proyect.sist.presenter.DetallePedidoPresenter
import com.proyect.sist.views.DetallePedidoView

import kotlinx.android.synthetic.main.activity_detalle_pedido.*

class DetallePedidoActivity : BaseActivity(), DetallePedidoView {

    lateinit var binding: ActivityDetallePedidoBinding
    lateinit var presenter: DetallePedidoPresenter
    lateinit var adapter:DetallePedidoAdapter


    val lista = ArrayList<ProductoModelo>()
    var idpedido = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallePedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = DetallePedidoAdapter()
        rvdetallepedido.layoutManager= GridLayoutManager(this, 2)
        rvdetallepedido.adapter= adapter

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = DetallePedidoPresenter()
        presenter.initView(this)

        initUI()
    }

    private fun initUI() {
        title = "Detalle de Pedido"

        if (intent.hasExtra("item")) {
            val item = intent.getParcelableExtra<PedidoModelo>("item")
            if (item != null) {
                idpedido = item.id
                carritoComprasPorIDAsynctask().execute()

            }
        }
    }




    inner class carritoComprasPorIDAsynctask : AsyncTask<Void, Void, List<CarritoCompraEntidad>?>() {
        override fun doInBackground(vararg p0: Void?): List<CarritoCompraEntidad>? {
            return AndroidApplication.baseDeDatos?.carritoCompraDao()?.obtenercarritocompraPorId(idpedido.toString())
        }

        override fun onPostExecute(result: List<CarritoCompraEntidad>?) {
            super.onPostExecute(result)

            if (!result.isNullOrEmpty()) {

                for (item in result) {
                    lista.add(ProductoModelo(item.id, item.nombre, item.idproducto, item.description,item.price ,item.urlImage,item.estadoPedido,item.llavepedido ))
                }
                adapter.agregardatos(lista)

            }

        }



    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun mostrarCargando() {
        TODO("Not yet implemented")
    }

    override fun ocultarCargando() {
        TODO("Not yet implemented")
    }
}