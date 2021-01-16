package com.proyect.sist.activities

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.proyect.sist.R
import com.proyect.sist.base.BaseActivity
import com.proyect.sist.databinding.ActivityExamenBinding
import com.proyect.sist.fragments.ProductoFragment
import com.proyect.sist.presenter.ExamenPresenter
import com.proyect.sist.views.ExamenView

class ExamenActivity : BaseActivity(), ExamenView {


    lateinit var presenter:ExamenPresenter;
    lateinit var binding: ActivityExamenBinding;


    override fun onDestroy() {
        presenter.destroyView()
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExamenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter= ExamenPresenter()
        presenter.initView(this)
        initUI()

    }

    private fun initUI() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, ProductoFragment())
            .commit()

    }


}