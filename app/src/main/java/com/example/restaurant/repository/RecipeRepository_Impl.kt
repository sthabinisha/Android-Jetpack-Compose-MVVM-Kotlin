package com.example.restaurant.repository

import com.example.restaurant.domain.model.Recipe
import com.example.restaurant.network.RecipeService
import com.example.restaurant.network.model.RecipeDtoMapper

class RecipeRepository_Impl(
    private val recipeService: RecipeService,
    private val mapper:RecipeDtoMapper
) : RecipeRepository{
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {

//        val result= recipeService.search(token, page, query).recipes
        return mapper.toDomailList(recipeService.search(token, page, query).recipes);
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token,id ))
    }

}