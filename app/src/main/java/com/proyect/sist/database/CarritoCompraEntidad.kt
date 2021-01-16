package com.proyect.sist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Maximo Rimac on 11/01/2021.
 */
@Entity(tableName="carritocompraentidad")
data class CarritoCompraEntidad (
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "nombre") val nombre: String?,
    val idproducto: String?,
    val description: String?,
    val price: Double?,
    val urlImage: String?,
    val estadoPedido: Boolean?,
    val llavepedido: String?
)
