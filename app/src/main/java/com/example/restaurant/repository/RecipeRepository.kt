package com.example.restaurant.repository

import android.app.DownloadManager
import com.example.restaurant.domain.model.Recipe

interface RecipeRepository {
    suspend fun search(token:String, page:Int, query: String): List<Recipe>
    suspend fun get(toke: String, id:Int): Recipe
}