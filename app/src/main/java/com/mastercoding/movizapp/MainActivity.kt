package com.mastercoding.movizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.mastercoding.movizapp.repository.Repository
import com.mastercoding.movizapp.screens.MovieScreen
import com.mastercoding.movizapp.ui.theme.MovizAppTheme
import com.mastercoding.movizapp.viewmodel.MovieViewModel
import com.mastercoding.movizapp.viewmodel.MovieViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        // repository
        val repository = Repository(applicationContext)

        // view model factory
        val viewModelFactory = MovieViewModelFactory(repository)

        // view model
        val movieViewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[MovieViewModel::class.java]


        setContent {
            MovizAppTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                ) {

                    HeaderComposable()

                    MovieScreen(viewModel = movieViewModel)
                }


            }
        }
    }
}


@Composable
fun HeaderComposable() {

    Column(
        horizontalAlignment =
            Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 12.dp)
    ) {
        Text(
            text = "The Moviz App",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Get Popular Movies",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal

        )

    }


}

