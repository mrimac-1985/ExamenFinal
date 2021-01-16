package com.proyect.sist.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.proyect.sist.R
import com.proyect.sist.base.BaseActivity
import com.proyect.sist.databinding.ActivityLoginBinding
import com.proyect.sist.presenter.IniciarSesionPresenter
import com.proyect.sist.views.IniciarSesionView


class ActivityLogin : BaseActivity(), IniciarSesionView {

    lateinit var binding: ActivityLoginBinding
    lateinit var presenter: IniciarSesionPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = getString(R.string.lbl_tituloLogin)

        presenter = IniciarSesionPresenter()
        presenter.initView(this)

        binding.btnIngresar.setOnClickListener {
            presenter.validateLogin()
        }
        binding.tvRegistrarse.setOnClickListener {
            presenter.register()
        }
        binding.tvOlvidoContrasenia.setOnClickListener {
            presenter.olvidecontraseña()
        }

    }

    override fun irInicio() {
        val intent = Intent(this, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()

    }

    override fun irRegistro() {
        val intent = Intent(this, RegistrarActivity::class.java)
        startActivity(intent)
    }
    override fun irOlvideContraseña() {
        val intent = Intent(this, OlvideContraseniaActivity::class.java)
        startActivity(intent)
    }

    override fun obtenerUsuario(): String {
        return binding.tietUsuario.text.toString()
    }

    override fun obtenerContrasena(): String {
        return binding.tietContrasena.text.toString()
    }

    override fun mostrarUsuarioError(message: String) {
        binding.tilUsuario.error = message
    }

    override fun mostrarContrasenaError(message: String) {
        binding.tilContrasena.error = message
    }

    override fun mostrarUsuarioOk() {
        binding.tilUsuario.error = null
    }

    override fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

    override fun obtenerContexto(): Context {
        return this
    }

    override fun mostrarCargando() {

    }

    override fun ocultarCargando() {

    }
}