package com.mumaralfajar.newsapp.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mumaralfajar.newsapp.utils.constants.Constants.EXCEPTION_LOG_KEY
import kotlinx.coroutines.CoroutineExceptionHandler

abstract class BaseViewModel : ViewModel() {

    protected val error = MutableLiveData(false)
    val errorLiveData: LiveData<Boolean>
        get() = error

    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e(EXCEPTION_LOG_KEY, exception.message.toString())
        error.value = true
    }

}