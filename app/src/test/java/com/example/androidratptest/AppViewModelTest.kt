package com.example.androidratptest

import com.example.androidratptest.models.FormItemUI
import com.example.androidratptest.models.Result
import com.google.common.truth.Truth
import org.junit.Test

class AppViewModelTest{

    private val appViewModel = AppViewModel()

    @Test
    fun check_when_int1_is_null(){
        appViewModel.updateFormItem(FormItemUI(int1 = null))

        Truth.assertThat((appViewModel.resultState.value as Result.Error).error)
            .isEqualTo("Form field cannot be null")
    }

    @Test
    fun check_when_int2_is_null(){
        appViewModel.updateFormItem(FormItemUI(int2 = null))

        Truth.assertThat((appViewModel.resultState.value as Result.Error).error)
            .isEqualTo("Form field cannot be null")
    }

    @Test
    fun check_when_limit_is_null(){
        appViewModel.updateFormItem(FormItemUI(limit = null))

        Truth.assertThat((appViewModel.resultState.value as Result.Error).error)
            .isEqualTo("Form field cannot be null")
    }

    @Test
    fun check_when_str1_is_null(){
        appViewModel.updateFormItem(FormItemUI(str1 = null))

        Truth.assertThat((appViewModel.resultState.value as Result.Error).error)
            .isEqualTo("Form field cannot be null")
    }

    @Test
    fun check_when_str2_is_null(){
        appViewModel.updateFormItem(FormItemUI(str2 = null))

        Truth.assertThat((appViewModel.resultState.value as Result.Error).error)
            .isEqualTo("Form field cannot be null")
    }

    @Test
    fun check_item_list_when_form_values_not_null(){
        appViewModel.updateFormItem(FormItemUI(
            int1 = 2,
            int2 = 7,
            limit = 10,
            str1 = "word1",
            str2 = "word2"
        ))

        Truth.assertThat((appViewModel.resultState.value as Result.ListResult).itemList)
            .containsExactly("1" , "word1" , "3" , "word1" , "5" , "word1" , "word2",
                "word1" , "9" , "word1")
    }
}