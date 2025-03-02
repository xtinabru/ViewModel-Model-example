package com.example.connectingdemo.models
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class Beer (
    var id: Int,
    var brand: String,
    var name: String,
    var style: String,
)
const val BASE_url = "https://random-data-api.com/api/v2"

interface BeerApi {
    @GET("beers")
    suspend fun getBeer(): Beer

    companion object {
        var beerService: BeerApi? = null

        fun getInstance(): BeerApi {

    if(beerService === null ){
        beerService = Retrofit.Builder()
            .baseUrl(BASE_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(BeerApi::class.java)
    }
    return beerService!!
}
}}
