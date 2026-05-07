package com.mastercoding.movizapp.screens

import androidx.compose.runtime.Composable
import com.mastercoding.movizapp.viewmodel.MovieViewModel

@Composable
fun MovieScreen(viewModel: MovieViewModel){
    // Any change in 'movie' state var, it'll trigger
    // an automatic recomposition to this 'MovieScreen'
    // composable

    val moviesList = viewModel.movies
    MovieList(movies = moviesList)



}