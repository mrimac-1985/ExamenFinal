package com.proyect.sist

import android.app.Application
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.proyect.sist.database.AppDataBase
import java.util.*

/**
 * Created by Maximo Rimac on 11/01/2021.
 */
class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        baseDeDatos = Room.databaseBuilder(this, AppDataBase::class.java, "tienda")
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)

//                    db.execSQL(
//                        "insert into carritocompraentidad(id,nombre,idproducto,description,price,urlImage,estadoPedido,llavepedido) " +
//                                "values ('" + UUID.randomUUID().toString() + "','LAPTOP','123','https://promart.vteximg.com.br/arquivos/ids/598970-1000-1000/image-8938bec443a549dc8539a62dcd343a69.jpg?v=637419631519030000',100,'',1,'')"
//                    )



                }
            })
            .build()
    }

    companion object {
        var baseDeDatos: AppDataBase? = null
    }
}