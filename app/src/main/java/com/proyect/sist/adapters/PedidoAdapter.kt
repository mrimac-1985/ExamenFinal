package com.proyect.sist.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.proyect.sist.R
import com.proyect.sist.activities.DetallePedidoActivity
import com.proyect.sist.activities.ui.pedidos.PedidoFragment
import com.proyect.sist.databinding.ItemPedidoBinding
import com.proyect.sist.models.PedidoModelo
import kotlinx.android.synthetic.main.item_pedido.view.*

/**
 * Created by Maximo Rimac on 16/01/2021.
 */
class PedidoAdapter   : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var callback: PedidoCallback


    val lista = ArrayList<PedidoModelo>()
    lateinit var binding: ItemPedidoBinding


    fun setCallback(callback: PedidoCallback) {
        this.callback = callback
    }

    interface PedidoCallback {
        fun onClick(model: PedidoModelo)
    }


    fun agregardatos(datos: ArrayList<PedidoModelo>){
        lista.addAll(datos)
        notifyDataSetChanged()
    }


    /*create clase interna del adapter*/
    inner class  PedidoViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        fun cargardiseño(pedidomodelo: PedidoModelo) {

            itemView.txtnombrepedido.text = "Pedido "+ pedidomodelo.id.toString()
            /*evento de la grilla*/
            itemView.imageButton.setOnClickListener {
                callback.onClick(pedidomodelo)
            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_pedido, parent, false)
        return  PedidoViewHolder(view)
    }


    override fun getItemCount(): Int {
        return lista.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is PedidoViewHolder){
            holder.cargardiseño(lista[position])
        }
    }


}