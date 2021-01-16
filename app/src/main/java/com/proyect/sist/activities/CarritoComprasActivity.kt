package com.proyect.sist.activities

import android.content.Intent
import android.os.AsyncTask

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.proyect.sist.AndroidApplication

import com.proyect.sist.R
import com.proyect.sist.adapters.CarritoComprasAdapter
import com.proyect.sist.base.BaseActivity
import com.proyect.sist.database.CarritoCompraEntidad
import com.proyect.sist.database.PedidodEntidad
import com.proyect.sist.databinding.ActivityCarritoComprasBinding
import com.proyect.sist.models.PedidoModelo
import com.proyect.sist.models.ProductoModelo

import com.proyect.sist.presenter.CarritoCompraPresenter

import com.proyect.sist.views.CarritoCompraView
import kotlinx.android.synthetic.main.activity_carrito_compras.*
import java.util.*
import kotlin.collections.ArrayList

class CarritoComprasActivity : BaseActivity(), CarritoCompraView {

    lateinit var binding: ActivityCarritoComprasBinding
    lateinit var presenter: CarritoCompraPresenter

    lateinit var adapter: CarritoComprasAdapter

    val lista = ArrayList<ProductoModelo>()

    var total = 0.0
    var subtotal = 0.0
    var igv = 0.0

    var ultimopeidod = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoComprasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CarritoComprasAdapter()
        rvCarritoCompras.layoutManager=LinearLayoutManager(this)
        rvCarritoCompras.adapter= adapter

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = CarritoCompraPresenter()
        presenter.initView(this)

        carritoComprasAsynctask().execute()
        ObtenerUltimopedidoAsynctask().execute()
        initUI()

    }




    inner class carritoComprasAsynctask : AsyncTask<Void, Void, List<CarritoCompraEntidad>?>() {
        override fun doInBackground(vararg p0: Void?): List<CarritoCompraEntidad>? {
            return AndroidApplication.baseDeDatos?.carritoCompraDao()?.obtenercarritocompra()
        }

        override fun onPostExecute(result: List<CarritoCompraEntidad>?) {
            super.onPostExecute(result)

            if (!result.isNullOrEmpty()) {

                for (item in result) {
                    lista.add(ProductoModelo(item.id, item.nombre, item.idproducto, item.description,item.price ,item.urlImage,item.estadoPedido,item.llavepedido ))
                    total += item.price!!
                }
                adapter.agregardatos(lista)

                /**CARGA MONTOS DEL PRODUCTO*/
                txttotal.text = "S/ "+  total!!.toString();
                txtigv.text = "S/ "+ Math.round ((((total!!/1.18)*0.18)*100)/100)  .toString();
                txtsubtotal.text ="S/ "+ (  Math.round(total!!/1.18)).toString();

                total = total!!;
                subtotal =  ((total!!/1.18)*0.18);
                igv = (total!!/1.18);
            }
//            else{
//                /*cargando la lista*/
//                val lista = ArrayList<ProductoModelo>()
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                lista.add(ProductoModelo("1","Computadora", "computadora", 100.5, "https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000", true))
//                adapter.agregardatos(lista)
//
//            }
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

    override fun onDestroy() {
        presenter.destroyView()
        super.onDestroy()
    }


    private fun initUI() {
        title = getString(R.string.lbl_carritocompras)


        binding.btnrealizarpedido.setOnClickListener {
            presenter.realizarpeidod()
        }
        binding.btnregresarlistaproducto.setOnClickListener {
            presenter.regresarlistaproducto()
        }


    }

    override fun irlistaproducto() {

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)

    }

    /**realizar pedido*/
    override fun realizarpedido() {

        registrarpedidoasincrono().execute()

        Toast.makeText(this, "PEDIDO REGISTRADO CORRECTAMENTE", Toast.LENGTH_SHORT).show()
    }



    inner class registrarpedidoasincrono : AsyncTask<Void, Void, Void>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: Void?): Void? {
            registrarpedido()
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
        }
    }

    private fun registrarpedido() {

        val pedido2 = PedidodEntidad( null, subtotal.toString(), igv.toString(), total.toString())
        AndroidApplication.baseDeDatos?.pedidodao()?.insertar(pedido2)

        actulizaCarrito().execute()
    }


    inner class ObtenerUltimopedidoAsynctask : AsyncTask<Void, Void, PedidodEntidad?>() {
        override fun doInBackground(vararg p0: Void?): PedidodEntidad? {
            return AndroidApplication.baseDeDatos?.pedidodao()?.obtenerultimopedido()
        }

        override fun onPostExecute(result: PedidodEntidad?) {
            super.onPostExecute(result)
            if (result != null) {
                ultimopeidod = result.id!!
            }

        }

    }

    inner class actulizaCarrito : AsyncTask<Void, Void, Void>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: Void?): Void? {
            actulizarCarrito()
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
        }
    }


    private fun actulizarCarrito() {

        var ultimo = ultimopeidod + 1

        for (item in lista) {

            val carrito = CarritoCompraEntidad(
                item.id,
                item.name,
                item.idproducto,
                item.description,
                item.price,
                item.urlImage,
                false,
                ultimo.toString()
            )

            AndroidApplication.baseDeDatos?.carritoCompraDao()?.actualizar(carrito)
//        }


        }

    }

//    var id: String,
//    var name: String?,
//    var description: String?,
//    var price: Double?,
//    var urlImage: String?,
//    var status: Boolean?


}