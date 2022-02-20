package com.example.androidratptest.models

sealed class Result {
    class ListResult(val itemList: List<String>): Result()
    class Error(val error: String): Result()
}