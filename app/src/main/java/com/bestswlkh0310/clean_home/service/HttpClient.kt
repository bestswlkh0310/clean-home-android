package com.bestswlkh0310.clean_home.service

import android.annotation.SuppressLint
import android.util.Log
import com.bestswlkh0310.clean_home.application.CleanHomeApplication
import com.bestswlkh0310.clean_home.service.api.ItemApi
import com.bestswlkh0310.clean_home.service.api.UserApi
import com.bestswlkh0310.clean_home.util.Json.isJsonArray
import com.bestswlkh0310.clean_home.util.Json.isJsonObject
import com.bestswlkh0310.clean_home.util.TAG
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@SuppressLint("TrustAllX509TrustManager")
object HttpClient {


    val gson = GsonBuilder().create()

    // loginInterceptor
    private val logInterceptor = HttpLoggingInterceptor { message ->
        Log.i(TAG, "Retrofit-Client : $message")
    }.setLevel(HttpLoggingInterceptor.Level.BODY)


    // httpClient
    val okHttpClient: OkHttpClient
        get() {
            val okHttpClientBuilder = OkHttpClient().newBuilder()
            okHttpClientBuilder.connectTimeout(3, TimeUnit.SECONDS)
            okHttpClientBuilder.readTimeout(3, TimeUnit.SECONDS)
            okHttpClientBuilder.writeTimeout(3, TimeUnit.SECONDS)
            okHttpClientBuilder.addInterceptor(logInterceptor)
            val trustAllCerts = arrayOf<TrustManager>(@SuppressLint("CustomX509TrustManager")
            object : X509TrustManager {
                override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
                override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
                override fun getAcceptedIssuers(): Array<X509Certificate> { return arrayOf() }
            })

            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())

            val sslSocketFactory = sslContext.socketFactory

            okHttpClientBuilder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            okHttpClientBuilder.hostnameVerifier { hostname, session -> true }


            okHttpClientBuilder.addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header("Authorization", "Bearer ${CleanHomeApplication.prefs.id}") // Replace YOUR_ACCESS_TOKEN with your actual access token
                val request = requestBuilder.build()
                chain.proceed(request)
            }

            return okHttpClientBuilder.build()
        }

    val retrofit = Retrofit.Builder()
        .baseUrl("http://clean-home-hhhello0507.koyeb.app/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    val userApi by lazy { retrofit.create(UserApi::class.java) }
    val itemApi by lazy { retrofit.create(ItemApi::class.java) }
}