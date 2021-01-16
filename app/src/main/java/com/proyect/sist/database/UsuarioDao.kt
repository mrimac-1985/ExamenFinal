package com.proyect.sist.database

import androidx.room.Dao
import androidx.room.Update

/**
 * Created by Maximo Rimac on 15/01/2021.
 */

@Dao
interface UsuarioDao {

    @Update
    fun actualizar(usuarioEntidad: UsuarioEntidad)
}