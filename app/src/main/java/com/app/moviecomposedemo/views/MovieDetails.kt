package com.app.moviecomposedemo.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.app.moviecomposedemo.BuildConfig
import com.app.moviecomposedemo.ui.theme.MovieComposeDemo
import com.app.moviecomposedemo.viewmodels.MoviesViewModel

@Composable
fun MovieDetails(moviesId: String, modifier: Modifier = Modifier) {
    var viewModel: MoviesViewModel = hiltViewModel()

    LaunchedEffect(key1 = moviesId) {
        moviesId.let{
            viewModel.fetchMovieDetails(movieId = it, apiKey = BuildConfig.API_KEY)
        }
    }

    //observe movie details
    val movieDetails by viewModel.movieDetails.observeAsState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        AsyncImage(
            model = movieDetails?.poster,
            contentDescription = null,
        )
        Text(
            text = "Hello ${movieDetails?.title}!"
        )
        Text(
            text = "Hello ${movieDetails?.year}!"
        )
    }

}

@Preview(showBackground = true)
@Composable
fun MovieDetailsPreview() {
    MovieComposeDemo {
        MovieDetails("")
    }
}
