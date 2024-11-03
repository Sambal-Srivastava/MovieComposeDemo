package com.app.moviecomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.app.moviecomposedemo.data.model.MockResponseDto
import com.app.moviecomposedemo.ui.theme.MovieComposeDemo
import com.app.moviecomposedemo.viewmodels.MoviesViewModel
import com.app.moviecomposedemo.views.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MoviesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieComposeDemo {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    var movieList: List<MockResponseDto.MockData> by remember {
                        mutableStateOf(emptyList())
                    }
                    viewModel.fetchMovies(BuildConfig.API_KEY, "marvel")
                    viewModel.movies.observe(this) {
                        movieList = it.data!!
                    }
//                    MovieListing(moviesList = movieList, modifier = Modifier.padding(innerPadding))
                    Navigation(moviesList = movieList, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
