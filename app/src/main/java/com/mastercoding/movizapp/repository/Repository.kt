package com.mastercoding.movizapp.repository

import android.content.Context
import com.mastercoding.movizapp.retrofit.Movie
import com.mastercoding.movizapp.retrofit.RetrofitInstance
import com.mastercoding.movizapp.room.MovieDAO
import com.mastercoding.movizapp.room.MoviesDB

class Repository(context: Context) {

    // Fetching data from Online API
    suspend fun getPopularMoviesFromOnlineApi(apiKey:String):List<Movie>{
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }


    // Fetching data from Offline ROOM Database
    private val db = MoviesDB.getInstance(context)
    private val movieDao : MovieDAO = db.moviesDao


    suspend fun getMoviesFromDB(): List<Movie>{
        return movieDao.getAllMoviesInDB()
    }


    suspend fun insertMoviesIntoDB(movies:List<Movie>){
        return movieDao.insertMoviesList(movies)
    }





}