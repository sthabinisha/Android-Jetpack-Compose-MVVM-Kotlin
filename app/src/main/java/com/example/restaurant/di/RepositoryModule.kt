package com.example.restaurant.di

import com.example.restaurant.network.RecipeService
import com.example.restaurant.network.model.RecipeDtoMapper
import com.example.restaurant.repository.RecipeRepository
import com.example.restaurant.repository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {


    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
    recipeDtoMapper: RecipeDtoMapper
    ):RecipeRepository{
        return RecipeRepository_Impl(recipeService, recipeDtoMapper)
    }
}