package com.barryyang.barryyangdemo.kotlin.demo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

/**
 * @author : BarryYang
 * @date : 2020/9/15 10:37 AM
 * @desc :
 */
class LoginRepository {

    private val loginResponseParser by lazy { LoginResponseParser() }

    companion object {
        private const val loginUrl = "http://www.baidu.com"
    }

    suspend fun makeLoginRequest(jsonBody: String): Result<String> {
        return withContext(Dispatchers.IO) {
            val url = URL(loginUrl)
            val httpURLConnection = url.openConnection() as? HttpURLConnection
            httpURLConnection?.run {
                requestMethod = "GET"
//                setRequestProperty("Content-Type", "application/json; utf-8")
//                setRequestProperty("Accept", "application/json")
                doOutput = true
                outputStream.write(jsonBody.toByteArray())
                return@run Result.Success(loginResponseParser.parse(inputStream))
            } ?: return@withContext Result.Error(Exception("Cannot open HttpURLConnection"))
        }
    }
}