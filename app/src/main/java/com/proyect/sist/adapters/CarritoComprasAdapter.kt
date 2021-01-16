package com.proyect.sist.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proyect.sist.R
import com.proyect.sist.databinding.ItemCarritoComprasBinding
import com.proyect.sist.models.ProductoModelo
import kotlinx.android.synthetic.main.item_carrito_compras.view.*
import java.net.URL


/**
 * Created by Maximo Rimac on 10/01/2021.
 */
class CarritoComprasAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val lista = ArrayList<ProductoModelo>()
    lateinit var binding: ItemCarritoComprasBinding

    private var context: Context? = null

    fun agregardatos(datos: ArrayList<ProductoModelo>){
        lista.addAll(datos)
        notifyDataSetChanged()
    }

    /*create clase interna del adapter*/
    inner class  CarritoComprasViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        fun cargardiseño(productoModelo: ProductoModelo) {
            itemView.txtDescripcion.text = productoModelo.description
            itemView.txtNombreProducto.text= productoModelo.name

            Glide.with(context!!).load(productoModelo.urlImage)
                .placeholder(R.drawable.ic_menu_camera)
                .error(R.drawable.ic_menu_camera)
                .into(itemView.idimagencarrito);

            itemView.btneliminarcompra.setOnClickListener {
                //listener?.onClick(adapterPosition)
            }

        }

    }




    /*METODO PARA CARGAR LA VISTA A ITERAR*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_carrito_compras, parent, false)

        return  CarritoComprasViewHolder(view)
    }

    /*METODO PARA OBTENER LA CANTIDAD DE LEEMENTOS VA A TENER LA LISTA*/
    override fun getItemCount(): Int {
        return lista.size
    }

    /*METODO PARA VINCULAR EL DISEÑO */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is CarritoComprasViewHolder){
            holder.cargardiseño(lista[position])
        }


    }


}