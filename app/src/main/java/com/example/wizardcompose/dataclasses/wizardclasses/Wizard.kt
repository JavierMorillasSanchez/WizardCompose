package com.example.wizardcompose.dataclasses.wizardclasses

import com.example.wizardcompose.dataclasses.elixirclasses.Elixir

data class Wizard(
    val id: String,
    val firstName: String,
    val lastName: String,
    val elixirs: List<Elixir>
)