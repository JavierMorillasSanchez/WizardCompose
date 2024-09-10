package com.example.wizardcompose.dataclasses.elixirclasses

import com.google.gson.annotations.SerializedName

data class Inventor(
    @SerializedName("id")
    val id: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String
)