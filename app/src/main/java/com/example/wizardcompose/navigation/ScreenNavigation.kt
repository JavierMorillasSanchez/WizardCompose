package com.example.wizardcompose.navigation

sealed class ScreenNavigation (
    val route: String
) {

    object MainScreen: ScreenNavigation("Main_Screen")
    object HousesScreen: ScreenNavigation("Houses_Screen")




}