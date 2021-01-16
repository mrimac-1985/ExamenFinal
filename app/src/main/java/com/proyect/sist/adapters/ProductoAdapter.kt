package com.proyect.sist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proyect.sist.databinding.ItemProductoBinding
import com.proyect.sist.models.ProductoModelo

/**
 * Created by Maximo Rimac on 06/01/2021.
 */

class ProductoAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var callback: ProductoCallback

    lateinit var binding: ItemProductoBinding
    val lista = ArrayList<ProductoModelo>()
    lateinit var context: Context


    fun setCallback(callback: ProductoCallback) {
        this.callback = callback
    }

    inner class CarteleraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: ProductoModelo) {
            Glide.with(context)
                .load(model.urlImage)
                .into(binding.ivimagen)

            binding.root.setOnClickListener {
                callback.onClick(model)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        binding = ItemProductoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarteleraViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return lista.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CarteleraViewHolder) {
            holder.bind(lista[position])
        }
    }

    fun agregarDatos(data: ArrayList<ProductoModelo>) {
        lista.addAll(data)
        notifyDataSetChanged()
    }

    interface ProductoCallback {
        fun onClick(model: ProductoModelo)
    }

}