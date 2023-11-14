package uz.asadbek.myapplication.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uz.asadbek.myapplication.models.CourseData
import uz.asadbek.myapplication.models.CurrencyResponse

interface ApiService {

    @GET("uz/arkhiv-kursov-valyut/json/USD/{date}")
    fun getAllCourse(
        @Path("date") date: String
    ): Call<List<CurrencyResponse>>

    @GET("uz/arkhiv-kursov-valyut/json/")
    fun getAllCourse2(): Call<List<CourseData>>

}