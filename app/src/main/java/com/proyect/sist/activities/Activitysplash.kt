package com.proyect.sist.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.proyect.sist.R
import com.proyect.sist.base.BaseActivity
import com.proyect.sist.databinding.ActivitySplashBinding
import com.proyect.sist.presenter.PantallaInicioPresenter
import com.proyect.sist.views.PantallaInicioView

class Activitysplash : BaseActivity() , PantallaInicioView {

    lateinit var presenter: PantallaInicioPresenter
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = PantallaInicioPresenter()
        presenter.initView(this)
        presenter.validarSesion()
    }


    override fun onDestroy() {
        presenter.destroyView()
        super.onDestroy()
    }


    override fun irInicioSesion() {
        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

    override fun obtenerContexto(): Context {
        return this
    }

    override fun irPantallaInicio() {
        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }, 2000)
    }

    override fun mostrarCargando() {
        TODO("Not yet implemented")
    }

    override fun ocultarCargando() {
        TODO("Not yet implemented")
    }
}