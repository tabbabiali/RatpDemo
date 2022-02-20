package com.example.androidratptest.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androidratptest.AppViewModel
import com.example.androidratptest.models.FormItemUI

@Composable
fun FormScreen(appViewModel: AppViewModel, navController: NavController) {
    var int1Input: String by rememberSaveable {
        mutableStateOf("")
    }
    var int2Input: String by rememberSaveable {
        mutableStateOf("")
    }
    var limitInput: String by rememberSaveable {
        mutableStateOf("")
    }
    var str1Input: String by rememberSaveable {
        mutableStateOf("")
    }
    var str2Input: String by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = int1Input,
            onValueChange = {
                int1Input = it
            },
            label = { Text("Int1") },
            modifier = Modifier
                .padding(16.dp, 16.dp, 16.dp)
                .fillMaxWidth()
        )
        TextField(
            value = int2Input,
            onValueChange = {
                int2Input = it
            },
            label = { Text("Int2") },
            modifier = Modifier
                .padding(16.dp, 16.dp, 16.dp)
                .fillMaxWidth()
        )
        TextField(
            value = limitInput,
            onValueChange = {
                limitInput = it
            },
            label = { Text("Limit") },
            modifier = Modifier
                .padding(16.dp, 16.dp, 16.dp)
                .fillMaxWidth()
        )
        TextField(
            value = str1Input,
            onValueChange = {
                str1Input = it
            },
            label = { Text("Str1") },
            modifier = Modifier
                .padding(16.dp, 16.dp, 16.dp)
                .fillMaxWidth()
        )
        TextField(
            value = str2Input,
            onValueChange = {
                str2Input = it
            },
            label = { Text("Str2") },
            modifier = Modifier
                .padding(16.dp, 16.dp, 16.dp)
                .fillMaxWidth()
        )

        Button(
            modifier = Modifier.padding(16.dp),
            onClick = {
                val formItem = FormItemUI(
                    int1Input.toIntOrNull(),
                    int2Input.toIntOrNull(),
                    limitInput.toIntOrNull(),
                    str1Input,
                    str2Input
                )
                appViewModel.updateFormItem(formItem)
                navController.navigate(Screens.LIST_SCREEN.name)
            },
        ) {
            Text(text = "Valider")
        }
    }
}