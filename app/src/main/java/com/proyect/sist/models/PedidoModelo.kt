package com.proyect.sist.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Maximo Rimac on 16/01/2021.
 */
@Parcelize
data class PedidoModelo (
    val id: Int ,
    val subtotal: String?,
    val igv: String?,
    val total: String?
): Parcelable

