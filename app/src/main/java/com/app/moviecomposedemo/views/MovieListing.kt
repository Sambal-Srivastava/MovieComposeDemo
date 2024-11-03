package com.app.moviecomposedemo.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.app.moviecomposedemo.data.model.MockResponseDto
import com.app.moviecomposedemo.ui.theme.MovieComposeDemo

@Composable
fun MovieListing(
    onItemClicked: (movieId: String) -> Unit,
    moviesList: List<MockResponseDto.MockData>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(modifier = modifier.fillMaxSize()) {
            items(moviesList.size) { it: Int ->
                Column(modifier = modifier
                    .fillMaxSize()
                    .clickable {
                        onItemClicked(moviesList[it].imdbId.toString())
                    }) {
                    Text(
                        text = "Hello ${moviesList[it].title}!"
                    )
                }

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MovieListingPreview() {
    MovieComposeDemo {
        MovieListing(onItemClicked = {}, emptyList())
    }
}
