package com.example.restaurant


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurant.domain.model.Recipe
import com.example.restaurant.network.model.RecipeDTO
import com.example.restaurant.network.model.RecipeDtoMapper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG: String = "AppDebug"
    

    @Inject
    lateinit var someRandomString: String
    @Inject
    lateinit var app:BaseApplication
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: ${someRandomString}")

        val mapper = RecipeDtoMapper()
        val recipe = Recipe()
        val DTO: RecipeDTO= mapper.maptoEntity (recipe)
        val r: Recipe = mapper.mapToDomainModel(DTO)


//        val service = Retrofit.Builder()
//            .baseUrl("https://food2fork.ca/api/recipe/")
//            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//            .build()
//            .create(RecipeService::class.java)




//        setContent {
//            ScrollableColumn(modifier = Modifier
//                    .fillMaxHeight()
//                    .fillMaxWidth()
//                    .background(color = Color(0xFFF2F2F2))) {
//
//                Image(
//                    bitmap = imageFromResource(
//                        res = resources,
//                        resId = R.drawable.happy_meal
//                    ),
//                    modifier = Modifier.height(300.dp),
//                    contentScale = ContentScale.Crop,
//                )
//                Column(modifier = Modifier.padding(16.dp),) {
//                    Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.SpaceBetween
//
//                    ) {
//                        Text(text = "Happy Meal",
//                                style = TextStyle(
//                                        fontSize = TextUnit.Companion.Sp(26)
//                                )
//                        )
//                        Text(text = "$5.99",
//                                style = TextStyle(
//                                        color = Color.DarkGray,
//                                        fontSize = TextUnit.Companion.Sp(26)
//                                ),
//                                modifier = Modifier.align(Alignment.CenterVertically)
//                        )
//                    }
//
//                    Spacer(modifier = Modifier.padding(top = 16.dp))
//                    Text(text = "800 Calories")
//                    Spacer(modifier = Modifier.padding(top = 16.dp))
//                    Button(onClick = {  },
//                    modifier = Modifier.align(Alignment.CenterHorizontally)) {
//
//                    }
//
//
//                }
//            }
//
//
//        }
    }
}