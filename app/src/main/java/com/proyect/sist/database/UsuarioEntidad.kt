package com.proyect.sist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Maximo Rimac on 10/10/2020.
 */
@Entity
data class UsuarioEntidad(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "nombre") val nombre: String?,
    val apellido: String?,
    val usuario: String?,
    val email: String?,
    val direccion: String?,
    val contrasena: String?,
    val telefono: String?
)