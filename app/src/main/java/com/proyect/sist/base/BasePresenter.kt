package com.proyect.sist.base

/**
 * Created by Maximo Rimac on 10/10/2020.
 */
interface BasePresenter <T>{
    fun initView(view: T)
    fun destroyView()
    fun onResume()


}