package com.example.connectingdemo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.connectingdemo.viewmodels.BeerViewModel

@Composable
fun RandomBeerScreen( modifier: Modifier,
                      beerViewModel: BeerViewModel = viewModel()) {
    Column(
        modifier = Modifier.padding(all = 24.dp)
    ){
        Text(
            text = beerViewModel.beer?.name ?: ""
        )
        Text(
            text = beerViewModel.beer?.brand ?: ""
        )
        Text(
            text = beerViewModel.beer?.style ?: ""
        )
        Button(
            onClick = {beerViewModel.getBeer()}
        ) {
            Text("Get the next one")
        }
    }


}