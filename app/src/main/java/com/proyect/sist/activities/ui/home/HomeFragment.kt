package com.proyect.sist.activities.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.proyect.sist.activities.DetalleProductoActivity
import com.proyect.sist.adapters.ProductoAdapter
import com.proyect.sist.databinding.FragmentHomeBinding
import com.proyect.sist.fragments.BaseFragment
import com.proyect.sist.fragments.ProductoFragment
import com.proyect.sist.models.ProductoModelo
import com.proyect.sist.net.ProductoResponse
import com.proyect.sist.presenter.ProductoPresenter
import com.proyect.sist.views.ProductoView
import kotlinx.android.synthetic.main.cargando.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*
import kotlin.collections.ArrayList

private const val ARG_PARAM1 = "param1"

class HomeFragment : BaseFragment() , ProductoAdapter.ProductoCallback, ProductoView{



    private lateinit var homeViewModel: HomeViewModel

    lateinit var binding: FragmentHomeBinding;
    lateinit var adapter: ProductoAdapter;
    lateinit var presenter: ProductoPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ProductoPresenter()
        presenter.initView(this)
    }


    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?, savedInstanceState: Bundle?  ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ProductoAdapter()
        adapter.setCallback(this)
        binding.rvProductos.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvProductos.adapter = adapter

        presenter.traerProductos()

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

    override fun onClick(model: ProductoModelo) {

        if(model!= null){
            val intent = Intent(activity, DetalleProductoActivity::class.java)
            intent.putExtra("item", model)
            startActivity(intent)
        }

    }

    override fun cargarProducto(data: List<ProductoResponse>) {
        //llMensajeError.visibility=View.GONE
        if (!data.isNullOrEmpty()) {
            val lista = ArrayList<ProductoModelo>()
            for (item in data) {
                lista.add(
                    ProductoModelo(
                        UUID.randomUUID().toString(),
                        item.name,
                        "",
                        item.description,
                        item.price,
                        item.urlImage,
                        item.status,
                        ""
                    )
                )
            }
            adapter.agregarDatos(lista)
        }
    }

    override fun mostrarMensajeError(mensaje: String) {
        llMensajeError.visibility = View.VISIBLE
        tvMensaje.text = mensaje
    }

    override fun mostrarCargando() {
        clCargando.visibility = View.VISIBLE
    }

    override fun ocultarCargando() {
        clCargando.visibility = View.GONE
    }


}