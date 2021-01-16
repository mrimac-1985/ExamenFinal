package com.proyect.sist.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import kotlinx.android.parcel.Parcelize
import java.text.DecimalFormat

/**
 * Created by Maximo Rimac on 06/01/2021.
 */
@Parcelize
data  class  ProductoModelo(
    var id: String,
    var name: String?,
    val idproducto: String?,
    var description: String?,
    var price: Double?,
    var urlImage: String?,
    var estadoPedido: Boolean?,
    val llavepedido: String?
): Parcelable

