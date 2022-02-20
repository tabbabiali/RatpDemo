package com.example.androidratptest

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androidratptest.models.FormItemUI
import com.example.androidratptest.models.Result

class AppViewModel : ViewModel() {
    var resultState = mutableStateOf<Result>(Result.ListResult(emptyList()))
        private set

    fun updateFormItem(formItemUI: FormItemUI) {
        buildListItem(formItemUI)
    }

    private fun buildListItem(formItemUI: FormItemUI) {
        val resultList = mutableListOf<String>()
        with(formItemUI) {
            if (isFieldEmpty(formItemUI)) {
                resultState.value = Result.Error(ERROR_MSG)
                return
            }
            for (item in (1..formItemUI.limit!!)) {
                when {
                    item.mod(int1!!) == 0 && item.mod(int2!!) == 0 -> {
                        resultList.add(str1 + str2)
                    }
                    item.mod(int1!!) == 0 -> {
                        resultList.add(str1!!)
                    }
                    item.mod(int2!!) == 0 -> {
                        resultList.add(str2!!)
                    }
                    else -> {
                        resultList.add(item.toString())
                    }
                }
            }
        }
        resultState.value = Result.ListResult(resultList)
    }

    private fun isFieldEmpty(formItemUI: FormItemUI): Boolean {
        with(formItemUI) {
            return (int1 == null || int2 == null || limit == null
                    || str1.isNullOrEmpty() || str2.isNullOrEmpty())
        }
    }
    companion object{
        val  ERROR_MSG = "Form field cannot be null"
    }
}