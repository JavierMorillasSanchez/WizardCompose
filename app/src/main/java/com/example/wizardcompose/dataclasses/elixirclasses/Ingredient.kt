package com.example.wizardcompose.dataclasses.elixirclasses

import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)