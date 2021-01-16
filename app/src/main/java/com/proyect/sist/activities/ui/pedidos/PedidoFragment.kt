package com.proyect.sist.activities.ui.pedidos

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.proyect.sist.AndroidApplication
import com.proyect.sist.activities.DetallePedidoActivity
import com.proyect.sist.adapters.PedidoAdapter
import com.proyect.sist.database.PedidodEntidad
import com.proyect.sist.databinding.FragmentPedidosBinding
import com.proyect.sist.fragments.BaseFragment
import com.proyect.sist.fragments.ProductoFragment
import com.proyect.sist.models.PedidoModelo
import com.proyect.sist.presenter.PedidoPresenter
import com.proyect.sist.views.PedidoView
import kotlin.collections.ArrayList


private const val ARG_PARAM1 = "param1"

class PedidoFragment : BaseFragment() ,PedidoAdapter.PedidoCallback , PedidoView  {

    lateinit var binding: FragmentPedidosBinding
    lateinit var adapter: PedidoAdapter

    lateinit var presenter: PedidoPresenter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = PedidoPresenter()
        presenter.initView(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = FragmentPedidosBinding.inflate(inflater, container, false)
         return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Initialize
        adapter = PedidoAdapter()
        adapter.setCallback(this)

        binding.rvPedido.layoutManager= LinearLayoutManager(requireContext())
        binding.rvPedido.adapter= adapter


        cargarpedido();

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CarteleraFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            ProductoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }


    override fun onClick(model: PedidoModelo) {

        val intent = Intent(activity, DetallePedidoActivity::class.java)
        intent.putExtra("item", model)
        startActivity(intent)

    }


    fun cargarpedido( ) {
        pedidoAsynctask().execute()
    }



    inner class pedidoAsynctask : AsyncTask<Void, Void, List<PedidodEntidad>?>() {
        override fun doInBackground(vararg p0: Void?): List<PedidodEntidad>? {
            return AndroidApplication.baseDeDatos?.pedidodao()?.obtenerpedido()
        }

        override fun onPostExecute(result: List<PedidodEntidad>?) {
            super.onPostExecute(result)

            if (!result.isNullOrEmpty()) {
                val lista = ArrayList<PedidoModelo>()
                for (item in result) {

                    lista.add(PedidoModelo(item.id!!, item.subtotal ,item.igv, item.total))
                }
                adapter.agregardatos(lista)

            }
        }

    }





    /*cargar pedidos*/



}