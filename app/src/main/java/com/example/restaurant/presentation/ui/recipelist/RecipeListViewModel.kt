package com.example.restaurant.presentation.ui.recipelist
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigator
import com.example.restaurant.domain.model.Recipe
import com.example.restaurant.network.model.RecipeDtoMapper
import com.example.restaurant.repository.RecipeRepository
import kotlinx.coroutines.launch
import javax.inject.Named


class RecipeListViewModel
@ViewModelInject
    constructor(
    private val randomString: String,
    private val repository:RecipeRepository,
    private @Named("auth_token")val token:String,
    ): ViewModel() {

        private val _recipes: MutableLiveData<List<Recipe>> = MutableLiveData()
    val recipes: LiveData<List<Recipe>>  get() = _recipes

    init {
        viewModelScope.launch{
            val result = repository.search(
                token = token,
                page = 1,
                query = "chicken",

            )
            _recipes.value= result
        }
    }

}



