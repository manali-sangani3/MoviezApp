package com.mastercoding.movizapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mastercoding.movizapp.repository.Repository
import com.mastercoding.movizapp.retrofit.Movie
import kotlinx.coroutines.launch

class MovieViewModel(repository: Repository): ViewModel() {
    // when the value of 'movies' changes, Compose will
    // automatically recompose the parts of the UI that depend
    // on this state
    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    // The Online Movies
    var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())
        private set


    // The Offline Movies
    var moviesFromRoomDB by mutableStateOf<List<Movie>>(emptyList())
        private set


    init {
        viewModelScope.launch {

            try {

                moviesFromApi= repository
                    .getPopularMoviesFromOnlineApi(
                        "890a86f5656fdca2767b6be3222e3526"
                    )


                // Insert Movies into ROOM DB
                repository.insertMoviesIntoDB(moviesFromApi)


                movies = moviesFromApi
            }catch (e:Exception){

                // Fetch The data from ROOM DB
                moviesFromRoomDB= repository.getMoviesFromDB()

                movies = moviesFromRoomDB


            }
        }
    }



}