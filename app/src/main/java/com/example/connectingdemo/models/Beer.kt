package com.example.connectingdemo.models
import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Beer(
    @SerializedName("id") val id: Int,
    @SerializedName("brand") val brand: String,
    @SerializedName("name") val name: String,
    @SerializedName("style") val style: String
)
const val BASE_url = "https://random-data-api.com/api/v2"

interface BeerApi {
    @GET("beers?size=1") // Добавляем `?size=1`, чтобы API возвращал 1 объект
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
