package com.example.wizardcompose.dataclasses.houseclasses

data class House(
    val id: String,
    val name: String,
    val houseColours: String,
    val founder: String,
    val animal: String,
    val element: String,
    val ghost: String,
    val commonRoom: String,
    val heads: List<Head>,
    val traits: List<Trait>
)