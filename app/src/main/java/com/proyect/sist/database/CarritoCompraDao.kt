package com.proyect.sist.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Created by Maximo Rimac on 11/01/2021.
 */

@Dao
interface CarritoCompraDao {


    @Query("select * from carritocompraentidad where estadoPedido = 1")
    fun obtenercarritocompra(): List<CarritoCompraEntidad>?

    @Insert
    fun insertar(carritocompraentidad: CarritoCompraEntidad)

    @Update
    fun actualizar(carritocompraentidad: CarritoCompraEntidad)


    @Query("select * from carritocompraentidad where llavepedido = :id")
    fun obtenercarritocompraPorId(id: String): List<CarritoCompraEntidad>?

}