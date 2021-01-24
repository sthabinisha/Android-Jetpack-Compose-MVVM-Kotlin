package com.example.restaurant.network.model

import com.example.restaurant.domain.model.Recipe
import com.example.restaurant.domain.util.DomainMapper

class RecipeDtoMapper :DomainMapper<RecipeDTO, Recipe>{
    override fun mapToDomainModel(model: RecipeDTO): Recipe {
       return Recipe(
           id= model.pk,
           title = model.title,
           featuredImage = model.featuredImage,
           rating = model.rating,
           publisher = model.publisher,
           sourceUrl = model.sourceUrl,
           description = model.description,
           cookingInstruction = model.cookingInstructions,
           ingredients = model.ingredients?: listOf(),
           dateAdded = model.dateAdded,
           dateUpdated = model.dateUpdated
       )
    }

    override fun maptoEntity(domainModel: Recipe): RecipeDTO {
        return RecipeDTO(
            pk= domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            sourceUrl = domainModel.sourceUrl,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstruction,
            ingredients = domainModel.ingredients?: listOf(),
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated
        )
    }

    fun toDomailList(initial: List<RecipeDTO>): List<Recipe>{
        return initial.map{mapToDomainModel(it)}
    }

    fun fromDomainList(initial: List<Recipe>): List<RecipeDTO>{
        return initial.map{maptoEntity(it)}
    }


}