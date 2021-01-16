package com.proyect.sist.database

import androidx.room.Database
import androidx.room.RoomDatabase
/**
 * Created by Maximo Rimac on 10/01/2021.
 */

@Database(entities = [CarritoCompraEntidad::class, UsuarioEntidad::class , PedidodEntidad::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun carritoCompraDao(): CarritoCompraDao
    abstract fun usuariodao(): UsuarioDao
    abstract  fun pedidodao() :PedidoDao
}