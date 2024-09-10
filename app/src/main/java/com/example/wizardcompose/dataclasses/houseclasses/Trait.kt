package com.example.wizardcompose.dataclasses.houseclasses

import com.google.gson.annotations.SerializedName

data class Trait(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)