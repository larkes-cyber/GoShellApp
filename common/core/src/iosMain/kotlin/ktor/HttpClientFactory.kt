package ktor

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.darwin.Darwin

internal actual class HttpClientFactory actual constructor(){
    actual fun createHttpClient(config: HttpClientConfig<*>.()-> Unit):HttpClient = HttpClient(
        Darwin
    ){
        config()
        engine{
            configureRequest{
            }
        }
    }
}