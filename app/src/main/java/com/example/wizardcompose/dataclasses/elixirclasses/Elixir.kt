package com.example.wizardcompose.dataclasses.elixirclasses

import com.google.gson.annotations.SerializedName

data class Elixir(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("effect")
    val effect: String?,
    @SerializedName("sideEffects")
    val sideEffects: String?,
    @SerializedName("characteristics")
    val characteristics: String? = null,
    @SerializedName("time")
    val time: String? = null,
    @SerializedName("difficulty")
    val difficulty: String?,
    @SerializedName("ingredients")
    val ingredients: List<Ingredient>?,
    @SerializedName("inventors")
    val inventors: List<Inventor> = emptyList(),
    @SerializedName("manufacturer")
    val manufacturer: String? = null
)