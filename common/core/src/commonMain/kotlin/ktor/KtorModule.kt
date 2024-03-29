package ktor

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

internal val ktorModule = module {
    single {
        HttpClientFactory().createHttpClient {
            install(ContentNegotiation){
                json(Json{
                    prettyPrint = true
                    isLenient = true
                })
            }
            install(HttpTimeout){
                connectTimeoutMillis = 1500
                requestTimeoutMillis = 3000
                requestTimeoutMillis = 1000
            }
            defaultRequest {
                url("http://10.0.33.119:8080")
            }
        }
    }
}