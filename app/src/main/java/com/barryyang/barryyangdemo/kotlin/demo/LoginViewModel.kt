package com.barryyang.barryyangdemo.kotlin.demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author : BarryYang
 * @date : 2020/9/15 10:42 AM
 * @desc :
 */
class LoginViewModel : ViewModel() {

    private val loginRepository by lazy {
        LoginRepository()
    }

    fun login(username: String, token: String) {
        viewModelScope.launch(Dispatchers.Main) {
            val jsonBody = "{ username: \"$username\", token: \"$token\"}"
            val result = try {
                loginRepository.makeLoginRequest(jsonBody)
            } catch (e: Exception) {
                Result.Error(Exception("Network request failed"))
            }
            when (result) {
                is Result.Success<*> -> println("// Happy path")
                else -> println("// Show error in UI")
            }
        }
    }
}