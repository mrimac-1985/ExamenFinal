package com.proyect.sist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proyect.sist.R


class OlvideContraseniaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_olvide_contrasenia)

        title = getString(R.string.lbl_olvidecontrasenia)
    }
}