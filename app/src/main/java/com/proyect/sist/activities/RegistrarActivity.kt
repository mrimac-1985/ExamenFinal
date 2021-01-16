package com.proyect.sist.activities


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.proyect.sist.R
import com.proyect.sist.base.BaseActivity
import com.proyect.sist.databinding.ActivityRegistrarBinding
import com.proyect.sist.presenter.RegistrarUsuarioPresenter
import com.proyect.sist.views.RegistrarUsuarioView

class RegistrarActivity :   BaseActivity(),  RegistrarUsuarioView {


    lateinit var binding: ActivityRegistrarBinding
    lateinit var presenter: RegistrarUsuarioPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_registrar)

        title = getString(R.string.lbl_registrarse)

        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = RegistrarUsuarioPresenter()
        presenter.initView(this)


        binding.btnRegistrarUsuario.setOnClickListener {
            presenter.registrarUsuarioValida()
        }

    }




    override fun obtenerContexto(): Context {
        return this
    }

    /*INCIO OBTENER COMPONENTES*/
    override fun obtenerUsuario(): String {
        return binding.tietUsuario.text.toString()
    }

    override fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

    override fun irLogin() {
        val intent = Intent(this, ActivityLogin::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }

    override fun obtenerNombre(): String {
        return binding.tietNombre.text.toString()
    }

    override fun obtenerApellido(): String {
        return binding.tietApellido.text.toString()
    }

    override fun obtenerDireccion(): String {
        return binding.tietDireccion.text.toString()
    }

    override fun obtenerCorreo(): String {
        return binding.tietCorreo.text.toString()
    }

    override fun obtenerContraseña(): String {
        return binding.tietContrasena.text.toString()
    }

    override fun obtenerRepContraseña(): String {
        return binding.tietRepContrasena.text.toString()
    }

    override fun obtenerTelefono(): String {
        return binding.tietTelefono.text.toString()
    }

    override fun MostrarErrorUsuario(mensaje: String) {
        binding.tietUsuario.error = mensaje
    }

    override fun MostrarErrorNombre(mensaje: String) {
        binding.tietNombre.error = mensaje
    }

    override fun MostrarErrorApellido(mensaje: String) {
        binding.tietApellido.error = mensaje
    }

    override fun MostrarErrorDireccion(mensaje: String) {
        binding.tietDireccion.error = mensaje
    }

    override fun MostrarErrorCorreo(mensaje: String) {
        binding.tietCorreo.error = mensaje
    }

    override fun MostrarErrorContraseña(mensaje: String) {
        binding.tietContrasena.error = mensaje
    }

    override fun MostrarErrorRepContraseña(mensaje: String) {
        binding.tietRepContrasena.error = mensaje
    }

    override fun MostrarErrorTelefono(mensaje: String) {
        binding.tietTelefono.error = mensaje
    }

    override fun MostrarUsuarioOk() {
        binding.tietUsuario.error = null
    }

    override fun MostraNombreOK() {
        binding.tietNombre.error = null
    }

    override fun MostrarApellidoOK() {
        binding.tietApellido.error = null
    }

    override fun MostrarDireccionOK() {
        binding.tietDireccion.error = null
    }

    override fun MostrarCorreoOK() {
        binding.tietCorreo.error = null
    }

    override fun MostrarContraseñaOK() {
        binding.tietContrasena.error = null
    }

    override fun MostrarRepContraseñaOK() {
        binding.tietRepContrasena.error = null
    }

    override fun MostrarTelefonoOK() {
        binding.tietTelefono.error = null
    }

    /*FIN OBTENER COMPONENTES*/


    override fun mostrarCargando() {
        TODO("Not yet implemented")
    }

    override fun ocultarCargando() {
        TODO("Not yet implemented")
    }



}