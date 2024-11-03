package com.app.moviecomposedemo.views

sealed class Screens {
    @kotlinx.serialization.Serializable
    data object MovieListing: Screens()

    @kotlinx.serialization.Serializable
    data class MovieDetails(val id: String): Screens()
}