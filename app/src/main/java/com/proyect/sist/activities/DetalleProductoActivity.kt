package com.proyect.sist.activities

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide
import com.proyect.sist.AndroidApplication
import com.proyect.sist.R
import com.proyect.sist.base.BaseActivity
import com.proyect.sist.database.CarritoCompraEntidad
import com.proyect.sist.databinding.ActivityDetalleProductoBinding
import com.proyect.sist.databinding.ActivityLoginBinding
import com.proyect.sist.models.ProductoModelo
import com.proyect.sist.presenter.DetalleProducotPresenter
import com.proyect.sist.views.DetalleProductoView
import java.util.*

class DetalleProductoActivity : BaseActivity(),DetalleProductoView {

    lateinit var binding: ActivityDetalleProductoBinding
    lateinit var presenter: DetalleProducotPresenter

    lateinit var producto: ProductoModelo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        presenter = DetalleProducotPresenter()
        presenter.initView(this)
        initUI()

        binding.btnagregarcaritocompras.setOnClickListener {
            presenter.agregarProductoCarrito()
        }

    }

    override fun onDestroy() {
        presenter.destroyView()
        super.onDestroy()
    }


    private fun initUI() {
        title = getString(R.string.lbl_detalleProducto)


        val item = intent.getParcelableExtra<ProductoModelo>("item")
        if (item != null) {

            producto =  ProductoModelo(item.id, item.name,item.idproducto, item.description, item.price, item.urlImage, item.estadoPedido, item.llavepedido)

            Glide.with(this).load(item.urlImage).into(binding.ivImagen)

            binding.tvDescripcion.text = item.description
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

    override fun irCarritoCompras() {

        /*GUARDE EL PRODUCTO*/
        insertarcarritocompras().execute()

        val intent = Intent(this, CarritoComprasActivity::class.java)
        startActivity(intent)

    }


    inner class insertarcarritocompras : AsyncTask<Void, Void, Void>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: Void?): Void? {
            insertar()
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
        }
    }


    private fun insertar(){

        val productoentidad = CarritoCompraEntidad(
            UUID.randomUUID().toString(),
            this.producto.name,
            this.producto.id,
            this.producto.description,
            this.producto.price,
            this.producto.urlImage,
            true,
            ""
        )
        /*INSERRTA EL PRODUCTO*/
        AndroidApplication.baseDeDatos?.carritoCompraDao()?.insertar(productoentidad)
    }



}