package com.example.restaurant.presentation


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurant.R
import com.example.restaurant.presentation.BaseApplication
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG: String = "AppDebug"
    

    @Inject
    lateinit var randomString: String
    @Inject
    lateinit var app: BaseApplication
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("onCreate: the app context: ${app}")
        println("onCreate: ${randomString}")


    }
}