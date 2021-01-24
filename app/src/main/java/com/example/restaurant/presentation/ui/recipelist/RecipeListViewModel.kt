package com.example.restaurant.presentation.ui.recipelist
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.restaurant.domain.model.Recipe
import com.example.restaurant.network.model.RecipeDtoMapper
import com.example.restaurant.repository.RecipeRepository


class RecipeListViewModel
@ViewModelInject
    constructor(
    private val randomString: String,
    private val repository:RecipeRepository,


    ): ViewModel(){
        init {

            println( "VIEWMODEL: $randomString")
            }
        }



