import com.example.newswave.api.Articles
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://gnews.io/api/v4/top-headlines?category=general&lang=en&country=us&max=10&apikey=cdcaceb9a8ac1a4e8fa2ea126ead15e9

private val retrofit = Retrofit.Builder().baseUrl("https://gnews.io/api/v4/")
    .addConverterFactory(GsonConverterFactory.create()).build()

// Object to implement ApiService interface
val articleService = retrofit.create(ApiService::class.java)

interface ApiService {
    @GET("top-headlines")
    suspend fun getArticles(
        @Query("category") category: String,
        @Query("lang") language: String,
        @Query("country") country: String,
        @Query("max") maxResults: Int,
        @Query("apikey") apiKey: String
    ): Articles
}