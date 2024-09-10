package com.example.wizardcompose.dataclasses.houseclasses

import com.google.gson.annotations.SerializedName

data class Head(
    @SerializedName("id")
    val id: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String
)