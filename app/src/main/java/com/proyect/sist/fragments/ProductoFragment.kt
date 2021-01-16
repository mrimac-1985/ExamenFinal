package com.proyect.sist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.proyect.sist.R
import com.proyect.sist.activities.ui.home.HomeViewModel
import com.proyect.sist.adapters.ProductoAdapter
import com.proyect.sist.databinding.FragmentHomeBinding
import com.proyect.sist.models.ProductoModelo
import com.proyect.sist.net.ProductoResponse
import com.proyect.sist.presenter.ProductoPresenter
import com.proyect.sist.views.ProductoView
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductoFragment : BaseFragment() , ProductoAdapter.ProductoCallback, ProductoView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private lateinit var homeViewModel: HomeViewModel

    lateinit var binding: FragmentHomeBinding;
    lateinit var adapter: ProductoAdapter;
    lateinit var presenter: ProductoPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = ProductoPresenter()
        presenter.initView(this)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProductoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ProductoAdapter()
        adapter.setCallback(this)
        binding.rvProductos.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvProductos.adapter = adapter

        presenter.traerProductos()

    }


    override fun onClick(model: ProductoModelo) {
        TODO("Not yet implemented")
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

    override fun mostrarMensajeError(s: String) {
        TODO("Not yet implemented")
    }

    override fun mostrarCargando() {

    }

    override fun ocultarCargando() {
        TODO("Not yet implemented")
    }
}