package com.proyect.sist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proyect.sist.R
import com.proyect.sist.databinding.ItemCarritoComprasBinding
import com.proyect.sist.databinding.ItemDetallePedidoBinding
import com.proyect.sist.models.ProductoModelo
import kotlinx.android.synthetic.main.item_detalle_pedido.view.*

/**
 * Created by Maximo Rimac on 16/01/2021.
 */
class DetallePedidoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    val lista = ArrayList<ProductoModelo>()
    lateinit var binding: ItemDetallePedidoBinding

    private var context: Context? = null

    fun agregardatos(datos: ArrayList<ProductoModelo>){
        lista.addAll(datos)
        notifyDataSetChanged()
    }

    /*create clase interna del adapter*/
    inner class  CarritoComprasViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        fun cargardiseño(productoModelo: ProductoModelo) {

            Glide.with(context!!).load(productoModelo.urlImage)
                .placeholder(R.drawable.ic_menu_camera)
                .error(R.drawable.ic_menu_camera)
                .into(itemView.ivimagen);



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_detalle_pedido, parent, false)

        return  CarritoComprasViewHolder(view)
    }


    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is CarritoComprasViewHolder){
            holder.cargardiseño(lista[position])
        }
    }

}