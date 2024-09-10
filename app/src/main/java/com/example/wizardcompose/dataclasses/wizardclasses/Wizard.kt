package com.example.wizardcompose.dataclasses.wizardclasses

import com.example.wizardcompose.dataclasses.elixirclasses.Elixir
import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class Wizard(
    @SerializedName("id")
    val id: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("elixirs")
    val elixirs: List<Elixir>
)