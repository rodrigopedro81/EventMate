package com.seletivo.eventmate

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface InterfaceAPI {
    @GET("events.json?alt=media&token=e71933b1-1c80-4e04-945f-2d3d657fd333")
    fun ListEventos(): Call<Dados>
}

fun retrofit(): Retrofit = Retrofit.Builder()
    .baseUrl("https://firebasestorage.googleapis.com/v0/b/rpg-campanhas.appspot.com/o/")
    .addConverterFactory(GsonConverterFactory.create()).build()
