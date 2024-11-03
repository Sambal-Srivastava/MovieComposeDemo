package com.app.moviecomposedemo.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.app.moviecomposedemo.data.model.MockResponseDto

@Composable
fun Navigation(
    moviesList: List<MockResponseDto.MockData>,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    var imdbId: String? by remember {
        mutableStateOf(null)
    }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.MovieListing
    ) {

        composable<Screens.MovieListing> {
            MovieListing(onItemClicked = { movieId ->
                imdbId = movieId
                navController.navigate(Screens.MovieDetails(movieId))
            }, moviesList, modifier)
        }

        composable<Screens.MovieDetails> {
            val movieDetails: Screens.MovieDetails = it.toRoute()
            MovieDetails(movieDetails.id, modifier)
        }
    }
}