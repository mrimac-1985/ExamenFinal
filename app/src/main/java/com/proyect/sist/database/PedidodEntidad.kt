package com.proyect.sist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Maximo Rimac on 15/01/2021.
 */

@Entity
data class PedidodEntidad(
    @PrimaryKey (autoGenerate = true)
    val id: Int? = null,
    val subtotal: String?,
    val igv: String?,
    val total: String?


)