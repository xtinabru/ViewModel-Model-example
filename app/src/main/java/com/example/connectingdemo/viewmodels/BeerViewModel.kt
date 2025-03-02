package com.example.connectingdemo.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connectingdemo.models.Beer
import com.example.connectingdemo.models.BeerApi
import kotlinx.coroutines.launch

class BeerViewModel: ViewModel() {
    var beer by mutableStateOf<Beer?>(null)


    init {
        getBeer()
    }

    fun getBeer() {
        viewModelScope.launch {
            var beerApi: BeerApi? = null

            try {
                beerApi = BeerApi.getInstance()
                beer = beerApi.getBeer()
                Log.d("BEER", beer.toString())

            } catch (e: Exception){
                Log.d("ERROR", e.message.toString())

            }

        }
    }
}