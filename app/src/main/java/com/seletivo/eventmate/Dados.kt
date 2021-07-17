package com.seletivo.eventmate

import com.google.gson.annotations.SerializedName

class Dados : ArrayList<DadosItem>()

data class DadosItem(
    @SerializedName("cupons")val cupons: List<String>,
    @SerializedName("date")val date: Int,
    @SerializedName("description")val description: String,
    @SerializedName("id")val id: String,
    @SerializedName("image")val image: String,
    @SerializedName("latitude")val latitude: Double,
    @SerializedName("longitude")val longitude: Double,
    @SerializedName("people")val people: List<People>,
    @SerializedName("price")val price: Double,
    @SerializedName("title")val title: String
)

data class People(
    @SerializedName("eventId")val eventId: String,
    @SerializedName("id")val id: String,
    @SerializedName("name")val name: String,
    @SerializedName("picture")val picture: String
)

