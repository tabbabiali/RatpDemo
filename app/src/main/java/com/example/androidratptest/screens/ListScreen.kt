package com.example.androidratptest.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androidratptest.AppViewModel
import com.example.androidratptest.models.Result

@Composable
fun ListScreen(appViewModel: AppViewModel) {
    when (val data = appViewModel.resultState.value) {
        is Result.ListResult -> {
            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                items(items = data.itemList) { item ->
                    Card {
                        Text(
                            text = item,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                }
            }
        }
        is Result.Error -> {
            Text(
                text = data.error,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
        }
    }

}