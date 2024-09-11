package com.example.wizardcompose.dataclasses.houseclasses

import com.google.gson.annotations.SerializedName

data class House(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("houseColours")
    val houseColours: String?,
    @SerializedName("founder")
    val founder: String?,
    @SerializedName("animal")
    val animal: String?,
    @SerializedName("element")
    val element: String?,
    @SerializedName("ghost")
    val ghost: String?,
    @SerializedName("commonRoom")
    val commonRoom: String?,
    @SerializedName("heads")
    val heads: List<Head> = emptyList(),
    @SerializedName("traits")
    val traits: List<Trait> = emptyList()
)