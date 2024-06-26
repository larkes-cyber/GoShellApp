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
                connectTimeoutMillis = 15000
                requestTimeoutMillis = 30000
                requestTimeoutMillis = 10000
            }
            defaultRequest {
                url("http://10.0.46.245:8080")
            }
        }
    }
}