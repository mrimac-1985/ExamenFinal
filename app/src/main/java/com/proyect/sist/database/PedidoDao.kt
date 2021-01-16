package com.proyect.sist.database

import androidx.room.*

/**
 * Created by Maximo Rimac on 15/01/2021.
 */
@Dao
interface PedidoDao {

    @Query("select * from PedidodEntidad ")
    fun obtenerpedido(): List<PedidodEntidad>?

    @Query("select * from PedidodEntidad  ORDER BY id  DESC LIMIT 1")
    fun obtenerultimopedido(): PedidodEntidad?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertar(pedidoentidad: PedidodEntidad)

    @Update
    fun actualizar(pedidoentidad: PedidodEntidad)


}