package com.example.restaurant.presentation.ui.recipelist
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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

        val recipes: MutableState<List<Recipe>> = mutableStateOf(listOf())
    val query = mutableStateOf("")
    val selectedCategoy: MutableState<FoodCategory?> = mutableStateOf(null)
    var categoryScrollPosition: Float = 0f

init{
    newSearch()

}
    fun newSearch() {
        viewModelScope.launch{
            val result = repository.search(
                token = token,
                page = 1,
                query = query.value,

            )
            recipes.value= result
        }
    }

    fun onQueryChanged(query: String){
        this.query.value = query
    }

    fun onSelectedCategoryChanged(category: String){
        val newCategory = getFoodCategory(category)
        selectedCategoy.value = newCategory
        onQueryChanged(category)
    }

    fun onChangeCategoryScrollPosition(position: Float){
        categoryScrollPosition= position
    }

}



