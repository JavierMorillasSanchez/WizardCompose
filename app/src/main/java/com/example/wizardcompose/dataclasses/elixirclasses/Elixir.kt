package com.example.wizardcompose.dataclasses.elixirclasses

data class Elixir(
    val id: String,
    val name: String,
    val effect: String,
    val sideEffects: String,
    val characteristics: String? = null,
    val time: String? = null,
    val difficulty: String,
    val ingredients: List<Ingredient>,
    val inventors: List<Inventor> = emptyList(),
    val manufacturer: String? = null
)